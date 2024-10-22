package com.webos.esvan.domain.producto.service;

import java.util.List;

import com.webos.esvan.domain.producto.Producto;

public interface ProductoService {
    List<Producto> getAllProductos();

    Producto getProductoById(Long id);

    Producto saveProducto(Producto producto);

    void deleteProducto(Long id);
}
