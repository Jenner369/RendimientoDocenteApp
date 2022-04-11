/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.jenner369.rendimientodocenteapp.servlet;

import com.jenner369.rendimientodocenteapp.bean.Cuestionario;
import com.jenner369.rendimientodocenteapp.bean.DetalleCuestionario;
import com.jenner369.rendimientodocenteapp.bean.DetalleCurso;
import com.jenner369.rendimientodocenteapp.bean.Docente;
import com.jenner369.rendimientodocenteapp.bean.Resultado;
import com.jenner369.rendimientodocenteapp.bean.VisitaInopinada;
import com.jenner369.rendimientodocenteapp.dao.EvaluacionDAO;
import com.jenner369.rendimientodocenteapp.udt.DetalleCuestionarioUDT;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jedur
 */
@WebServlet(name = "Servlet_Evaluacion", urlPatterns = {"/Servlet_Evaluacion"})
public class Servlet_Evaluacion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet_Evaluacion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet_Evaluacion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tipo = (String)request.getAttribute("tipo_consulta");
         RequestDispatcher dispatcher;
        switch (tipo) {
            case "listar_docentes":
                try {
                    EvaluacionDAO ev = new EvaluacionDAO();
                    request.setAttribute("lista_docentes", ev.listarDocentes());
                } catch (Exception e) {
                }
                dispatcher = request.getRequestDispatcher("/index.html");  
                dispatcher.forward(request, response);  
                break;
            case "listar_resultados":
                try {
                    EvaluacionDAO ev = new EvaluacionDAO();
                    request.setAttribute("lista_resultados", ev.listarResultados((Integer)request.getAttribute("idDocente")));
                } catch (Exception e) {
                }
                dispatcher = request.getRequestDispatcher("/index.html");  
                dispatcher.forward(request, response); 
                break;
            case "obtener_cuestionario":
                    try {
                        EvaluacionDAO ev = new EvaluacionDAO();
                        request.setAttribute("cuestionario", ev.getCuestionarioByResultado((Integer)request.getAttribute("idResultado")));
                    } catch (Exception e) {
                    }
                    dispatcher = request.getRequestDispatcher("/index.html");  
                    dispatcher.forward(request, response); 
                break;
            case "obtener_detallecurso":
                    try {
                        EvaluacionDAO ev = new EvaluacionDAO();
                        request.setAttribute("detallecurso", ev.getDetalleCuestionariosByResultado((Integer)request.getAttribute("idResultado")));
                    } catch (Exception e) {
                    }
                    dispatcher = request.getRequestDispatcher("/index.html");  
                    dispatcher.forward(request, response); 
                break;
            case "obtener_detallecuestionarios":
                    try {
                        EvaluacionDAO ev = new EvaluacionDAO();
                        request.setAttribute("lista_detallecuestionarios", ev.getDetalleCuestionariosByResultado((Integer)request.getAttribute("idResultado")));
                    } catch (Exception e) {
                    }
                    dispatcher = request.getRequestDispatcher("/index.html");  
                    dispatcher.forward(request, response); 
                break;
            case "obtener_visitainopinada":
                    try {
                        EvaluacionDAO ev = new EvaluacionDAO();
                        request.setAttribute("visitainopinada", ev.getVisitaInopinadaByResultado((Integer)request.getAttribute("idResultado")));
                    } catch (Exception e) {
                    }
                    dispatcher = request.getRequestDispatcher("/index.html");  
                    dispatcher.forward(request, response); 
                break;
        }
        
        //processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<DetalleCuestionario> d_cuestionario = (List<DetalleCuestionario>)request.getAttribute("detalle_cuestionarios");
        Cuestionario cuestionario = (Cuestionario) request.getAttribute("cuestionario");
        VisitaInopinada visitaInopinada = (VisitaInopinada) request.getAttribute("visita_inopinada");
        try {
            EvaluacionDAO evaluacionDAO = new EvaluacionDAO();
            DetalleCuestionarioUDT[] detalleCuestionarioUDT = new DetalleCuestionarioUDT[d_cuestionario.size()-1];  
            for (int i = 0; i < d_cuestionario.size(); i++) {
                detalleCuestionarioUDT[i] = d_cuestionario.get(i).toUDT();
            }
            evaluacionDAO.RegistrarEvaluacion(detalleCuestionarioUDT, cuestionario, visitaInopinada);
            request.setAttribute("respuesta", "OK");
        } catch (Exception e) {
            request.setAttribute("respuesta", "ER");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.html");  
        dispatcher.forward(request, response);  
        //processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
