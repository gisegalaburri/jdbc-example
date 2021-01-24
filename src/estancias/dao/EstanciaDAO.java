/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estancias.dao;

import estancias.entidades.Estancia;

/**
 * 
 * @author Gisele Galaburri <gisele.galaburri89 at gmail.com>
 */
public class EstanciaDAO extends DAO {
    
    public void nuevaReserva(Estancia est) throws Exception{
        try {
            //2020-06-01
            String sql = "insert into estancias "
                    + " VALUES ('" +est.getId_estancia()+"',"
                    + "'" + est.getIdCliente() + "',"
                    + "'" + est.getIdCasa() + "',"
                    + "'" + est.getId_huesped()+"',"
                    + "'" + (est.getFecha_desde().getYear()+1900)
                    + "-" + (est.getFecha_desde().getMonth()+1)
                    + "-" + est.getFecha_desde().getDate()+"',"
                    + "'" + (est.getFecha_hasta().getYear()+1900)
                    + "-" + (est.getFecha_hasta().getMonth()+1)
                    + "-" + est.getFecha_hasta().getDate()+"');";
            
            insertarModificarEliminar(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        } finally {
            desconectarBase();
        }
    }

}
