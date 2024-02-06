package com.cfe.demo.models;


import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name= "Encabezado")
@XmlType(propOrder={"IdDoc", "Emisor", "Receptor", "Totales"})
public class Encabezado {
    @XmlElement(name="IdDoc", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private IdDoc IdDoc;

    @XmlElement(name="Emisor", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private Emisor Emisor;

    @XmlElement(name="Receptor", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private Receptor Receptor;

    @XmlElement(name="Totales", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private Totales Totales;
}
