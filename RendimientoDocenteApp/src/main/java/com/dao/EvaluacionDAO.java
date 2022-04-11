package com.dao;

import com.bean.Cuestionario;
import com.bean.Curso;
import com.bean.DetalleCuestionario;
import com.bean.DetalleCurso;
import com.bean.Docente;
import com.bean.NivelRendimiento;
import com.bean.Resultado;
import com.bean.VisitaInopinada;
import com.config.cnx;
import com.udt.DetalleCuestionarioUDT;
import com.util.Utils;
import java.io.IOException;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EvaluacionDAO {
    cnx cn;
    Connection con;
    CallableStatement cs;
    PreparedStatement ps;
    private ResultSet rs;

    public EvaluacionDAO() throws SQLException, IOException {
        this.cn = new cnx();
    }

    //procediminetos almacenados
    public void RegistrarEvaluacion(DetalleCuestionarioUDT[] detalleCuestionarios, Cuestionario cuestionario, VisitaInopinada visitaInopinada) throws SQLException {
        try {
            String sql = "{ ? = call REGISTRAR_EVALUACION(?, ?, ?, ?, ?, ?)}";
            con = cn.getConexion();
            cs = con.prepareCall(sql);
            int index = 0;
            //CUESTIONARIO
            cs.setObject(++index, cuestionario.getFecha(), Types.TIMESTAMP);
            cs.setObject(++index, cuestionario.getEstado(), Types.CHAR);
            //VISITA INOPINADA
            cs.setObject(++index, visitaInopinada.getFecha(), Types.TIMESTAMP);
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
//    public List<DetalleCuestionario> getDetalleCuestionariosByResultado(Integer idResultado) throws SQLException {
//        List<DetalleCuestionario> detalleCuestionarios = new ArrayList<DetalleCuestionario>();
//        DetalleCuestionario obj;
//        try {
//            String sql = "select * FROM detalle_cuestionario where cuestionario_id_cuestionario = (select cuestionario_id_cuestionario from resultado where id_resultado = ?);";
//            con = cn.getConexion();
//            ps = con.prepareCall(sql);
//            int index = 0;
//            ps.setObject(++index, idResultado, Types.INTEGER);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                obj = new DetalleCuestionario();
//                obj.setPuntaje(rs.getObject("puntaje", Integer.class));
//                obj.setSilabo(rs.getObject("silabo", Integer.class));
//                obj.setAsistencia(rs.getObject("asistencia", Integer.class));
//                obj.setRespoSocial(rs.getObject("respo_social", Integer.class));
//                obj.setTutoria(rs.getObject("tutoria", Integer.class));
//                obj.setOtros(rs.getObject("otros", Integer.class));
//                detalleCuestionarios.add(obj);
//            }
//            ps.close();
//            con.close();
//        } catch (SQLException e) {
//            throw e;
//        }
//        return detalleCuestionarios;
//    }
    
    public DetalleCuestionario getDetalleCuestionariosByResultado(Integer idResultado) throws SQLException {
        DetalleCuestionario obj = new DetalleCuestionario();
        try {
            String sql = "select ROUND((sum(puntaje)/count(*))), ROUND(sum(silabo)/count(*)), ROUND(sum(asistencia)/count(*)), ROUND(sum(respo_social)/count(*)),    ROUND(sum(tutoria)/count(*)),    ROUND(sum(encuesta)/count(*))   from    detalle_cuestionario where cuestionario_id_cuestionario = (select resultado.cuestionario_id_cuestionario from resultado where resultado.id_resultado = ?)";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            int index = 0;
            ps.setObject(++index, idResultado, Types.INTEGER);
            rs = ps.executeQuery();
            while (rs.next()) {
                obj = new DetalleCuestionario();
                obj.setPuntaje(rs.getObject(1, Integer.class));
                obj.setSilabo(rs.getObject(2, Integer.class));
                obj.setAsistencia(rs.getObject(3, Integer.class));
                obj.setRespoSocial(rs.getObject(4, Integer.class));
                obj.setTutoria(rs.getObject(5, Integer.class));
                obj.setOtros(rs.getObject(6, Integer.class));
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            throw e;
        }
        return obj;
    }
    
    public VisitaInopinada getVisitaInopinadaByResultado(Integer idResultado) throws SQLException {
        VisitaInopinada obj = new VisitaInopinada();
        try {
            String sql = "SELECT * FROM visita_inopinada WHERE id_visita = (select visita_inopinada_id_visita from resultado where id_resultado = ?)";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            int index = 0;
            ps.setObject(++index, idResultado, Types.INTEGER);
            rs = ps.executeQuery();
            while (rs.next()) {
                obj = new VisitaInopinada();
                obj.setId(rs.getObject("id_visita", Integer.class));
                obj.setPuntaje(rs.getObject("puntaje", Integer.class));
                obj.setFecha(rs.getObject("fecha", Date.class));
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            throw e;
        }
        return obj;
    }
    
    public DetalleCurso getDetalleCursoByResultado(Integer idResultado) throws SQLException {
        DetalleCurso obj = new DetalleCurso();
        try {
            String sql = "select * FROM detalle_curso inner join curso on detalle_curso.curso_id_curso = curso.id_curso where id_d_curso = (select detalle_curso_id_d_curso from cuestionario where id_cuestionario = (SELECT cuestionario_id_cuestionario from resultado where id_resultado = ?) )";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            int index = 0;
            ps.setObject(++index, idResultado, Types.INTEGER);
            rs = ps.executeQuery();
            while (rs.next()) {
                obj = new DetalleCurso();
                obj.setId(rs.getObject("id_d_curso", Integer.class));
                obj.setMatriculados(rs.getObject("matriculados", Integer.class));
                obj.setCiclo(rs.getObject("ciclo", Integer.class));
                obj.setCurso(new Curso());
                obj.getCurso().setId(rs.getObject("curso_id_curso", Integer.class));
                obj.getCurso().setNombre(rs.getObject("nombre", String.class));
            }
            ps.close();
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
            String sql = "SELECT * from resultado inner join nivel_rendimiento on resultado.nota between nivel_rendimiento.puntaje_minimo and nivel_rendimiento.puntaje_maximo where (cuestionario_id_cuestionario = (select id_cuestionario from cuestionario where detalle_curso_id_d_curso = (select id_d_curso from detalle_curso where docente_id_docente = ? ORDER BY docente_id_docente FETCH FIRST 1 ROWS ONLY) FETCH FIRST 1 ROWS ONLY))";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            int index = 0;
            ps.setObject(++index, idDocente, Types.INTEGER);
            rs = ps.executeQuery();
            while (rs.next()) {
                obj = new Resultado();
                obj.setId(rs.getObject("id_resultado", Integer.class));
                obj.setFecha(rs.getObject("fecha", Date.class));
                obj.setNota(rs.getObject("nota", Integer.class));
                obj.setNivelRendimiento(new NivelRendimiento());
                obj.getNivelRendimiento().setNombre(rs.getObject("nombre", String.class));
                resultados.add(obj);
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
            throw e;
        }
        return resultados;
    }
    
    
    public List<Docente> listarDocentes() throws SQLException {
        List<Docente> docentes = new ArrayList<Docente>();
        Docente obj;
        try {
            String sql = "select * from docente";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                obj = new Docente();
                obj.setId(rs.getObject("id_docente", Integer.class));
                obj.setNombre(rs.getObject("nombre", String.class));
                obj.setApellidoPaterno(rs.getObject("ape_paterno", String.class));
                obj.setApellidoMaterno(rs.getObject("ape_materno", String.class));
                obj.setEstado(rs.getObject("estado", String.class));
                docentes.add(obj);
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            throw e;
        }
        return docentes;
    }
    
    public Cuestionario getCuestionarioByResultado(Integer idResultado) throws SQLException {
        Cuestionario obj = new Cuestionario();
        try {
            String sql = "select * FROM cuestionario where id_cuestionario = (select cuestionario_id_cuestionario from resultado  where id_resultado = ?)";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            int index = 0;
            ps.setObject(++index, idResultado, Types.INTEGER);
            rs = ps.executeQuery();
            while (rs.next()) {
                obj = new Cuestionario();
                obj.setId(rs.getObject("id_cuestionario", Integer.class));
                obj.setFecha(rs.getObject("fecha", Date.class));
                obj.setEstado(rs.getObject("estado", String.class));
                obj.setPromedio(rs.getObject("promedio", Double.class));
                obj.setPorcentajeParticipacion(rs.getObject("porcentaje_participacion", Double.class));
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            throw e;
        }
        return obj;
    }
}
