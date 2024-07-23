package com.cfe.demo.models;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"TmstFirma", "Encabezado", "Detalle", "CAEData"})
public class ETck {

    @XmlElement(name = "TmstFirma")
    @Getter @Setter
    private String TmstFirma;

    @XmlElement(name="Encabezado")
    @Getter @Setter
    private Encabezado Encabezado;

    @XmlElementWrapper(name= "Detalle")
    @XmlElement(name="Item")
    @Getter @Setter
    private ArrayList<Item> Detalle;

    @XmlElement(name="CAEData")
    @Getter @Setter
    private CAEData CAEData;

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