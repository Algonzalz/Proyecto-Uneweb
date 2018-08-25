<%-- 
    Document   : modificar
    Created on : 16/07/2018, 12:33:16 PM
    Author     : USER
--%>

<%@page import="ProyectoHenry.model.UsuarioDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="CSS/agregarform.css" rel="stylesheet" type="text/css"/>
        <title>MODIFICAR</title>
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

        <!-- =====================================================
         A PARTIR DE ESTE MOMENTO VIENE EL CODIGO DE MODIFICAR
         1.-FORMULARIO DE DATOS QUE TOMO.
         2.- INGRESO LOS DATOS QUE QUIERO CAMBIAR Y LLAMO AL SERVLET
         ========================================================-->
        <%  HttpSession sesion = request.getSession();
            UsuarioDTO us = (UsuarioDTO) sesion.getAttribute("usuario");
            if (us != null)
            {
                int id = Integer.parseInt(request.getParameter("id"));
        %> 
        <form action="ModificarServlet"  method="get" name="formulario" class="form-register" >
            <h1 align="center" class="fomr-titulo">MODIFICAR DATOS</h1>

            <div class="contenedor-inputs">
                ID:
                <input type="text" readonly="" name="txtid" value="<%= id%>"  required="" class="input-100"  />


                NOMBRE:
                <input type="text" id="txtnombre" name="txtnombre"  placeholder="Nombre" class="input-100" required pattern="[a-zA-Z]+" title=" NO SE PERMITEN NÚMEROS" maxlength="14" />


                APELLIDO:
                <input type="text" id="txtapellido" name="txtapellido"  placeholder="Apellido" class="input-100" required pattern="[a-zA-Z]+" title=" NO SE PERMITEN NÚMEROS" maxlength="14" />


                SEXO:
                <div class="input-10">FEMENINO <input type="radio" id="txtsexo" name="txtsexo" value="f" /></div>
                <div class="input-10">MASCULINO <input type="radio" id="txtsexo" name="txtsexo" value="m"  /></div>

                FECHA DE NACIMIENTO:
                <input type="date" id="txtfecha" name="txtfecha"  class="input-100" required="" />

                PESO:
                <input type="text" id="txtpeso" name="txtpeso"  placeholder="Peso" class="input-100"  required maxlength="3"/>

                ESTATURA:
                <input type="text" id="txtestatura" name="txtestatura"  placeholder="Estatura" class="input-100" required />

                <div class="contenedor-btn">
                    <input type="submit" value="Agregar"  id="Agreagar" name="Agregar" class="btn-agregar" />
                    <a href="menu.jsp" ><input type="button" value="Regresar" class="btn-regresar"/></a>
                </div>
            </div>
        </form>
        <!--===================================================================
        CÓDIGO JAVASCRIPT EMBEBIDO PARA VALIDAR LOS INPUTS DE MODIFICAR.JSP
        =====================================================================-->
        <script>
            (function () {
                var formulario = document.getElementsByName('formulario')[0],
                        elementos = formulario.elements,
                        boton = document.getElementById('Agregar');

                //PARA VALIDAR EL CAMPO ID
                var validarId = function (e) {
                    if (isNaN((formulario.txtid.value))) {
                        alert("EL ID TIENE QUE SER UN NÚMERO");
                        e.preventDefault();
                    }
                };
                //VALIDA EL LOS RADIO BOTON SEXO
                var validarSexo = function (e) {
                    if (formulario.txtsexo[0].checked === true || formulario.txtsexo[1].checked === true) {

                    } else {
                        alert("SELECCIONA UN SEXO");
                        e.preventDefault();
                    }
                };

                //VALIDA EL CAMPO PESO
                var validarPeso = function (e) {
                    if (isNaN((formulario.txtpeso.value))) {
                        alert("EL PESO TIENE QUE SER UN NÚMERO");
                        e.preventDefault();

                    } else if (formulario.txtpeso.value.length > 3) {
                        alert("EL PESO ES MUY ALTO, COLOQUE UN PESO MENOR");
                        e.preventDefault();
                    }
                };

                //VALIDA EL CAMPO ESTATURA
                var validarEstatura = function (e) {
                    if (isNaN((formulario.txtestatura.value))) {
                        alert("LA ESTATURA TIENE QUE SER UN NÚMERO");
                        e.preventDefault();

                    }
                };

                var validar = function (e) {
                    validarId(e);
                    validarSexo(e);
                    validarPeso(e);
                    validarEstatura(e);
                };


                formulario.addEventListener("submit", validar);

            }());
        </script>
    </body>
</html>
<%
    } else
    {
        response.sendRedirect("index.jsp");
    }
%>
</body>
</html>
