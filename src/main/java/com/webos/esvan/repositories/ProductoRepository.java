package com.webos.esvan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webos.esvan.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
