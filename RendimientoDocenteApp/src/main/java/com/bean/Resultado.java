package com.bean;

import java.sql.Date;

public class Resultado {
    private Integer id;
    private Integer nota;
    private Date fecha;
    private Cuestionario cuestionario;
    private NivelRendimiento nivelRendimiento;
    private VisitaInopinada visitaInopinada;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cuestionario getCuestionario() {
        return cuestionario;
    }

    public void setCuestionario(Cuestionario cuestionario) {
        this.cuestionario = cuestionario;
    }

    public NivelRendimiento getNivelRendimiento() {
        return nivelRendimiento;
    }

    public void setNivelRendimiento(NivelRendimiento nivelRendimiento) {
        this.nivelRendimiento = nivelRendimiento;
    }

    public VisitaInopinada getVisitaInopinada() {
        return visitaInopinada;
    }

    public void setVisitaInopinada(VisitaInopinada visitaInopinada) {
        this.visitaInopinada = visitaInopinada;
    }
    
}
