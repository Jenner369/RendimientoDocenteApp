package com.udt;

import java.sql.Date;
import java.sql.JDBCType;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class DetalleCuestionarioUDT implements SQLData {
    private Integer id_d_cuestionario;                      
    private Integer puntaje;                      
    private Integer cuestionario_id_cuestionario;         
    private Integer detalle_curso_id_d_curso;     
    private Integer silabo;                       
    private Integer asistencia;                   
    private Integer respo_social;                 
    private Integer tutoria;                      
    private Integer otros;                        
    
    public static final String TYPE_NAME = "tp_detalle_cuestionario";
    @Override
    public String getSQLTypeName() throws SQLException {
        return TYPE_NAME;
    }

    @Override
    public void readSQL(SQLInput in, String typeName) throws SQLException {
        this.id_d_cuestionario = in.readObject(Integer.class);
        this.puntaje = in.readObject(Integer.class);
        this.cuestionario_id_cuestionario = in.readObject(Integer.class);
        this.detalle_curso_id_d_curso = in.readObject(Integer.class);
        this.silabo = in.readObject(Integer.class);
        this.asistencia = in.readObject(Integer.class);
        this.respo_social = in.readObject(Integer.class);
        this.tutoria = in.readObject(Integer.class);
        this.otros = in.readObject(Integer.class);

    }

    @Override
    public void writeSQL(SQLOutput out) throws SQLException {
        out.writeObject(this.id_d_cuestionario, JDBCType.INTEGER);
        out.writeObject(this.puntaje, JDBCType.INTEGER);
        out.writeObject(this.cuestionario_id_cuestionario, JDBCType.INTEGER);
        out.writeObject(this.detalle_curso_id_d_curso, JDBCType.INTEGER);
        out.writeObject(this.silabo, JDBCType.INTEGER);
        out.writeObject(this.asistencia, JDBCType.INTEGER);
        out.writeObject(this.respo_social, JDBCType.INTEGER);
        out.writeObject(this.tutoria, JDBCType.INTEGER);
        out.writeObject(this.otros, JDBCType.INTEGER);
    }

    public DetalleCuestionarioUDT(Integer id_d_cuestionario, Integer puntaje, Integer cuestionario_id_cuestionario, Integer detalle_curso_id_d_curso, Integer silabo, Integer asistencia, Integer respo_social, Integer tutoria, Integer otros) {
        this.id_d_cuestionario = id_d_cuestionario;
        this.puntaje = puntaje;
        this.cuestionario_id_cuestionario = cuestionario_id_cuestionario;
        this.detalle_curso_id_d_curso = detalle_curso_id_d_curso;
        this.silabo = silabo;
        this.asistencia = asistencia;
        this.respo_social = respo_social;
        this.tutoria = tutoria;
        this.otros = otros;
    }

    
}
