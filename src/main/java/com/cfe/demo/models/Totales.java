package com.cfe.demo.models;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Totales")
@XmlType(propOrder={"TpoMoneda", "MntNoGrv", "MntNetoIvaTasaMin", "MntNetoIVATasaBasica", "IVATasaMin", "IVATasaBasica", "MntIVATasaMin", "MntIVATasaBasica", "MntTotal", "CantLinDet", "MntPagar"})
public class Totales {
    @XmlElement(name="TpoMoneda", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private String TpoMoneda; // ALPHA 3

    @XmlElement(name="MntNoGrv", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private Integer MntNoGrv; // NUM 17

    @XmlElement(name="MntNetoIvaTasaMin", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private Integer MntNetoIvaTasaMin;

    @XmlElement(name="MntNetoIVATasaBasica", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private Double MntNetoIVATasaBasica;

    @XmlElement(name="IVATasaMin", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private Integer IVATasaMin;

    @XmlElement(name="IVATasaBasica", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private Integer IVATasaBasica;

    @XmlElement(name="MntIVATasaMin", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private Integer MntIVATasaMin;

    @XmlElement(name="MntIVATasaBasica", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private Double MntIVATasaBasica;

    @XmlElement(name="MntTotal", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private Integer MntTotal;

    @XmlElement(name="CantLinDet", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private Integer CantLinDet;

    @XmlElement(name="MntPagar", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private Integer MntPagar;
}
