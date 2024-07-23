package com.cfe.demo.models;


import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name= "Encabezado", propOrder={"IdDoc", "Emisor", "Receptor", "Totales"})
public class Encabezado {
    @XmlElement(name="IdDoc")
    @Getter @Setter
    private IdDoc IdDoc;

    @XmlElement(name="Emisor")
    @Getter @Setter
    private Emisor Emisor;

    @XmlElement(name="Receptor")
    @Getter @Setter
    private Receptor Receptor;

    @XmlElement(name="Totales")
    @Getter @Setter
    private Totales Totales;
}
