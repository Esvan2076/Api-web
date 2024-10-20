package com.webos.esvan.services;

import java.util.List;

import com.webos.esvan.entities.Pedido;

public interface PedidoService {
    List<Pedido> getAllPedidos();

    Pedido getPedidoById(Long id);

    Pedido savePedido(Pedido pedido);
    
    void deletePedido(Long id);
}
