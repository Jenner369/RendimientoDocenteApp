package com.jenner369.rendimientodocenteapp.dao;

import com.jenner369.rendimientodocenteapp.bean.Cuestionario;
import com.jenner369.rendimientodocenteapp.bean.Curso;
import com.jenner369.rendimientodocenteapp.bean.DetalleCuestionario;
import com.jenner369.rendimientodocenteapp.bean.DetalleCurso;
import com.jenner369.rendimientodocenteapp.bean.Docente;
import com.jenner369.rendimientodocenteapp.bean.Resultado;
import com.jenner369.rendimientodocenteapp.bean.VisitaInopinada;
import com.jenner369.rendimientodocenteapp.config.cnx;
import com.jenner369.rendimientodocenteapp.udt.DetalleCuestionarioUDT;
import java.io.IOException;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EvaluacionDAO {
    cnx cn;
    Connection con;
    CallableStatement cs;
    private ResultSet rs;

    public EvaluacionDAO() throws SQLException, IOException {
        this.cn = new cnx();
    }

    //procediminetos almacenados
    public void RegistrarEvaluacion(DetalleCuestionarioUDT[] detalleCuestionarios, Cuestionario cuestionario, VisitaInopinada visitaInopinada) throws SQLException {
        try {
            String sql = "{ ? = call REGISTRAR_EVALUACION(?, ?, ?, ?, ?)}";
            con = cn.getConexion();
            cs = con.prepareCall(sql);
            int index = 0;
            //CUESTIONARIO
            cs.setObject(++index, cuestionario.getFechaHora(), Types.TIMESTAMP);
            cs.setObject(++index, cuestionario.getEstado(), Types.CHAR);
            //VISITA INOPINADA
            cs.setObject(++index, visitaInopinada.getFechaHora(), Types.TIMESTAMP);
            cs.setObject(++index, visitaInopinada.getPuntaje(), Types.NUMERIC);
            //DETALLE CUESTIONARIO
            Array inPagoArray = Objects.nonNull(detalleCuestionarios)
                        ? con.createArrayOf(DetalleCuestionarioUDT.TYPE_NAME, detalleCuestionarios)
                        : null;
            cs.setObject(++index, inPagoArray, Types.ARRAY);
            cs.execute();
            cs.close();
            con.close();
        } catch (SQLException e) {
            throw e;
        }
    }
    public List<DetalleCuestionario> getDetalleCuestionariosByResultado(Integer idResultado) throws SQLException {
        List<DetalleCuestionario> detalleCuestionarios = new ArrayList<DetalleCuestionario>();
        DetalleCuestionario obj;
        try {
            String sql = "{ ? = call OBTENER_DETALLECUESTIONARIOS_BY_RESULTADO(?, ?, ?, ?, ?)}";
            con = cn.getConexion();
            cs = con.prepareCall(sql);
            int index = 0;
            cs.setObject(++index, idResultado, Types.INTEGER);
            rs = cs.executeQuery();
            while (rs.next()) {
                obj = new DetalleCuestionario();
                obj.setPuntaje(rs.getObject("puntaje", Integer.class));
                obj.setSilabo(rs.getObject("silabo", Integer.class));
                obj.setAsistencia(rs.getObject("asistencia", Integer.class));
                obj.setRespoSocial(rs.getObject("respo_social", Integer.class));
                obj.setTutoria(rs.getObject("tutoria", Integer.class));
                obj.setOtros(rs.getObject("otros", Integer.class));
                detalleCuestionarios.add(obj);
            }
            cs.close();
            con.close();
        } catch (SQLException e) {
            throw e;
        }
        return detalleCuestionarios;
    }
    
    public VisitaInopinada getVisitaInopinadaByResultado(Integer idResultado) throws SQLException {
        VisitaInopinada obj = new VisitaInopinada();
        try {
            String sql = "{ ? = call OBTENER_VISITAINOPINADA_BY_RESULTADO(?)}";
            con = cn.getConexion();
            cs = con.prepareCall(sql);
            int index = 0;
            cs.setObject(++index, idResultado, Types.INTEGER);
            rs = cs.executeQuery();
            while (rs.next()) {
                obj = new VisitaInopinada();
                obj.setId(rs.getObject("id_visita", Integer.class));
                obj.setPuntaje(rs.getObject("puntaje", Integer.class));
                obj.setFechaHora(rs.getObject("fecha_hora", Timestamp.class));
            }
            cs.close();
            con.close();
        } catch (SQLException e) {
            throw e;
        }
        return obj;
    }
    
    public DetalleCurso getDetalleCursoByResultado(Resultado resultado) throws SQLException {
        DetalleCurso obj = new DetalleCurso();
        try {
            String sql = "{ ? = call OBTENER_DETALLECURSO_BY_RESULTADO(?)}";
            con = cn.getConexion();
            cs = con.prepareCall(sql);
            int index = 0;
            cs.setObject(++index, resultado.getId(), Types.INTEGER);
            rs = cs.executeQuery();
            while (rs.next()) {
                obj = new DetalleCurso();
                obj.setId(rs.getObject("id_d_curso", Integer.class));
                obj.setMatriculados(rs.getObject("matriculados", Integer.class));
                obj.setCiclo(rs.getObject("ciclo", Integer.class));
                obj.setCurso(new Curso());
                obj.getCurso().setId(rs.getObject("id_curso", Integer.class));
                obj.getCurso().setNombre(rs.getObject("nombre_curso", String.class));
            }
            cs.close();
            con.close();
        } catch (SQLException e) {
            throw e;
        }
        return obj;
    }
    
    public List<Resultado> listarResultados(Integer idDocente) throws SQLException {
        List<Resultado> resultados = new ArrayList<Resultado>();
        Resultado obj;
        try {
            String sql = "{ ? = call LISTAR_RESULTADOS(?)}";
            con = cn.getConexion();
            cs = con.prepareCall(sql);
            int index = 0;
            cs.setObject(++index, idDocente, Types.INTEGER);
            rs = cs.executeQuery();
            while (rs.next()) {
                obj = new Resultado();
                obj.setId(rs.getObject("id_resultado", Integer.class));
                obj.setFechaHora(rs.getObject("fecha_hora", Timestamp.class));
                obj.setNota(rs.getObject("nota", Integer.class));
                resultados.add(obj);
            }
            cs.close();
            con.close();
        } catch (SQLException e) {
            throw e;
        }
        return resultados;
    }
    
    
    public List<Docente> listarDocentes() throws SQLException {
        List<Docente> docentes = new ArrayList<Docente>();
        Docente obj;
        try {
            String sql = "{ ? = call LISTAR_DOCENTES()}";
            con = cn.getConexion();
            cs = con.prepareCall(sql);
            rs = cs.executeQuery();
            while (rs.next()) {
                obj = new Docente();
                obj.setId(rs.getObject("id_docente", Integer.class));
                obj.setNombre(rs.getObject("nombre", String.class));
                obj.setApellidoPaterno(rs.getObject("ape_paterno", String.class));
                obj.setApellidoMaterno(rs.getObject("ape_materno", String.class));
                obj.setEstado(rs.getObject("estado", String.class));
            }
            cs.close();
            con.close();
        } catch (SQLException e) {
            throw e;
        }
        return docentes;
    }
    
    public Cuestionario getCuestionarioByResultado(Integer idResultado) throws SQLException {
        Cuestionario obj = new Cuestionario();
        try {
            String sql = "{ ? = call OBTENER_CUESTIONARIO_BY_RESULTADO(?)}";
            con = cn.getConexion();
            cs = con.prepareCall(sql);
            int index = 0;
            cs.setObject(++index, idResultado, Types.INTEGER);
            rs = cs.executeQuery();
            while (rs.next()) {
                obj = new Cuestionario();
                obj.setId(rs.getObject("id_cuestionario", Integer.class));
                obj.setFechaHora(rs.getObject("fecha_hora", Timestamp.class));
                obj.setEstado(rs.getObject("estado", String.class));
                obj.setPromedio(rs.getObject("promedio", Double.class));
                obj.setPorcentajeParticipacion(rs.getObject("porcentaje_participacion", Double.class));
            }
            cs.close();
            con.close();
        } catch (SQLException e) {
            throw e;
        }
        return obj;
    }
}
