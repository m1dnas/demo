package com.cfe.demo.models;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Item", propOrder = {"NroLinDet", "IndFact", "NomItem", "Cantidad", "UniMedida", "PrecioUnitario", "MontoItem"})
public class Item {
    @XmlElement(name="NroLinDet")
    @Getter @Setter
    private Integer NroLinDet;

    @XmlElement(name="IndFact")
    @Getter @Setter
    private Integer IndFact;

    @XmlElement(name="NomItem")
    @Getter @Setter
    private String NomItem;

    @XmlElement(name="Cantidad")
    @Getter @Setter
    private Integer Cantidad;

    @XmlElement(name="UniMedida")
    @Getter @Setter
    private String UniMedida;

    @XmlElement(name="PrecioUnitario")
    @Getter @Setter
    private Integer PrecioUnitario;

    @XmlElement(name="MontoItem")
    @Getter @Setter
    private Integer MontoItem;
}
