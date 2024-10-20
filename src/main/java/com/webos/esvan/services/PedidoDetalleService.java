package com.webos.esvan.services;

import java.util.List;

import com.webos.esvan.entities.PedidoDetalle;

public interface PedidoDetalleService {
    List<PedidoDetalle> getAllDetalles();

    PedidoDetalle getDetalleById(Long id);

    PedidoDetalle saveDetalle(PedidoDetalle detalle);
    
    void deleteDetalle(Long id);
}
