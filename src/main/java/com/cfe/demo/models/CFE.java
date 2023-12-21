package com.cfe.demo.models;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement(name = "CFE")
@XmlType(propOrder={"Encabezaado, Detalle, CAEData"})
public class CFE {
    @Getter @Setter
    private int id;

    @XmlElement(name="Encabezado")
    @Getter @Setter
    private Encabezado encabezado;

    @XmlElementWrapper(name="Detalle")
    @XmlElement(name="Item")
    @Getter @Setter
    private Detalle detalle;

    @XmlElement(name="CAEData")
    @Getter @Setter
    private CAEData caeData;

    // ** EMPIEZA ENCABEZADO **

    // >> ÁREA IDENTIFICACIÓN DEL COMPROBANTE <<


    // >> ÁREA EMISOR <<


    // >> ÁREA RECEPTOR <<


    // ** TERMINA ENCABEZADO **
    // ** EMPIEZA DETALLE **

    // >> ÁREA ITEM << (pueden haber varios items)

    // ** TERMINA DETALLE **
    // ** EMPIEZA CAE Data **


    // PÁG 48 FORMATO CFE ENCABEZADO TERMINO, EMPIEZA DETALLE
}