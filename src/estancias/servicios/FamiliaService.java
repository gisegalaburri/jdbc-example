/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias.servicios;

import estancias.dao.FamiliaDAO;
import estancias.entidades.Familia;
import java.util.ArrayList;

/**
 *
 * @author Gisele Galaburri <gisele.galaburri89 at gmail.com>
 */
public class FamiliaService {

    public static void alta(Integer id, String nombre, Integer edad_minima, Integer edad_maxima, Integer num_hijos, String email, Integer idCasaFamilia) throws Exception {
        FamiliaDAO familiaDAO = new FamiliaDAO();

        try {

            if (id == null) {
                throw new Exception("Debe Indicar un ID");
            }

            if (nombre.isEmpty()) {
                throw new Exception("Debe indicar nombre de la familia");
            }

            if (edad_minima == null) {
                throw new Exception("Debe indicar una edad minima");
            }

            if (edad_maxima == null) {
                throw new Exception("Debe indicar una edad maxima");
            }

            if (num_hijos == null) {
                throw new Exception("Debe indicar el numero de hijos");
            }

            if (!email.contains("@") || email.trim().isEmpty()) {
                throw new Exception("El correo electrónico es incorrecto");
            }

            if (idCasaFamilia == null) {
                throw new Exception("Debe indicar el ID de su casa");
            }

            try {
                //buscarPorID(id);
                throw new Exception("Ya existe un usuario con el correo electrónico indicado");
            } catch (Exception r) {
            }

            Familia f = new Familia();
            f.setId(id);
            f.setNombre(nombre);
            f.setEdad_minima(edad_minima);
            f.setEdad_maxima(edad_maxima);
            f.setNum_hijos(num_hijos);
            f.setEmail(email);
            f.setIdCasaFamilia(idCasaFamilia);

            familiaDAO.guardarFamilia(f);
        } catch (Exception e) {
        }

    }

    public static void buscarFamiliaPorHijosYEdad(Integer numHijos, Integer edadMin, ArrayList<Familia> familias) throws Exception {
        FamiliaDAO familiaDAO = new FamiliaDAO();

        try {
            if (numHijos == null) {
                throw new Exception("Debe indicar el numero de hijos");
            }

            if (edadMin == null) {
                throw new Exception("Debe indicar la edad minima para la busqueda");
            }

            familiaDAO.buscarFamiliaPorHijosYEdad(numHijos, edadMin, familias);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static ArrayList<Familia> buscarFamiliaPorLetraFinal(String c) throws Exception {
        FamiliaDAO familiaDAO = new FamiliaDAO();
        ArrayList<Familia> familias = new ArrayList();
        try {
            if (c.isEmpty() || c == null) {
                throw new Exception("Debe indicar al menos una letra");
            }

            familias = familiaDAO.buscarFamiliaPorLetraFinal(c);

            return familias;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void buscarMailHotmail(String mail, ArrayList<Familia> familias) throws Exception {
        FamiliaDAO familiaDAO = new FamiliaDAO();
        
        try {
            if (mail.isEmpty() || mail == null) {
                throw new Exception("Debe indicar el servidor mail para la busqueda");
            }
            
            familiaDAO.buscarMailHotmail(mail, familias);
        } catch (Exception e) {
        }

    }

    public static void mostrarFamilias(ArrayList<Familia> f) {
        //Me imprime el mismmo dato pero el arrayList guarda datos diferentes
        for (Familia familia : f) {
            System.out.println(familia);
        }
    }

}
