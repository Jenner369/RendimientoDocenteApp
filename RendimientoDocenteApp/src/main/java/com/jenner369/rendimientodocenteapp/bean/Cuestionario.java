package com.jenner369.rendimientodocenteapp.bean;

import java.sql.Timestamp;

public class Cuestionario {
    private Integer id;
    private Timestamp fechaHora;
    private String estado;
    private Double promedio;
    private Double porcentajeParticipacion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    public Double getPorcentajeParticipacion() {
        return porcentajeParticipacion;
    }

    public void setPorcentajeParticipacion(Double porcentajeParticipacion) {
        this.porcentajeParticipacion = porcentajeParticipacion;
    }
}
