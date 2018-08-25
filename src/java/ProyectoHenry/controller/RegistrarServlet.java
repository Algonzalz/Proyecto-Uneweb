/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoHenry.controller;

import ProyectoHenry.db.UsuarioDAO;
import ProyectoHenry.model.UsuarioDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegistrarServlet", urlPatterns =
{
    "/RegistrarServlet"
})
public class RegistrarServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String usuario = request.getParameter("txtusuario");    //TOMO LOS DATOS DEL FORMULARIO Y LOS INGRESO EN LOS OBJETOS
        String password = request.getParameter("txtpassword2");

        UsuarioDTO us = new UsuarioDTO(usuario, password);   // CREO UN OBJETO DE TIPO DTO PARA INGRESAR LOS DATOS
        UsuarioDAO usd = new UsuarioDAO();                   // CREO EL OBJETO DE TIPO DAO PARA UTLIZAR SU MÉTODO Y INGRESAR EL OBJETO CREADO(TAMBIEN PODIA HABER HECHO UNA CLASE STATIC Y NO CREANDO EL OBJETO)
        usd.registerUS(us);
        //LUEGO DESPUES DE REGISTRARLO EN LA BASE DE DATOS MUESTRO UN MENSAJE.
        try (PrintWriter out = response.getWriter())
        {

            out.println("<link rel=\"stylesheet\" href=\"CSS/fondo.css\">");
            out.println("<link href=\"CSS/Boton.css\" rel=\"stylesheet\" type=\"text/css\"/>");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet registrar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div align=\"center\"><img src=\"ICONOS/icons8-marca-de-verificación-64.png\" width=\"64\" height=\"64\" alt=\"icons8-marca-de-verificación-64\"/></div>");
            out.println("");
            out.println("<div class=\"alert alert-success\" align=\"center\">EL USUARIO SE HA REGISTRADO EXITOSAMENTE</div>");
            out.println("");
            out.println("<div align=\"center\"><a href=\"menu.jsp\"><button type=\"button\" class=\"btn-boton\">REGRESAR</button></a></div>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
