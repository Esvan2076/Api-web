package com.webos.esvan.domain.pedido.service;

import java.util.List;

import com.webos.esvan.domain.pedido.PedidoDetalle;

public interface PedidoDetalleService {
    List<PedidoDetalle> getAllDetalles();

    PedidoDetalle getDetalleById(Long id);

    PedidoDetalle saveDetalle(PedidoDetalle detalle);
    
    void deleteDetalle(Long id);
}
