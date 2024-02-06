package com.cfe.demo.utils.marshallers;

import com.cfe.demo.models.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class XMLGenerator {

    /*public static void main(String[] args) {
        try {
            int cantidadItems = 4;
            XMLGenerator xmlGenerator = new XMLGenerator();
            xmlGenerator.generateAndSaveXML(cantidadItems);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }*/

    public void generateAndSaveXML(DatosCFE datosCFE) throws JAXBException {
    try {
        CFE cfe = new CFE();
        cfe.setVersion("1.0");

        ETck eTck = new ETck();
        eTck.setTmstFirma(fechaActual());

        Encabezado encabezado = new Encabezado();

        IdDoc idDoc = new IdDoc();
        idDoc.setTipoCFE(datosCFE.getTipoCFE());
        idDoc.setSerie("A");
        idDoc.setNro(1);
        idDoc.setFchEmis(fechaActual());
        idDoc.setMntBruto(1);
        idDoc.setFmaPago(datosCFE.getFormaPago());
        idDoc.setFchVenc(fechaVencimiento(fechaActual(), 365));

        Emisor emisor = new Emisor();
        emisor.setRUCEmisor("219999830019");
        emisor.setRznSoc("DGI RUC PRUEBA NO CEDE");
        emisor.setCdgDGISucur(1);
        emisor.setDomFiscal("Domicilio 123");
        emisor.setCiudad("Montevideo");
        emisor.setDepartamento("Montevideo");

        Receptor receptor = new Receptor();
        receptor.setTipoDocRecep(3);
        receptor.setCodPaisRecep(datosCFE.getTipoDocumento());
        receptor.setDocRecep(datosCFE.getDocumento());
        receptor.setRznSocRecep(datosCFE.getCliente());
        receptor.setDirRecep("18 de Julio 2016");
        receptor.setCiudadRecep("Montevideo");
        receptor.setDeptoRecep("Montevideo");

        Totales totales = new Totales();
        totales.setTpoMoneda(datosCFE.getMoneda());
        totales.setMntNoGrv(420);
        totales.setMntNetoIvaTasaMin(360);
        totales.setMntNetoIVATasaBasica(137704.92);
        totales.setIVATasaMin(10);
        totales.setIVATasaBasica(22);
        totales.setMntIVATasaMin(36);
        totales.setMntIVATasaBasica(30295.08);
        totales.setMntTotal(datosCFE.getTotal());
        totales.setCantLinDet(3);
        totales.setMntPagar(datosCFE.getTotal());

        encabezado.setIdDoc(idDoc);
        encabezado.setEmisor(emisor);
        encabezado.setReceptor(receptor);
        encabezado.setTotales(totales);

        ArrayList<Item> detalle = new ArrayList();

        for (int i = 0; i < datosCFE.getCantidad(); i++) {
            Item item = new Item();
            item.setNroLinDet(3);
            item.setIndFact(2);
            item.setNomItem(datosCFE.getProducto().get(i).getNombreProducto());
            item.setCantidad(datosCFE.getProducto().get(i).getCantidad());
            item.setUniMedida("kg");
            item.setPrecioUnitario(datosCFE.getProducto().get(i).getCantidad());
            item.setMontoItem(3291);

            detalle.add(item);
        }

        CAEData caeData = new CAEData();
        caeData.setCAE_ID(1234567890);
        caeData.setDNro(1);
        caeData.setHNro(100);
        caeData.setFecVenc(fechaVencimiento(fechaActual(), 365));

        eTck.setEncabezado(encabezado);
        eTck.setDetalle(detalle);
        eTck.setCAEData(caeData);

        cfe.setETck(eTck);

        JAXBContext context = JAXBContext.newInstance(CFE.class);
        Marshaller marshaller = context.createMarshaller();

        StringWriter writer = new StringWriter();
        marshaller.marshal(cfe, writer);

        File outputDirectory = new File("src/main/resources/static");
        outputDirectory.mkdirs();

        File outputFile = new File(outputDirectory, "CFE.xml");

        marshaller.marshal(cfe, outputFile);

        System.out.println("XML generado y guardado en: " + outputFile.getAbsolutePath());
    } catch (JAXBException e) {
        e.printStackTrace();
    }
    }

    public static String fechaActual() {
        Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaFormateada = formato.format(fechaActual);
        return fechaFormateada;
    }

    public static String fechaVencimiento(String fechaEmision, int duracionDias) {
        try {
            // convertir la fecha de emisiòn a un objeto Date
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaEmisionDate = formato.parse(fechaEmision);

            // crear un objeto Calendar y establecer la fecha de emisión
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaEmisionDate);

            // sumar la duración de días para obtener la fecha de vencimiento
            calendar.add(Calendar.DAY_OF_MONTH, duracionDias);

            // obtener la fecha de vencimiento formateada
            Date fechaVencimientoDate = calendar.getTime();
            String fechaVencimeinto = formato.format(fechaVencimientoDate);

            return fechaVencimeinto;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
