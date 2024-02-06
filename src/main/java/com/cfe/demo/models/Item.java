package com.cfe.demo.models;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Item")
@XmlType(propOrder = {"NroLinDet", "IndFact", "NomItem", "Cantidad", "UniMedida", "PrecioUnitario", "MontoItem"})
public class Item {
    @XmlElement(name="NroLinDet", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private Integer NroLinDet;

    @XmlElement(name="IndFact", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private Integer IndFact;

    @XmlElement(name="NomItem", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private String NomItem;

    @XmlElement(name="Cantidad", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private Integer Cantidad;

    @XmlElement(name="UniMedida", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private String UniMedida;

    @XmlElement(name="PrecioUnitario", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private Integer PrecioUnitario;

    @XmlElement(name="MontoItem", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private Integer MontoItem;
}
