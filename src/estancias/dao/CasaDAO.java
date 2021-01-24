/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias.dao;

import estancias.entidades.Casa;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Gisele Galaburri <gisele.galaburri89 at gmail.com>
 */
public class CasaDAO extends DAO {

    /**
     *
     * @param fechaInicial
     * @param fechaFinal
     * @param pais
     * @param casas
     * @throws Exception
     */
    public void buscarCasasRangoFechasYPais(Date fechaInicial, Date fechaFinal, String pais, ArrayList<Casa> casas) throws Exception {
        try {
            //para la consulta sql le aumento 1900 al año y 1 mes (lo mismo que resto cuando creé
            //la fecha
//              Select * from casas where (fecha_desde between '2020-08-01' and '2020-08-31')
//              OR (fecha_hasta between '2020-08-01' and '2020-08-31') 
//              AND pais like 'reino unido';

//select * from casas  where fecha_desde<='2020-08-01' and fecha_hasta>='2020-08-31'
// and id_casa not in (select id_casa from estancias where (fecha_hasta>='2020-08-01' 
//  and  fecha_desde<='2020-08-31'));


//            String sql = "SELECT * FROM casas WHERE (fecha_desde BETWEEN '"
//                    + (fechaInicial.getYear() + 1900) + "-" + (fechaInicial.getMonth() + 1) + "-" + fechaInicial.getDate() + "'"
//                    + " and '" + (fechaFinal.getYear() + 1900) + "-" + (fechaFinal.getMonth() + 1) + "-" + fechaFinal.getDate() + "')"
//                    + " OR (fecha_hasta BETWEEN '" + (fechaInicial.getYear() + 1900) + "-" + (fechaInicial.getMonth() + 1) + "-" + fechaInicial.getDate() + "'"
//                    + " and '" + (fechaFinal.getYear() + 1900) + "-" + (fechaFinal.getMonth() + 1) + "-" + fechaFinal.getDate() + "')"
//                    + " and pais like '" + pais + "';";


            String sql = "select * from casas  where fecha_desde<='"+ (fechaInicial.getYear() + 1900) + "-" + (fechaInicial.getMonth() + 1) + "-" + fechaInicial.getDate() + "'"
                    + " and fecha_hasta>='"+ (fechaFinal.getYear() + 1900) + "-" + (fechaFinal.getMonth() + 1) + "-" + fechaFinal.getDate() +"'\n"
                    + " and id_casa not in (select id_casa from estancias "
                    + "where (fecha_hasta>='"+(fechaInicial.getYear() + 1900) + "-" + (fechaInicial.getMonth() + 1) + "-" + fechaInicial.getDate() + "'"
                    +" and  fecha_desde<='"+ (fechaFinal.getYear() + 1900) + "-" + (fechaFinal.getMonth() + 1) + "-" + fechaFinal.getDate() +"'));";

            consultarBase(sql);

            Casa c = null;

            while (resultado.next()) {
                c = new Casa();
                c.setId_casa(resultado.getInt(1));
                c.setCalle(resultado.getString(2));
                c.setNumero(resultado.getInt(3));
                c.setCodigo_postal(resultado.getString(4));
                c.setCiudad(resultado.getString(5));
                c.setPais(resultado.getString(6));
                c.setFecha_desde(resultado.getDate(7));
                c.setFecha_hasta(resultado.getDate(8));
                c.setTiempo_minimo(resultado.getInt(9));
                c.setTiempo_maximo(resultado.getInt(10));
                c.setPrecio_habitacion(resultado.getDouble(11));
                c.setTipo_vivienda(resultado.getString(12));
                casas.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            desconectarBase();
        }
    }

    public void buscarCasaDiasEspecif(Date fecha, Integer dias, ArrayList<Casa> casas) throws Exception {
        try {

            //para la consulta sql le aumento 1900 al año y 1 mes (lo mismo que resto cuando creé
            //la fecha
            
//             select * from casas where fecha_hasta >= date_add('2020-6-1', interval 10 day) 
// and tiempo_minimo <= 10 and tiempo_maximo >=10
// and id_casa not in (select id_casa from estancias 
//where (fecha_hasta>='2020-6-1' and  fecha_desde<=date_add('2020-6-1', interval 10 day)));
            String sql = "select * from casas where fecha_hasta >= date_add('" 
                    + (fecha.getYear() + 1900)+ "-" + (fecha.getMonth() + 1) 
                    + "-" + fecha.getDate() + "', interval " + dias + " day)"
                    + " and tiempo_minimo <= "+dias +" and tiempo_maximo >= " + dias 
                    + " and id_casa not in (select id_casa from estancias"
                    + " where fecha_hasta >='"+ (fecha.getYear() + 1900)+ "-"
                    + (fecha.getMonth() + 1) + "-" + fecha.getDate() + "'"
                    + " and fecha_desde <= date_add('"+ (fecha.getYear() + 1900)+ "-"
                    + (fecha.getMonth() + 1) + "-" + fecha.getDate() +"',"
                    + " interval "+dias+" day));";

            consultarBase(sql);

            Casa c = null;

            while (resultado.next()) {
                c = new Casa();
                c.setId_casa(resultado.getInt(1));
                c.setCalle(resultado.getString(2));
                c.setNumero(resultado.getInt(3));
                c.setCodigo_postal(resultado.getString(4));
                c.setCiudad(resultado.getString(5));
                c.setPais(resultado.getString(6));
                c.setFecha_desde(resultado.getDate(7));
                c.setFecha_hasta(resultado.getDate(8));
                c.setTiempo_minimo(resultado.getInt(9));
                c.setTiempo_maximo(resultado.getInt(10));
                c.setPrecio_habitacion(resultado.getDouble(11));
                c.setTipo_vivienda(resultado.getString(12));
                casas.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            desconectarBase();
        }

    }

    public void incrementarPrecio(Double incremento, String pais) throws Exception {
        try {
            String sql = "Update casas SET precio_habitacion = "
                    + "(precio_habitacion * " + incremento + ") + precio_habitacion "
                    + "where pais like '" + pais + "' ;";

            insertarModificarEliminar(sql);

        } catch (Exception e) {
            throw e;
        }

    }

    public void consultarCasasPorPais(String pais, ArrayList<Casa> c) throws Exception {
        try {
            String sql = "select id_casa, precio_habitacion, pais from casas"
                    + " where pais like '" + pais + "';";

            consultarBase(sql);

            Casa casa = null;

            while (resultado.next()) {
                casa = new Casa();
                casa.setId_casa(resultado.getInt(1));
                casa.setPrecio_habitacion(resultado.getDouble(2));
                casa.setPais(resultado.getString(3));
                c.add(casa);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void contarCasasPorPais(ArrayList<String> casas) throws Exception {
        try {
            String sql = "select pais, count(*) from casas group by pais;";

            consultarBase(sql);

            while (resultado.next()) {
                casas.add("Pais: " + resultado.getString(1) + ". Casas Total " + resultado.getInt(2));
            }

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void buscarSegunComentarioYPais(String palabra, String pais, ArrayList<Casa> casa) throws Exception {

        try {
            String sql = "select * from casas v\n"
                    + " inner join comentarios c\n"
                    + " on v.id_casa = c.id_casa\n"
                    + " where c.comentario like '%" + palabra + "%'"
                    + " and pais like '" + pais + "';";

            consultarBase(sql);

            Casa c = null;

            while (resultado.next()) {
                c = new Casa();
                c.setId_casa(resultado.getInt(1));
                c.setCalle(resultado.getString(2));
                c.setNumero(resultado.getInt(3));
                c.setCodigo_postal(resultado.getString(4));
                c.setCiudad(resultado.getString(5));
                c.setPais(resultado.getString(6));
                c.setFecha_desde(resultado.getDate(7));
                c.setFecha_hasta(resultado.getDate(8));
                c.setTiempo_minimo(resultado.getInt(9));
                c.setTiempo_maximo(resultado.getInt(10));
                c.setPrecio_habitacion(resultado.getDouble(11));
                c.setTipo_vivienda(resultado.getString(12));
                casa.add(c);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

}
