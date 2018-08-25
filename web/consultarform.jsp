<%-- 
    Document   : consultarform
    Created on : 14/07/2018, 11:08:41 PM
    Author     : USER
--%>

<%@page import="ProyectoHenry.model.UsuarioDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="CSS/fondo.css">
<link href="CSS/consultarform.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

        <!--  
=======================================================
  A PARTIR DE ESTE MOMENTO VIENE EL CODIGO DE CONSULTAR
=======================================================
        -->
        <% HttpSession sesion = request.getSession();       //MANEJO DE SESION
            UsuarioDTO us = (UsuarioDTO) sesion.getAttribute("usuario");
            if (us != null)
            {
        %> 


        <form  action="ConsultarServlet"  class="form-register" onsubmit="return validarc();">
            <h1 align="center" class="fomr-titulo" >CONSULTAR PACIENTE</h1>

            <div class="contenedor-inputs" >ID:
                <input type="text" id="txtid" name="txtid" value="" placeholder="Ingrese ID" class="input-100" required=""/>

                 <div class="contenedor-btn">
                <input type="submit" name="btbuscar" value="Buscar" class="btn-buscar" />
                <a href="menu.jsp" ><input type="button" value="Regresar" class="btn-regresar" /></a>
                 </div>
            </div>


        </form>



<!--=====================================================================
UN SCRIPT QUE LO LLAMA DEUNA CARPETA DE JAVASCRIPT CREADA, PARA VALIDAR
EL FORMULARIO DE CONSULTAR ID
=========================================================================-->
<script src="js/validar.js" type="text/javascript"></script>
    </body>
</html>
<%
    } else
    {
        response.sendRedirect("index.jsp");
    }
%>
