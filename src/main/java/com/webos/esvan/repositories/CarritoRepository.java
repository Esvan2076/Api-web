package com.webos.esvan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webos.esvan.entities.Carrito;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long> {
    
}
