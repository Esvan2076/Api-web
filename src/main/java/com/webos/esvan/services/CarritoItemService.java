package com.webos.esvan.services;

import java.util.List;

import com.webos.esvan.entities.CarritoItem;

public interface CarritoItemService {
    List<CarritoItem> getAllItems();

    CarritoItem getItemById(Long id);

    CarritoItem saveItem(CarritoItem item);

    void deleteItem(Long id);
}
