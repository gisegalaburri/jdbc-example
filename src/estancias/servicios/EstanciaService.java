/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estancias.servicios;

import estancias.dao.EstanciaDAO;
import estancias.entidades.Estancia;
import java.util.Date;

/**
 * 
 * @author Gisele Galaburri <gisele.galaburri89 at gmail.com>
 */
public class EstanciaService {
    
    public static void nuevaReserva(Estancia est) throws Exception{
        
        EstanciaDAO dao = new EstanciaDAO();
        try {
            if (est == null) {
                throw new Exception("Error en los datos de su estancia");
            }
            
            dao.nuevaReserva(est);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
