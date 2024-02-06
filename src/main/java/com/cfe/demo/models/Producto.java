package com.cfe.demo.models;

import lombok.Getter;
import lombok.Setter;

public class Producto {
    @Getter @Setter
    private int id;

    @Getter @Setter
    private int cantidad;

    @Getter @Setter
    private String nombreProducto;

    @Getter @Setter
    private Integer precio;

    @Getter @Setter
    private int tasaIVA;
}
