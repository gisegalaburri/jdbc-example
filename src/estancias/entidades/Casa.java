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
public class Casa {

    private Integer id_casa;
    private String calle;
    private Integer numero;
    private String codigo_postal;
    private String ciudad;
    private String pais;
    private Date fecha_desde;
    private Date fecha_hasta;
    private Integer tiempo_minimo;
    private Integer tiempo_maximo;
    private double precio_habitacion;
    private String tipo_vivienda;

    public Casa() {
    }

    public Casa(Integer id_casa, String calle, Integer numero, String codigo_postal, String ciudad, String pais, Date fecha_desde, Date fecha_hasta, Integer tiempo_minimo, Integer tiempo_maximo, double precio_habitacion, String tipo_vivienda) {
        this.id_casa = id_casa;
        this.calle = calle;
        this.numero = numero;
        this.codigo_postal = codigo_postal;
        this.ciudad = ciudad;
        this.pais = pais;
        this.fecha_desde = fecha_desde;
        this.fecha_hasta = fecha_hasta;
        this.tiempo_minimo = tiempo_minimo;
        this.tiempo_maximo = tiempo_maximo;
        this.precio_habitacion = precio_habitacion;
        this.tipo_vivienda = tipo_vivienda;
    }

    public Integer getId_casa() {
        return id_casa;
    }

    public void setId_casa(Integer id_casa) {
        this.id_casa = id_casa;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
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

    public Integer getTiempo_minimo() {
        return tiempo_minimo;
    }

    public void setTiempo_minimo(Integer tiempo_minimo) {
        this.tiempo_minimo = tiempo_minimo;
    }

    public Integer getTiempo_maximo() {
        return tiempo_maximo;
    }

    public void setTiempo_maximo(Integer tiempo_maximo) {
        this.tiempo_maximo = tiempo_maximo;
    }

    public double getPrecio_habitacion() {
        return precio_habitacion;
    }

    public void setPrecio_habitacion(double precio_habitacion) {
        this.precio_habitacion = precio_habitacion;
    }

    public String getTipo_vivienda() {
        return tipo_vivienda;
    }

    public void setTipo_vivienda(String tipo_vivienda) {
        this.tipo_vivienda = tipo_vivienda;
    }

    @Override
    public String toString() {
        return "Casa--> " + "ID Casa: " + id_casa + ".\n"
                + "Calle: " + calle + " Nro:" + numero + ". CP: " + codigo_postal + ".\n"
                + "Ciudad: " + ciudad + ". Pais: " + pais + ".\n"
                + "Disponible desde: " + (fecha_desde.getYear() + 1900) + "/" + (fecha_desde.getMonth() + 1) + "/" + fecha_desde.getDate() + ".\n"
                + "Hasta: " + (fecha_hasta.getYear() + 1900) + "/" + (fecha_hasta.getMonth() + 1) + "/" + fecha_hasta.getDate() + ".\n"
                + "Tiempo Minimo: " + tiempo_minimo + ". Tiempo Maximo: " + tiempo_maximo + ".\n"
                + "Precio Habitacion: $" + precio_habitacion + ". Tipo Vivienda=" + tipo_vivienda;
    }

}
