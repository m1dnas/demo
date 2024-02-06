package com.cfe.demo.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class DatosCFE {
    @Getter @Setter
    private int tipoCFE;

    @Getter @Setter
    private int formaPago;

    @Getter @Setter
    private String moneda;

    @Getter @Setter
    private String cliente;

    @Getter @Setter
    private String tipoDocumento;

    @Getter @Setter
    private Integer documento;

    @Getter @Setter
    private int cantidad;

    @Getter @Setter
    private List<Producto> producto;

    @Getter @Setter
    private Integer total;
}
