/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estancias.entidades;

/**
 * 
 * @author Gisele Galaburri <gisele.galaburri89 at gmail.com>
 */
public class Comentario {
    
    private int id_comentario;
    private Integer idCasa;
    private String comentario;

    public Comentario() {
    }

    public Comentario(int id_comentario, Integer Idcasa, String comentario) {
        this.id_comentario = id_comentario;
        this.idCasa = idCasa;
        this.comentario = comentario;
    }

    public int getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(int id_comentario) {
        this.id_comentario = id_comentario;
    }

    public Integer getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(Integer idCasa) {
        this.idCasa = idCasa;
    }
 

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Comentario-->" + " ID: " + id_comentario + ". ID Casa: " + idCasa + ".\n"
                + "Comentario: " + comentario;
    }
    
    

}
