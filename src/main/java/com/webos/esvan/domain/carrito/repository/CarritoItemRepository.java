package com.webos.esvan.domain.carrito.repository;

import com.webos.esvan.domain.carrito.CarritoItemId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webos.esvan.domain.carrito.CarritoItem;

import java.util.List;

@Repository
public interface CarritoItemRepository extends JpaRepository<CarritoItem, CarritoItemId> {
    List<CarritoItem> findByProductoIdProducto(Long productoId);
}
