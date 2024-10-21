package com.webos.esvan.domain.carrito.controller;

import java.util.List;

import com.webos.esvan.domain.carrito.CarritoItem;
import com.webos.esvan.domain.carrito.CarritoItemId;
import com.webos.esvan.domain.carrito.service.CarritoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.webos.esvan.domain.carrito.Carrito;
import com.webos.esvan.domain.carrito.service.CarritoService;

@RestController
@RequestMapping("/api/carrito")
public class CarritoController {

    @Autowired
    private CarritoServiceImpl carritoService;

    // Obtener el carrito de un usuario
    @GetMapping("/{usuarioId}")
    public ResponseEntity<Carrito> obtenerCarrito(@PathVariable Long usuarioId) {
        Carrito carrito = carritoService.obtenerCarritoPorUsuario(usuarioId);

        if (carrito == null || carrito.getProductos().isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(carrito);
    }

    // Agregar un producto al carrito
    @PostMapping
    public ResponseEntity<CarritoItem> agregarProductoACarrito(@RequestBody CarritoItemId itemId, @RequestParam Integer cantidad) {
        // Llamar al servicio para agregar el producto con la cantidad indicada
        CarritoItem carritoItem = carritoService.agregarProductoACarrito(itemId, cantidad);
        return ResponseEntity.ok(carritoItem);
    }

    // Eliminar un producto del carrito
    @DeleteMapping("/{carritoId}/{productoId}")
    public ResponseEntity<Void> eliminarProductoDeCarrito(@PathVariable Long carritoId, @PathVariable Long productoId) {
        CarritoItemId id = new CarritoItemId(carritoId, productoId);
        carritoService.eliminarProductoDeCarrito(carritoId);
        return ResponseEntity.noContent().build();
    }

    // Metodo para vaciar el carrito de un usuario
    @DeleteMapping("/{usuarioId}/vaciar")
    public ResponseEntity<Void> vaciarCarrito(@PathVariable Long usuarioId) {
        carritoService.vaciarCarrito(usuarioId);
        return ResponseEntity.noContent().build();
    }
}
