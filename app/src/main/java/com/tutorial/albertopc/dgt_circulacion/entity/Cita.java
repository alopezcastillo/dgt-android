package com.tutorial.albertopc.dgt_circulacion.entity;

/**
 * Created by Alberto PC on 27/04/2017.
 */

public class Cita {

    private Integer id;
    private String doi;
    private String fecha;//cambiar luego por un Date
    private String autoescuela;
    private String vehiculo;
    private String examinador;
    private String estado;

    public Cita(Integer id, String doi, String fecha, String autoescuela, String vehiculo,String examinador, String estado) {
        this.id = id;
        this.doi = doi;
        this.fecha = fecha;
        this.autoescuela = autoescuela;
        this.vehiculo = vehiculo;
        this.examinador=examinador;
        this.estado = estado;
    }

    public Cita() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getAutoescuela() {
        return autoescuela;
    }

    public void setAutoescuela(String autoescuela) {
        this.autoescuela = autoescuela;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getExaminador() {
        return examinador;
    }

    public void setExaminador(String examinador) {
        this.examinador = examinador;
    }
}
