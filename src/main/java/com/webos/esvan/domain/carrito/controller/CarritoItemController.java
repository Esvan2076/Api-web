/*package com.webos.esvan.domain.carrito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webos.esvan.domain.carrito.CarritoItem;
import com.webos.esvan.domain.carrito.service.CarritoItemService;

@RestController
@RequestMapping("/api/carrito-item")
public class CarritoItemController {

    @Autowired
    private CarritoItemService carritoItemService;

    @GetMapping
    public List<CarritoItem> getAllItems() {
        return carritoItemService.getAllItems();
    }

    @GetMapping("/{id}")
    public CarritoItem getItemById(@PathVariable Long id) {
        return carritoItemService.getItemById(id);
    }

    @PostMapping
    public CarritoItem saveItem(@RequestBody CarritoItem item) {
        return carritoItemService.saveItem(item);
    }

    @PutMapping("/{id}")
    public CarritoItem updateItem(@PathVariable Long id, @RequestBody CarritoItem item) {
        CarritoItem existingItem = carritoItemService.getItemById(id);
        if (existingItem != null) {
            item.setIdCarritoItem(id);
            return carritoItemService.saveItem(item);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        carritoItemService.deleteItem(id);
    }
}*/
