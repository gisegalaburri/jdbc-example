/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estancias.entidades;

import java.util.Date;

/**
 * 
 * @author Gisele Galaburri <gisele.galaburri89 at gmail.com>
 */
public class Estancia {

    private Integer id_estancia;
    private Integer idCliente;
    private Integer idCasa;
    private String id_huesped;
    private Date fecha_desde;
    private Date fecha_hasta;

    public Estancia() {
    }

    public Estancia(Integer id_estancia, Integer idCliente, Integer idCasa, String id_huesped, Date fecha_desde, Date fecha_hasta) {
        this.id_estancia = id_estancia;
        this.idCliente = idCliente;
        this.idCasa = idCasa;
        this.id_huesped = id_huesped;
        this.fecha_desde = fecha_desde;
        this.fecha_hasta = fecha_hasta;
    }

    public Integer getId_estancia() {
        return id_estancia;
    }

    public void setId_estancia(Integer id_estancia) {
        this.id_estancia = id_estancia;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(Integer idCasa) {
        this.idCasa = idCasa;
    }



    public String getId_huesped() {
        return id_huesped;
    }

    public void setId_huesped(String id_huesped) {
        this.id_huesped = id_huesped;
    }

    public Date getFecha_desde() {
        return fecha_desde;
    }

    public void setFecha_desde(Date fecha_desde) {
        this.fecha_desde = fecha_desde;
    }

    public Date getFecha_hasta() {
        return fecha_hasta;
    }

    public void setFecha_hasta(Date fecha_hasta) {
        this.fecha_hasta = fecha_hasta;
    }

    @Override
    public String toString() {
        return "Estancia--> " + "ID: " + id_estancia + ".\n"
                + "ID Cliente: " + idCliente + ".\n"
                + "ID Casa: " + idCasa + ".\n"
                + "Nombre Huesped: " + id_huesped + ".\n"
                + "Fecha Desde: " + fecha_desde + ".\n"
                + "Fecha Hasta: " + fecha_hasta;
    }

    
}
