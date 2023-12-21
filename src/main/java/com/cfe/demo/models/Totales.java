package com.cfe.demo.models;

import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.Setter;

public class Totales {
    @XmlElement(name="TpoMoneda")
    @Getter @Setter
    private String tipoMoneda; // ALPHA 3

    @XmlElement(name="MntNoGrv")
    @Getter @Setter
    private Integer montoNoGrv; // NUM 17

    @XmlElement(name="MntNetoIvaTasaMin")
    @Getter @Setter
    private Integer mntNetoIvaTasaMin;

    @XmlElement(name="MntNetoIVATasaBasica")
    @Getter @Setter
    private Double mntNetoIvaTasaBasica;

    @XmlElement(name="IVATasaMin")
    @Getter @Setter
    private Integer ivaTasaMin;

    @XmlElement(name="IVATasaBasica")
    @Getter @Setter
    private Integer ivaTasaBasica;

    @XmlElement(name="MntIVATasaMin")
    @Getter @Setter
    private Integer montoIvaTasaMin;

    @XmlElement(name="MntIVATasaBasica")
    @Getter @Setter
    private Double montoIvaTasaBasica;

    @XmlElement(name="MntTotal")
    @Getter @Setter
    private Integer montoTotal;

    @XmlElement(name="CantLinDet")
    @Getter @Setter
    private Integer cantLinDet;

    @XmlElement(name="MntPagar")
    @Getter @Setter
    private Integer montoPagar;
}
