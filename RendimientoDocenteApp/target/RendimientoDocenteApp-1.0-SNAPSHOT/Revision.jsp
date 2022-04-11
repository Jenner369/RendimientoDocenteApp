<%@page import="com.bean.VisitaInopinada"%>
<%@page import="com.bean.DetalleCurso"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.DetalleCuestionario"%>
<%@page import="com.util.Utils"%>
<%@page import="com.bean.Cuestionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Revision</title>
    </head>

    <body style="background-image: url(https://images.unsplash.com/photo-1484417894907-623942c8ee29?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1632&q=80); 
          background-size: cover; background-position: center center; background-attachment: fixed;">
        <div class="container">
            <div class="card my-5">
                <div class="card-header display-6  text-center">
                    Revision
                </div>
                <div class="card-body">
                    <%
                        Cuestionario Cuestionario = Utils.coalesce((Cuestionario) request.getAttribute("cuestionario"), new Cuestionario());
                        DetalleCuestionario DetalleCuestionario = Utils.coalesce((DetalleCuestionario) request.getAttribute("lista_detallecuestionarios"), new DetalleCuestionario());
                        DetalleCurso detalleCurso = Utils.coalesce((DetalleCurso) request.getAttribute("detallecurso"), new DetalleCurso());
                        VisitaInopinada Visita = Utils.coalesce((VisitaInopinada) request.getAttribute("visitainopinada"), new VisitaInopinada());
                    %>
                    <div class="fs-4 pb-3">
                        <%=detalleCurso.getCurso().getNombre()%>                       
                    </div>
                    <hr>
                    <div class="fs-5 pb-3 text-center">
                        Indicadores de Evaluacion
                    </div>
                    <table class="table table-secondary table-striped text-center">
                        <thead class="table-dark">
                            <tr>
                                <th scope="col">Tipo</th>
                                <th scope="col">Calificacion</th>
                            </tr>
                        </thead>
                        <tbody>

                            <tr>
                                <td>Entrega del silabo</td>
                                <td><%=DetalleCuestionario.getSilabo()%></td>
                            </tr>

                            <tr>
                                <td>Asistir puntualmente</td>
                                <td><%=DetalleCuestionario.getAsistencia()%></td>
                            </tr>

                            <tr>
                                <td>Visita inopinada</td>
                                <td><%=Visita.getPuntaje()%></td>
                            </tr>

                            <tr>
                                <td>Responsabilidad social</td>
                                <td><%=DetalleCuestionario.getRespoSocial()%></td>
                            </tr>

                            <tr>
                                <td>Tutoria</td>
                                <td><%=DetalleCuestionario.getTutoria()%></td>
                            </tr>

                            <tr>
                                <td>Otros</td>
                                <td><%=DetalleCuestionario.getOtros()%></td>
                            </tr>

                        </tbody>
                    </table>
                    <hr> 
                    <div class="fs-5 pb-3 text-center">
                        Información de la Evaluacion            
                    </div>
                    <table class="table table-secondary table-striped text-center">
                        <thead class="table-dark">
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Fecha</th>
                                <th scope="col">Promedio</th>
                                <th scope="col">Estado</th>
                                <th scope="col">Porcentaje de Participacion</th>
                                <th scope="col">Calificacion Total</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><%=Cuestionario.getId()%></td>
                                <td><%=Cuestionario.getFecha()%></td>
                                <td><%=Cuestionario.getPromedio()%></td>
                                <td><%=Cuestionario.getEstado()%></td>
                                <td><%=Cuestionario.getPorcentajeParticipacion()%></td>
                                <td><%=(Cuestionario.getPromedio() + Visita.getPuntaje())%></td>
                            </tr>
                        </tbody>
                    </table>       
                </div>
                <div class="card-footer text-muted  text-center">
                    UNPRG - Derechos Reservados 2022
                </div>
            </div>
        </div>
    </body>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
    crossorigin="anonymous"></script>

</html>