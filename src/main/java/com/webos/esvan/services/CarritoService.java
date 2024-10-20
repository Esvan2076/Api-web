package com.webos.esvan.services;

import java.util.List;

import com.webos.esvan.entities.Carrito;

public interface CarritoService {
    List<Carrito> getAllCarritos();

    Carrito getCarritoById(Long id);

    Carrito saveCarrito(Carrito carrito);
    
    void deleteCarrito(Long id);
}
