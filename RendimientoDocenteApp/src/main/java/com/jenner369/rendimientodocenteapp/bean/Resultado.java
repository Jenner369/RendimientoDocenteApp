package com.jenner369.rendimientodocenteapp.bean;

import java.sql.Timestamp;

public class Resultado {
    private Integer id;
    private Integer nota;
    private Timestamp fechaHora;
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

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
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
