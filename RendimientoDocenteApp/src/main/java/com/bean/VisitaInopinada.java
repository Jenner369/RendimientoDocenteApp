package com.bean;

import java.sql.Timestamp;

public class VisitaInopinada {
    private Integer id;
    private Timestamp fechaHora;
    private Integer puntaje;
    private DetalleCurso detalleCurso;

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

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public DetalleCurso getDetalleCurso() {
        return detalleCurso;
    }

    public void setDetalleCurso(DetalleCurso detalleCurso) {
        this.detalleCurso = detalleCurso;
    }
    
}
