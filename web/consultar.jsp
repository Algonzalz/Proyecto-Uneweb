<%-- 
    Document   : consultar
    Created on : 15/07/2018, 09:41:01 PM
    Author     : USER
--%>


<%@page import="ProyectoHenry.model.UsuarioDTO"%>
<%@page import="ProyectoHenry.model.PacienteDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>CONSULTAR</title>
    </head>
    <body>
        <!-- 
           ===========================
          MENU DE NAVEGACIÓN PRINCIPAL
           ============================
        -->

        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">INDICE DE MASA CORPORAL</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="menu.jsp">Home</a></li>
                    <li><a href="agregar.jsp">AGREGAR</a></li>
                    <li><a href="ListarServlet">LISTAR</a></li>
                    <li><a href="consultarform.jsp">CONSULTAR</a></li>
                    <li><a href="CerrarSesionServlet"><img src="ICONOS/usuario.png" width="20" height="20" />
                            CERRAR SESION</a></li>
                </ul>
            </div>
        </nav>
        <!-- ==================================================================
       A PARTIR DE ESTE MOMENTO VIENE EL CODIGO DEL PACIENTE CONSULTADO, 
       Y LO MUESTRO EN UNA TABLA, LE AGREGO LAS VARIBLES DE SESION.
===============================================================================
        -->
         <% HttpSession sesion = request.getSession();
            UsuarioDTO us = (UsuarioDTO) sesion.getAttribute("usuario");
            if (us != null)
            {
        %> 

        <h1 align="center">PACIENTE ENCONTRADO</h1>

        <div class="container">

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>NOMBRE</th>
                        <th>APELLIDO</th>
                        <th>SEXO</th>
                        <th>FECHA NACIMIENTO</th>
                        <th>PESO</th>
                        <th>ESTATURA</th>
                        <th>IMC</th>
                        <th>PGC</th>
                        <th colspan="2">ACCION</th>
                    </tr>
                </thead>
                <% PacienteDTO p = (PacienteDTO) request.getAttribute("paciente");%>
                <tbody>
                    <tr>
                        <td><%= p.getId()%></td>
                        <td><%= p.getNombre()%></td>
                        <td><%= p.getApellido()%></td>
                        <td><%= p.getSexo()%></td>
                        <td><%= p.getFenac()%></td>
                        <td><%= p.getPeso()%></td>
                        <td><%= p.getEstatura()%></td>
                        <td><%= p.getImc(p.getPeso(), p.getEstatura())%></td>
                        <td><%= p.getPgc(p.getImc(p.getPeso(), p.getEstatura()), p.getSexo(), p.getEdad(p.getFenac()))%></td>
                        <td><a href="modificar.jsp?id=<%=p.getId() %>"><img src="ICONOS/icons8-lápiz-40.png" align="center" width="30" height="30" ></a></td>
                        <td><a href="EliminarServlet?id=<%= p.getId() %> "><img src="ICONOS/icons8-cancelar-48.png"  align="center" width="30" height="30" />
                            </a></td>

                    </tr>
                </tbody>
            </table>
        </div>
        <div align="center"><a href="menu.jsp" ><button type="button" class="btn btn-warning">REGRESAR</button></a></div>
    </body>
</html>
<%
    } else
    {
        response.sendRedirect("index.jsp");
    }
%>