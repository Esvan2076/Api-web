package com.webos.esvan.domain.pedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webos.esvan.domain.pedido.PedidoDetalle;

@Repository
public interface PedidoDetalleRepository extends JpaRepository<PedidoDetalle, Long> {
}
