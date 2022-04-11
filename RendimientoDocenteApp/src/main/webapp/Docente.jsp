<%@page import="com.util.Utils"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.bean.Docente"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Docentes</title>
</head>

<body style="background-image: url(https://images.unsplash.com/photo-1606761568499-6d2451b23c66?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1374&q=80); 
background-size: cover; background-position: center center; background-attachment: fixed;">
    <div class="container">
        <div class="card my-5">
            <div class="card-header display-6  text-center">
                Docentes
            </div>
            <div class="card-body">
                <table class="table table-secondary table-striped text-center">
                    <thead class="table-dark">
                        <tr>
                            <th scope="col">Nombre</th>
                            <th scope="col">Calificacion</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            List<Docente> Docentes = Utils.coalesce((List<Docente>)request.getAttribute("lista_resultados"), new ArrayList<Docente>());
                        %>
                        
                        <% for (int i = 0; i < Docentes.size(); i++) { %>
                        <tr>
                            <td><%=Docentes.get(i)%></td>
                            <td>
                                <a class="btn btn-dark" href="Servlet_Evaluacion?tipo_consulta=listar_resultados&idDocente=<%=Docentes.get(i).getId()%>" target="_black">Evaluaciones</a>
                            </td>
                        </tr>
                        <%}%>
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