package ProyectoHenry.controller;

import ProyectoHenry.db.PacienteDAO;
import ProyectoHenry.model.PacienteDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ModificarServlet", urlPatterns =
{
    "/ModificarServlet"
})
public class ModificarServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int id = Integer.parseInt(request.getParameter("txtid"));
        String nombre = request.getParameter("txtnombre");
        String apellido = request.getParameter("txtapellido");
        char sexo = request.getParameter("txtsexo").charAt(0);
        Date fenac = Date.valueOf(request.getParameter("txtfecha"));
        float peso = Float.parseFloat(request.getParameter("txtpeso"));
        float estatura = Float.parseFloat(request.getParameter("txtestatura"));

        PacienteDTO p = new PacienteDTO(id, nombre, apellido, sexo, fenac, peso, estatura);

        PacienteDAO dao = new PacienteDAO();
        dao.modifyPac(p);
        response.sendRedirect("ListarServlet");

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
