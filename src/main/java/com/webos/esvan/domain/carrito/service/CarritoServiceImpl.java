package com.webos.esvan.domain.carrito.service;

import java.util.List;
import java.util.Optional;

import com.webos.esvan.domain.carrito.CarritoItem;
import com.webos.esvan.domain.carrito.CarritoItemId;
import com.webos.esvan.domain.carrito.repository.CarritoItemRepository;
import com.webos.esvan.domain.producto.Producto;
import com.webos.esvan.domain.producto.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webos.esvan.domain.carrito.Carrito;
import com.webos.esvan.domain.carrito.repository.CarritoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarritoServiceImpl {

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private CarritoItemRepository carritoItemRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Transactional(readOnly = true)
    public Carrito obtenerCarritoPorUsuario(Long usuarioId) {
        // Busca el carrito del usuario
        Carrito carrito = carritoRepository.findByUsuarioIdUsuario(usuarioId);

        // Si el carrito es nulo, retornar uno nuevo o manejar el error.
        if (carrito == null) {
            throw new IllegalArgumentException("Carrito no encontrado para el usuario.");
        }

        // Inicializar la lista de productos para evitar LazyInitializationException
        carrito.getProductos().size(); // Forzar la inicialización de la colección

        return carrito;
    }

    /**
     * Agrega un producto al carrito o actualiza la cantidad si ya existe
     */
    public CarritoItem agregarProductoACarrito(CarritoItemId itemId, Integer cantidad) {
        Carrito carrito = carritoRepository.findByUsuarioIdUsuario(itemId.getCarritoId());
        if (carrito == null) {
            throw new IllegalArgumentException("Carrito no encontrado para el usuario.");
        }

        Producto producto = productoRepository.findById(itemId.getProductoId())
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

        Optional<CarritoItem> carritoItemExistente = carritoItemRepository.findById(itemId);

        if (carritoItemExistente.isPresent()) {
            CarritoItem carritoItem = carritoItemExistente.get();
            carritoItem.setCantidad(carritoItem.getCantidad() + cantidad);
            return carritoItemRepository.save(carritoItem);
        } else {
            CarritoItem carritoItem = new CarritoItem();
            carritoItem.setId(itemId);
            carritoItem.setCarrito(carrito);
            carritoItem.setProducto(producto);
            carritoItem.setCantidad(cantidad);

            return carritoItemRepository.save(carritoItem);
        }
    }

    /**
     * Elimina un producto del carrito dado su ID
     */
    public void eliminarProductoDeCarrito(CarritoItemId id) {
        carritoItemRepository.deleteById(id);
    }

    @Transactional
    public void vaciarCarrito(Long usuarioId) {
        Carrito carrito = carritoRepository.findByUsuarioIdUsuario(usuarioId);

        if (carrito == null) {
            throw new IllegalArgumentException("Carrito no encontrado para el usuario.");
        }

        // Limpiar la lista de productos del carrito
        carrito.getProductos().clear();
        carritoRepository.save(carrito);
    }

    @Transactional
    public void eliminarProductoDeCarritoSiOculto(Long productoId) {
        // Buscar todos los items del carrito que contienen el producto
        List<CarritoItem> items = carritoItemRepository.findByProductoIdProducto(productoId);

        // Eliminar cada uno de esos carrito items
        for (CarritoItem item : items) {
            carritoItemRepository.delete(item);
        }
    }
}
