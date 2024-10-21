package com.webos.esvan.domain.carrito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webos.esvan.domain.carrito.Carrito;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long> {
    Carrito findByUsuarioIdUsuario(Long usuarioId);
}
