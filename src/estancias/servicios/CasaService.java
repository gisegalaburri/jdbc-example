/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias.servicios;

import estancias.dao.CasaDAO;
import estancias.entidades.Casa;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Gisele Galaburri <gisele.galaburri89 at gmail.com>
 */
public class CasaService {

    public static void buscarCasasRangoFechasYPais(Date fechaInicial, Date fechaFinal, String pais, ArrayList<Casa> casas) throws Exception {
        CasaDAO dao = new CasaDAO();

        try {

            if (fechaInicial == null) {
                throw new Exception("Debe indicar una fecha inicial");
            }

            if (fechaFinal == null) {
                throw new Exception("Debe indicar una fecha final");
            }

            if (pais.isEmpty()) {
                throw new Exception("Debe indicar el pais");
            }

            dao.buscarCasasRangoFechasYPais(fechaInicial, fechaFinal, pais, casas);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void buscarCasaDiasEspecif(Date fecha, Integer dias, ArrayList<Casa> casas) throws Exception {
        CasaDAO dao = new CasaDAO();

        try {
            if (fecha == null || fecha.toString().isEmpty()) {
                throw new Exception("Debe indicar una fecha");
            }

            if (dias == null) {
                throw new Exception("Debe indicar los dias");
            }

            dao.buscarCasaDiasEspecif(fecha, dias, casas);

        } catch (Exception e) {
        }

    }

    public static void incrementarPrecio(Double incremento, String pais) throws Exception {
        CasaDAO dao = new CasaDAO();

        try {
            if (incremento == null) {
                throw new Exception("Debe indicar un porcentaje de aumento");
            }

            if (pais.isEmpty()) {
                throw new Exception("Debe indicar el pais");
            }

            dao.incrementarPrecio(incremento, pais);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public static void mostrarCasas(ArrayList<Casa> c) {
        for (Casa casa : c) {
            System.out.println(casa);
        }
    }

    public static void consultarCasasPorPais(String pais, ArrayList<Casa> c) throws Exception {
        CasaDAO dao = new CasaDAO();

        try {
            if (pais.isEmpty()) {
                throw new Exception("Debe indicar el pais");
            }

            dao.consultarCasasPorPais(pais, c);

            for (Casa casa : c) {
                System.out.println("ID: " + casa.getId_casa() + ". Precio: "
                        + casa.getPrecio_habitacion() + ". Pais: " + casa.getPais());
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public static void contarCasasPorPais(ArrayList<String> casas) throws Exception {
        CasaDAO dao = new CasaDAO();
        try {
            dao.contarCasasPorPais(casas);

            for (String string : casas) {
                System.out.println(string);
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public static void buscarSegunComentarioYPais(String palabra, String pais, ArrayList<Casa> casa) throws Exception {
        CasaDAO dao = new CasaDAO();

        try {
            if (palabra == null || palabra.isEmpty()) {
                throw new Exception("Debe indicar palabra a buscar");
            }
            
            if (pais == null || pais.isEmpty()) {
                throw new Exception("Debe indicar el pais");
            }
            
        } catch (Exception e) {
            throw e;
        }
    }
}
