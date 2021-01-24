/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias.dao;

import estancias.entidades.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Gisele Galaburri <gisele.galaburri89 at gmail.com>
 */
public class ClienteDAO extends DAO {

    public void buscarClientesEstancias(ArrayList<String> clientes) throws Exception {

        try {
            String sql = "select c.nombre, v.tipo_vivienda\n"
                    + " from clientes c\n"
                    + " inner join estancias e\n"
                    + " on c.id_cliente = e.id_cliente\n"
                    + " inner join casas v\n"
                    + " on v.id_casa = e.id_casa;";

            consultarBase(sql);

            while (resultado.next()) {
                clientes.add(resultado.getString(1) + " " + resultado.getString(2));
            }

        } catch (Exception e) {
            throw e;

        } finally {
            desconectarBase();
        }
    }

    public Integer buscarPorID(Integer idCliente) throws Exception {
        try {
            String sql = "select id_cliente from clientes where id_cliente = " + idCliente + ";";

            consultarBase(sql);
            
            Integer aux = null;
            
            while (resultado.next()) {
                aux = resultado.getInt(1);
            }

            return aux;
            
        } catch (Exception e) {
            throw e;

        } finally {
            desconectarBase();
        }
        
    }
    
        public String buscarPorNombre(Integer idCliente) throws Exception {
        try {
            String sql = "select nombre from clientes where id_cliente = " + idCliente + ";";

            consultarBase(sql);
            
            String nombre = null;
            
            while (resultado.next()) {
                nombre = resultado.getString(1);
            }

            return nombre;
            
        } catch (Exception e) {
            throw e;

        } finally {
            desconectarBase();
        }
        
    }

}
