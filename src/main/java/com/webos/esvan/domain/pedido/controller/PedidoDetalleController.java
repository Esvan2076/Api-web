package com.webos.esvan.domain.pedido.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webos.esvan.domain.pedido.PedidoDetalle;
import com.webos.esvan.domain.pedido.service.PedidoDetalleService;

@RestController
@RequestMapping("/api/pedido-detalle")
public class PedidoDetalleController {

    @Autowired
    private PedidoDetalleService pedidoDetalleService;

    @GetMapping
    public List<PedidoDetalle> getAllDetalles() {
        return pedidoDetalleService.getAllDetalles();
    }

    @GetMapping("/{id}")
    public PedidoDetalle getDetalleById(@PathVariable Long id) {
        return pedidoDetalleService.getDetalleById(id);
    }

    @PostMapping
    public PedidoDetalle saveDetalle(@RequestBody PedidoDetalle detalle) {
        return pedidoDetalleService.saveDetalle(detalle);
    }

    @DeleteMapping("/{id}")
    public void deleteDetalle(@PathVariable Long id) {
        pedidoDetalleService.deleteDetalle(id);
    }
}
