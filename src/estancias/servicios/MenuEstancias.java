/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias.servicios;

import estancias.entidades.Casa;
import estancias.entidades.Estancia;
import estancias.entidades.Familia;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Gisele Galaburri <gisele.galaburri89 at gmail.com>
 */
public class MenuEstancias {

    public static void menu() {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        Integer opc = 999;

        while (opc != 0) {
            System.out.println("Elija una opcion");
            System.out.println("1. Mostrar familias que tienen al menos 3 hijos, y con"
                    + " edad máxima inferior a 10 años.");
            System.out.println("2. Listar las casas disponibles para el"
                    + " periodo comprendido entre el 1 de agosto de 2020 y el "
                    + "31 de agosto de 2020 en Reino Unido.");
            System.out.println("3. Mostrar familias cuyo nombre termine en 'y'");
            System.out.println("4. Mostrar todas aquellas familias cuya "
                    + "dirección de mail sea de Hotmail.");
            System.out.println("5. Mostrar casas disponibles a partir de una "
                    + "fecha dada y un número de días específico.");
            System.out.println("6. Listar los datos de todos los clientes que "
                    + "en algún momento realizaron una estancia y la "
                    + "descripción de la casa donde la realizaron.");
            System.out.println("7. Incrementar el precio por día en un 5% de "
                    + "odas las casas del Reino Unido. Mostar los precios "
                    + "actualizados.");
            System.out.println("8. Obtener el número de casas que existen para "
                    + "cada uno de los países diferentes.");
            System.out.println("9. Busca y listar aquellas casas del Reino Unido "
                    + "de las que se ha dicho de ellas (comentarios) que están "
                    + "‘limpias’.");
            System.out.println("10. Insertar nuevos datos en la tabla estancias "
                    + "verificando la disponibilidad de las fechas.");
            System.out.println("0. Salir");

            try {
                opc = sc.nextInt();

                switch (opc) {
                    case 0:
                        System.out.println("Hasta la proxima!");
                        break;
                    case 1:
                        ArrayList<Familia> familiasArrayL = new ArrayList();
                        FamiliaService.buscarFamiliaPorHijosYEdad(3, 10, familiasArrayL);
                        FamiliaService.mostrarFamilias(familiasArrayL);
                        break;
                    case 2:
                        ArrayList<Casa> casasEntreFechas = new ArrayList();
                        //a los date le resto 1900 porque empiezan el 1900 (sino no lo resto se suma
                        //a los meses le resto 1 porque empiezan en 0
                        Date fechaInicial = new Date(2020 - 1900, 07, 01);
                        Date fechaFinal = new Date(2020 - 1900, 07, 31);
                        CasaService.buscarCasasRangoFechasYPais(fechaInicial, fechaFinal, "Reino Unido", casasEntreFechas);
                        CasaService.mostrarCasas(casasEntreFechas);
                        break;
                    case 3:
                        String c = "y";
                        ArrayList<Familia> familias = FamiliaService.buscarFamiliaPorLetraFinal(c);
                        FamiliaService.mostrarFamilias(familias);
                        break;
                    case 4:
                        String mail = "hotmail";
                        ArrayList<Familia> familiasHotmail = new ArrayList();
                        FamiliaService.buscarMailHotmail(mail, familiasHotmail);
                        FamiliaService.mostrarFamilias(familiasHotmail);
                        break;
                    case 5:
                        ArrayList<Casa> casaRangoDias = new ArrayList();
                        Date fechaDada = new Date(2020 - 1900, 05, 01);
                        Integer dias = 10;
                        CasaService.buscarCasaDiasEspecif(fechaDada, dias, casaRangoDias);
                        CasaService.mostrarCasas(casaRangoDias);
                        break;
                    case 6:
                        ArrayList<String> clientes = new ArrayList();
                        ClienteService.buscarClientesEstancias(clientes);
                        ClienteService.mostrarString(clientes);
                        break;
                    case 7:
                        ArrayList<Casa> casaAumentoPrecio = new ArrayList();
                        String pais = "Reino Unido";
                        Double incremento = 0.05;
                        CasaService.incrementarPrecio(incremento, pais);
                        CasaService.consultarCasasPorPais(pais, casaAumentoPrecio);
                        break;
                    case 8:
                        ArrayList<String> casasXPais = new ArrayList();
                        CasaService.contarCasasPorPais(casasXPais);
                        break;
                    case 9:
                        ArrayList<Casa> casaLimpia = new ArrayList();
                        String palabra = "limpia";
                        pais = "Reino Unido";
                        CasaService.buscarSegunComentarioYPais(palabra, pais, casaLimpia);
                        break;
                    case 10:
                        if (subMenu()) {
                            //metodo para dar de alta un cliente
                        } else {
                            Integer idCiente = ClienteService.buscarPorID();
                            String nombreCliente = ClienteService.buscarPorNombre(idCiente);
                            System.out.println("Indique el pais donde desea hacer su estadia");
                            pais = "reino unido";
                            System.out.println(pais);
                            System.out.println("Indique la fecha desde la cual desea alquilar"
                                    + " una casa");
                            Date fechaI = new Date(2020 - 1900, 06, 01);
                            System.out.println((fechaI.getYear() + 1900) + "/" + (fechaI.getMonth() + 1) + "/" + fechaI.getDate());
                            System.out.println("Indique la fecha final de su estadia");
                            Date fechaF = new Date(2020 - 1900, 06, 21);
                            System.out.println((fechaF.getYear() + 1900) + "/" + (fechaF.getMonth() + 1) + "/" + fechaF.getDate());
                            ArrayList<Casa> casa = new ArrayList();
                            CasaService.buscarCasasRangoFechasYPais(fechaI, fechaF, pais, casa);
                            System.out.println("Estas son las casas disponibles para esa fecha");
                            CasaService.mostrarCasas(casa);
                            System.out.println("Indique el id de la casa donde desea quedarse");
                            Integer idCasa = 8;
                            System.out.println(idCasa);
                            Estancia e = new Estancia(9, idCiente, idCasa, nombreCliente, fechaI, fechaF);
                            EstanciaService.nuevaReserva(e);
                        }
                        System.out.println("No jodá no tenia ganas de hacerlo!");
                        break;
                    default:
                        System.out.println("Opcion invalida");
                        break;
                    }

            } catch (Exception e) {
                System.out.println(e.fillInStackTrace());
                System.out.println(e.getMessage());
                System.out.println("Debe ingresar un numero dentro de las opciones"
                        + " válidas");

            }

        }
    }

    /**
     *
     * @return
     */
    public static Boolean subMenu() throws Exception {
        Boolean OK = false;
        System.out.println("Desea Cargar cliente nuevo? S/N");
        try {
            String rpta = "N"; //Deberia ir un scanner pero no tengo ganas
            System.out.println(rpta);
            switch (rpta) {
                case "S":
                case "s":
                    OK = true;
                    break;
                case "n":
                case "N":
                    OK = false;
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return OK;
    }
}
