<%-- 
    Document   : registrar
    Created on : 12/07/2018, 10:35:26 AM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="CSS/fondo.css">
<link href="CSS/registrar.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REGISTRAR USUARIO</title>
    </head>
    <body>
        <form action="RegistrarServlet" method="get" class="form-register" onsubmit="return validar();">
            <h2 class="fomr-titulo">Registrar Usuario</h2>
            <div class="contenedor-inputs">
                <input type="text" id="txtusuario" name="txtusuario" placeholder="Usuario" required="" class="input-100" />
                <input type="password" id="txtpassword1" name="txtpassword1" placeholder="Contraseña" required="" class="input-100" />
                <input type="password" id="txtpassword2" name="txtpassword2" placeholder="Repetir Contraseña" required="" class="input-100" />
                <div class="contenedor-btn">
                    <input type="submit"  name="Registrar" value="REGISTRAR" class="btn-registrar" />
                    <a href="index.jsp"><input  type="button" value="Regresar" class="btn-regresar" ></a>
                </div>
            </div>
        </form>
        
        <!--===============================================================-->
        <script src="js/validar.js" type="text/javascript"></script>
    </body>
</html>
