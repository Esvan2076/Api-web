package com.webos.esvan.domain.carrito;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.webos.esvan.domain.producto.Producto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Carrito_Item")
public class CarritoItem {
    @EmbeddedId
    private CarritoItemId id;

    @MapsId("carritoId")
    @ManyToOne
    @JoinColumn(name = "carrito_id")
    @JsonBackReference
    private Carrito carrito;

    @MapsId("productoId")
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;
}
