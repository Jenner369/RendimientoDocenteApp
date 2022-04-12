package com.bean;

import java.sql.Date;
import java.sql.Timestamp;

public class Cuestionario {
    private Integer id;
    private Date fecha;
    private String estado;
    private Double promedio;
    private Double porcentajeParticipacion;
    private DetalleCurso detalleCurso;

    public DetalleCurso getDetalleCurso() {
        return detalleCurso;
    }

    public void setDetalleCurso(DetalleCurso detalleCurso) {
        this.detalleCurso = detalleCurso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
