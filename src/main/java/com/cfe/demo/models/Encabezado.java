package com.cfe.demo.models;


import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;
@XmlRootElement(name = "Encabezado")
@XmlType(propOrder={"IdDoc", "Emisor", "Receptor", "Totaleas"})
public class Encabezado {
    @XmlElement(name="IdDoc")
    @Getter @Setter
    private IdDoc idDoc;

    @XmlElement(name="Emisor")
    @Getter @Setter
    private Emisor emisor;

    @XmlElement(name="Receptor")
    @Getter @Setter
    private Receptor receptor;

    @XmlElement(name="Totales")
    @Getter @Setter
    private Totales totales;
}
