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
import javax.servlet.http.HttpSession;

@WebServlet(name = "ConsultarServlet", urlPatterns =
{
    "/ConsultarServlet"
})
public class ConsultarServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //CAPTURO EL PARAMETRO DEL FORMULARIOY SE LO INGRESO A UN OBJETO DE TIPO PACIENTE PARA UTILIZARLO EN EL METODO DE CONSULTAR DEL DAO
        int id = Integer.parseInt(request.getParameter("txtid"));
        PacienteDTO p = new PacienteDTO();
        p.setId(id);

        PacienteDAO dao = new PacienteDAO();
        p = dao.selectById(p);

        /*
            1.- SI EL PACIENTE NO SE ENCUENTRA ME MUESTRA UN MENSAJE DE ERROR Y ME MANDA AL MENU CON UN BOTON DE REGRESAR
            2.- CASO CONTRARIO ME DIRECCIONA A LA VISTA DE CONSULTAR CON EL PACIENTE OBTENIDO.
         */
        if (p != null)
        {
            request.setAttribute("paciente", p);
            request.getRequestDispatcher("consultar.jsp").forward(request, response);
        } else
        {
            try (PrintWriter out = response.getWriter())
            {
                out.println(" <link href=\"CSS/agregarform.css\" rel=\"stylesheet\" type=\"text/css\"/>");
                out.println("<link href=\"CSS/Boton.css\" rel=\"stylesheet\" type=\"text/css\"/>");
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>MENSAJE ERROR</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div align=\"center\"><img src=\"ICONOS/icons8-cancelar-48.png\" width=\"64\" height=\"64\" alt=\"icons8-marca-de-verificación-64\"/></div>");
                out.println("");
                out.println("<div class=\"alert alert-success\" align=\"center\"><h1>EL PACIENTE NO EXISTE</h1></div>");
                out.println("");
                out.println("<div align=\"center\"><a href=\"consultarform.jsp\"><button type=\"button\" class=\"btn-boton\">REGRESAR</button></a></div>");
                out.println("</body>");
                out.println("</html>");
            }

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
