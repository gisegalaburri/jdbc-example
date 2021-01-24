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
public class Familia {

    private Integer id;
    private String nombre;
    private Integer edad_minima;
    private Integer edad_maxima;
    private Integer num_hijos;
    private String email;
    private Integer idCasaFamilia;

    public Familia() {
    }

    public Familia(Integer id, String nombre, Integer edad_minima, Integer edad_maxima, Integer num_hijos, String email, Integer idCasaFamilia) {
        this.id = id;
        this.nombre = nombre;
        this.edad_minima = edad_minima;
        this.edad_maxima = edad_maxima;
        this.num_hijos = num_hijos;
        this.email = email;
        this.idCasaFamilia = idCasaFamilia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad_minima() {
        return edad_minima;
    }

    public void setEdad_minima(Integer edad_minima) {
        this.edad_minima = edad_minima;
    }

    public Integer getEdad_maxima() {
        return edad_maxima;
    }

    public void setEdad_maxima(Integer edad_maxima) {
        this.edad_maxima = edad_maxima;
    }

    public Integer getNum_hijos() {
        return num_hijos;
    }

    public void setNum_hijos(Integer num_hijos) {
        this.num_hijos = num_hijos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdCasaFamilia() {
        return idCasaFamilia;
    }

    public void setIdCasaFamilia(Integer idCasaFamilia) {
        this.idCasaFamilia = idCasaFamilia;
        //System.out.println(familia);
    }

    @Override
    public String toString() {
        return "Familia-->" + " ID: " + id + ". Nombre: " + nombre + ".\n"
                + "Ead Minima: " + edad_minima + ". Edad Maxima: " + edad_maxima + ".\n"
                + "Nro Hijos: " + num_hijos + ". Email=" + email + ". ID Casa: " + idCasaFamilia;
    }

}
