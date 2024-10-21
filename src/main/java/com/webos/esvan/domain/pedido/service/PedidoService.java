package com.webos.esvan.domain.pedido.service;

import java.util.List;

import com.webos.esvan.domain.pedido.Pedido;

public interface PedidoService {
    List<Pedido> getAllPedidos();

    Pedido getPedidoById(Long id);

    Pedido savePedido(Pedido pedido);
    
    void deletePedido(Long id);
}
