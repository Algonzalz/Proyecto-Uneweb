<%-- 
    Document   : menu
    Created on : 10/07/2018, 03:39:48 PM
    Author     : HENRY GONZÁLEZ
--%>

<%@page import="ProyectoHenry.model.UsuarioDTO"%>
<%@page import="ProyectoHenry.db.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>MENU</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="CSS/fondo.css">
        <link href="CSS/mensaje.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%  HttpSession sesion = request.getSession();
            UsuarioDTO us = (UsuarioDTO) sesion.getAttribute("usuario");
            if(us!=null){
        %> 

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
                    <li><a href="CerrarSesionServlet"><img src="ICONOS/usuario.png" width="20" height="20" alt="usuario"/>
                            CERRAR SESION</a></li>
                </ul>
            </div>
        </nav>



        <h1>Bienvenido al Programa de Cálculo del IMC | Usuario:  <%= us.getUsuario()%> |</h1>
        <%}else{response.sendRedirect("index.jsp");}
            %>
    </body>
</html>


