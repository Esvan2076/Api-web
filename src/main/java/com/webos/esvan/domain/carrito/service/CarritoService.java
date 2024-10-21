package com.webos.esvan.domain.carrito.service;

import java.util.List;

import com.webos.esvan.domain.carrito.Carrito;

public interface CarritoService {
    List<Carrito> getAllCarritos();

    Carrito getCarritoById(Long id);

    Carrito saveCarrito(Carrito carrito);
    
    void deleteCarrito(Long id);
}
