package com.cfe.demo.utils.marshallers;

import com.cfe.demo.models.CFE;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class XMLGenerator {
    public XMLGenerator(Integer cantItems) throws JAXBException {
        JAXBContext jaxbcontext = JAXBContext.newInstance(CFE.class);
        Marshaller marshaller = jaxbcontext.createMarshaller();

        CFE cfe = new CFE();

        // item
        for (int i = 0; i < cantItems; i++) {

        }


        // todos los set con contenido dinámico o funciones creadas


        File output = new File("src/"); // dirección donde se almacena

        marshaller.marshal(cfe, output);
    }

    public static String obtenerFechaActual() {
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
