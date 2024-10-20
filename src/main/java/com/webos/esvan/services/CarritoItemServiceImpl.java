package com.webos.esvan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webos.esvan.entities.CarritoItem;
import com.webos.esvan.repositories.CarritoItemRepository;

@Service
public class CarritoItemServiceImpl implements CarritoItemService {

    @Autowired
    private CarritoItemRepository carritoItemRepository;

    @Override
    public List<CarritoItem> getAllItems() {
        return carritoItemRepository.findAll();
    }

    @Override
    public CarritoItem getItemById(Long id) {
        return carritoItemRepository.findById(id).orElse(null);
    }

    @Override
    public CarritoItem saveItem(CarritoItem item) {
        return carritoItemRepository.save(item);
    }

    @Override
    public void deleteItem(Long id) {
        carritoItemRepository.deleteById(id);
    }
}
