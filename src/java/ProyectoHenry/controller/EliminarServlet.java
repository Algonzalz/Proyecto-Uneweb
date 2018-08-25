package ProyectoHenry.controller;

import ProyectoHenry.db.PacienteDAO;
import ProyectoHenry.model.PacienteDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EliminarServlet", urlPatterns =
{
    "/EliminarServlet"
})
public class EliminarServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        /*=====================================================================
        CAPTURO EL DATO DEL FORMULARIO Y LUEGO INSTANCIO UN OBJETO DE TIPO
          PACIENTE Y LE INGRESO EL ID OBTENIDO
        =======================================================================
        */
        
        int id = Integer.parseInt(request.getParameter("id"));
        PacienteDTO p= new PacienteDTO();
        p.setId(id);
        
        /*=====================================================================
            INSTANCIO UN DAO Y LUEGO UTILIZO EL METODO DE ELMINAR PACIENTE
            CON EL PACIENTE QUE TIENE EL ID QUE INGRESÉ, Y EL MÉTODO SE ENCARGA 
            DE BUSCAR EN LA BASE DE DATOS Y OBTENER LOS DATOS QUE FALTAN, CON 
            LA REFERENCIA DE ESE ID.
        =======================================================================*/
        PacienteDAO dao = new PacienteDAO();
        dao.removePac(p);
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
