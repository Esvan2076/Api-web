package com.webos.esvan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webos.esvan.entities.PedidoDetalle;
import com.webos.esvan.repositories.PedidoDetalleRepository;

@Service
public class PedidoDetalleServiceImpl implements PedidoDetalleService {

    @Autowired
    private PedidoDetalleRepository pedidoDetalleRepository;

    @Override
    public List<PedidoDetalle> getAllDetalles() {
        return pedidoDetalleRepository.findAll();
    }

    @Override
    public PedidoDetalle getDetalleById(Long id) {
        return pedidoDetalleRepository.findById(id).orElse(null);
    }

    @Override
    public PedidoDetalle saveDetalle(PedidoDetalle detalle) {
        return pedidoDetalleRepository.save(detalle);
    }

    @Override
    public void deleteDetalle(Long id) {
        pedidoDetalleRepository.deleteById(id);
    }
}
