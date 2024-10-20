package com.webos.esvan.services;

import java.util.List;

import com.webos.esvan.entities.Producto;

public interface ProductoService {
    List<Producto> getAllProductos();

    Producto getProductoById(Long id);

    Producto saveProducto(Producto producto);

    void deleteProducto(Long id);
}
