package com.webos.esvan.domain.carrito.service;

import java.util.List;

import com.webos.esvan.domain.carrito.CarritoItem;

public interface CarritoItemService {
    List<CarritoItem> getAllItems();

    CarritoItem getItemById(Long id);

    CarritoItem saveItem(CarritoItem item);

    void deleteItem(Long id);
}
