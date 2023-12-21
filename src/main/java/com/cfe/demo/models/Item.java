package com.cfe.demo.models;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement(name = "Item")
@XmlType(propOrder = {"NroLinDet", "IndFact", "NomItem", "Cantidad", "UniMedida", "PrecioUnitario", "MontoItem"})
public class Item {
    @XmlElement(name="NroLinDet")
    @Getter @Setter
    private Integer nroLinDet;

    @XmlElement(name="IndFact")
    @Getter @Setter
    private Integer indFact;

    @XmlElement(name="NomItem")
    @Getter @Setter
    private String nombreItem;

    @XmlElement(name="Cantidad")
    @Getter @Setter
    private Integer cantidad;

    @XmlElement(name="UniMedida")
    @Getter @Setter
    private String unidadMedida;

    @XmlElement(name="PrecioUnitario")
    @Getter @Setter
    private Integer precioUnitario;

    @XmlElement(name="MontoItem")
    @Getter @Setter
    private Integer montoItem;
}
