package com.bean;

import java.sql.Date;

public class VisitaInopinada {
    private Integer id;
    private Date fecha;
    private Integer puntaje;
    private DetalleCurso detalleCurso;

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
