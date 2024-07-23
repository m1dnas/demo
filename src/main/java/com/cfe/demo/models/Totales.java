package com.cfe.demo.models;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Totales", namespace = "http://cfe.dgi.gub.uy", propOrder = {
        "TpoMoneda",
        "MntNoGrv",
        "MntNetoIvaTasaMin",
        "MntNetoIVATasaBasica",
        "IVATasaMin",
        "IVATasaBasica",
        "MntIVATasaMin",
        "MntIVATasaBasica",
        "MntTotal",
        "CantLinDet",
        "MntPagar"
})
public class Totales {
    @XmlElement(name="TpoMoneda")
    @Getter @Setter
    private String TpoMoneda; // ALPHA 3

    @XmlElement(name="MntNoGrv")
    @Getter @Setter
    private Integer MntNoGrv; // NUM 17

    @XmlElement(name="MntNetoIvaTasaMin")
    @Getter @Setter
    private Integer MntNetoIvaTasaMin;

    @XmlElement(name="MntNetoIVATasaBasica")
    @Getter @Setter
    private Double MntNetoIVATasaBasica;

    @XmlElement(name="IVATasaMin")
    @Getter @Setter
    private Integer IVATasaMin;

    @XmlElement(name="IVATasaBasica")
    @Getter @Setter
    private Integer IVATasaBasica;

    @XmlElement(name="MntIVATasaMin")
    @Getter @Setter
    private Integer MntIVATasaMin;

    @XmlElement(name="MntIVATasaBasica")
    @Getter @Setter
    private Double MntIVATasaBasica;

    @XmlElement(name="MntTotal")
    @Getter @Setter
    private Integer MntTotal;

    @XmlElement(name="CantLinDet")
    @Getter @Setter
    private Integer CantLinDet;

    @XmlElement(name="MntPagar")
    @Getter @Setter
    private Integer MntPagar;
}
