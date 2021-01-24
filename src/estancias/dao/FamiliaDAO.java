/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias.dao;

import estancias.entidades.Familia;
import estancias.servicios.FamiliaService;
import java.util.ArrayList;

/**
 *
 * @author Gisele Galaburri <gisele.galaburri89 at gmail.com>
 */
public class FamiliaDAO extends DAO {

    public void guardarFamilia(Familia familia) throws Exception {
        try {
            if (familia == null) {
                throw new Exception("Debe indicar el usuario");
            }
            //Armo el sql
            //INSERT INTO familias VALUES (1, 'Arroyo', 10, 15, 3, jaja@gmail.com, 3);
            String sql = "INSERT "
                    + "  INTO familias"
                    + "VALUES (" + familia.getId() + ",'" + familia.getNombre() + "',"
                    + familia.getEdad_minima() + "," + familia.getEdad_maxima() + ","
                    + familia.getNum_hijos() + ",'" + familia.getEmail() + "',"
                    + familia.getIdCasaFamilia() + ");";

            //Ejecuto el sql
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void buscarFamiliaPorHijosYEdad(Integer numHijos, Integer edadMin, ArrayList<Familia> familias) throws Exception {
        try {
            String sql = "select * from familias where num_hijos =" + numHijos
                    + " and edad_minima <" + edadMin + ";";

            consultarBase(sql);

            Familia f = null;

            while (resultado.next()) {
                f = new Familia();
                f.setId(resultado.getInt(1));
                f.setNombre(resultado.getString(2));
                f.setEdad_minima(resultado.getInt(3));
                f.setEdad_maxima(resultado.getInt(4));
                f.setNum_hijos(resultado.getInt(5));
                f.setEmail(resultado.getString(6));
                f.setIdCasaFamilia(resultado.getInt(7));
                familias.add(f);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            desconectarBase();
        }
    }

    public ArrayList<Familia> buscarFamiliaPorLetraFinal(String c) throws Exception {

        try {
            //select * from familias where nombre like '%y';
            String sql = "select * from familias where nombre like '%" + c + "';";
            
            consultarBase(sql);

            Familia f = null;
            ArrayList<Familia> familias = new ArrayList();
            
            while (resultado.next()) {
                f = new Familia();
                f.setId(resultado.getInt("id_familia"));
                f.setNombre(resultado.getString(2));
                f.setEdad_minima(resultado.getInt(3));
                f.setEdad_maxima(resultado.getInt(4));
                f.setNum_hijos(resultado.getInt(5));
                f.setEmail(resultado.getString(6));
                f.setIdCasaFamilia(resultado.getInt(7));
                familias.add(f);
            }

            return familias;

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        } finally {
            desconectarBase();
        }
    }

    public void buscarMailHotmail(String mail, ArrayList<Familia> familias) throws Exception {
        
        try {
            String sql = "select * from familias where email like '%" + mail + "%';";
            consultarBase(sql);

            Familia f = null;

            while (resultado.next()) {
                f = new Familia();
                f.setId(resultado.getInt(1));
                f.setNombre(resultado.getString(2));
                f.setEdad_minima(resultado.getInt(3));
                f.setEdad_maxima(resultado.getInt(4));
                f.setNum_hijos(resultado.getInt(5));
                f.setEmail(resultado.getString(6));
                f.setIdCasaFamilia(resultado.getInt(7));
                familias.add(f);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            desconectarBase();
        }
    }

}
