package com.bean;

import com.udt.DetalleCuestionarioUDT;

public class DetalleCuestionario {
    private Integer id_d_cuestionario;
    private Integer puntaje;
    private Integer silabo;
    private Integer respoSocial;
    private Integer asistencia;
    private Integer tutoria;
    private Integer otros;
    private Cuestionario cuestionario;
    private DetalleCurso detalleCurso;

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public Integer getSilabo() {
        return silabo;
    }

    public void setSilabo(Integer silabo) {
        this.silabo = silabo;
    }

    public Integer getRespoSocial() {
        return respoSocial;
    }

    public void setRespoSocial(Integer respoSocial) {
        this.respoSocial = respoSocial;
    }

    public Integer getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Integer asistencia) {
        this.asistencia = asistencia;
    }

    public Integer getTutoria() {
        return tutoria;
    }

    public void setTutoria(Integer tutoria) {
        this.tutoria = tutoria;
    }

    public Integer getOtros() {
        return otros;
    }

    public void setOtros(Integer otros) {
        this.otros = otros;
    }

    public Cuestionario getCuestionario() {
        return cuestionario;
    }

    public void setCuestionario(Cuestionario cuestionario) {
        this.cuestionario = cuestionario;
    }

    public DetalleCurso getDetalleCurso() {
        return detalleCurso;
    }

    public void setDetalleCurso(DetalleCurso detalleCurso) {
        this.detalleCurso = detalleCurso;
    }
    
    public DetalleCuestionarioUDT toUDT() {
        return new DetalleCuestionarioUDT(id_d_cuestionario, puntaje, cuestionario.getId(), detalleCurso.getId(), silabo, asistencia, respoSocial, tutoria, otros);
    }
    
}
