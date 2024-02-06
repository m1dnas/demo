package com.cfe.demo.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name= "IdDoc")
@XmlType(propOrder = {"TipoCFE", "Serie", "Nro", "FchEmis", "MntBruto", "FmaPago", "FchVenc"})
public class IdDoc {
    @XmlElement(name="TipoCFE", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private Integer TipoCFE;

    @XmlElement(name="Serie", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private String Serie; // ALPHA 2

    @XmlElement(name="Nro", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private Integer Nro; // NUM 7 - asignado al comprobante; 1 <= nro <= 9999999

    @XmlElement(name="FchEmis", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private String FchEmis; // (2013-05-11) - fecha del comprobante; hacer función

    @XmlElement(name="MntBruto", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private int MntBruto; // NUM 1

    @XmlElement(name="FmaPago", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private int FmaPago; // NUM 1

    @XmlElement(name="FchVenc", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private String FchVenc; // (2013-08-21)
}
