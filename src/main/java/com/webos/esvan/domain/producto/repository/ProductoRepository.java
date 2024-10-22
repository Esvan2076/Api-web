package com.webos.esvan.domain.producto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webos.esvan.domain.producto.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
