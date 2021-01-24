/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias.servicios;

import estancias.dao.ClienteDAO;
import estancias.entidades.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Gisele Galaburri <gisele.galaburri89 at gmail.com>
 */
public class ClienteService {

    public static void buscarClientesEstancias(ArrayList<String> clientes) throws Exception {
        ClienteDAO dao = new ClienteDAO();

        dao.buscarClientesEstancias(clientes);

    }

    public static void mostrarString(ArrayList<String> c) {
        for (String string : c) {
            System.out.println(string);
        }
    }

    public static Integer buscarPorID() throws Exception {
        ClienteDAO dao = new ClienteDAO();

        System.out.println("Ingrese el id para buscarlo");
        try {
            Integer id = 1; //deberiia pedirlo por teclado
            System.out.println(id);

            if (id == null) {
                throw new Exception("Debe indicar un numero entero");
            }

            Integer idValidado = dao.buscarPorID(id);
            
            if (idValidado == id) {
                return idValidado;
            } else {
                throw new Exception("El usuario no existe");
            }
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
    
      public static String buscarPorNombre(Integer id) throws Exception {
        ClienteDAO dao = new ClienteDAO();

        try {            

            if (id == null) {
                throw new Exception("Debe indicar un numero entero");
            }

            String nombre = dao.buscarPorNombre(id);
            
            if (nombre.isEmpty() || nombre == null) {
                throw new Exception("El usuario no existe");
            } else {
                return nombre;
            }
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

}
