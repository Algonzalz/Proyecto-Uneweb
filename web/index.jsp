<%-- 
    Document   : indexito
    Created on : 11/07/2018, 05:33:06 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <link rel="stylesheet" href="CSS/fondo.css">
 <link rel="stylesheet" href="CSS/login.css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INICIO DE SESION</title>
    </head>
    <body>

            <form action="LoginServlet" method="get" class="form-register" >
                <h2 class="fomr-titulo">INICIAR SESION</h2>
                <div class="contenedor-inputs">
                    <input type="text" id="usuario" name="jspuser" placeholder=" Usuario" required="" class="input-100" />
                <input type="password" id="password" name="jsppass" placeholder="Contraseña" required="" class="input-100" />
                <input type="submit"  name="Ingresar" value="INGRESAR" class="btn-registrar" />
                 <p class="form-link">¿No estas registrado?  <a href="registrar.jsp">Ingresa Aquí</a></p>
                </div>
            </form>

       
        
    </body>
</html>
