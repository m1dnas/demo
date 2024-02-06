package com.cfe.demo.models;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name= "eTck")
@XmlType(propOrder={"TmstFirma", "Encabezado", "Detalle", "CAEData"})
public class ETck {

    @XmlElement(name = "TmstFirma", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private String TmstFirma;

    @XmlElement(name="Encabezado", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private Encabezado Encabezado;

    @XmlElementWrapper(name= "Detalle", namespace = "http://cfe.dgi.gub.uy")
    @XmlElement(name="Item")
    @Getter @Setter
    private ArrayList<Item> Detalle;

    @XmlElement(name="CAEData", namespace = "http://cfe.dgi.gub.uy")
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