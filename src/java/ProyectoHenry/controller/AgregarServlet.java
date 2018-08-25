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

@WebServlet(name = "AgregarServlet", urlPatterns =
{
    "/AgregarServlet"
})
public class AgregarServlet extends HttpServlet {

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

        PacienteDTO p=new PacienteDTO();
        p.setId(id);
        
        PacienteDAO dao=new PacienteDAO();
        p=dao.selectById(p);
        
        if(p!=null){
            try (PrintWriter out = response.getWriter())  //LUEGO MUESTRO UN MENSAJE QUE ESE CODIGO YA ESTÁ SIENDO UTILIZADO
        {
            out.println(" <link href=\"CSS/agregarform.css\" rel=\"stylesheet\" type=\"text/css\"/>");
            out.println("<link href=\"CSS/Boton.css\" rel=\"stylesheet\" type=\"text/css\"/>");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>MENSAJE DE CÓDIGO YA EN USO</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div align=\"center\"><img src=\"ICONOS/mantener.png\" width=\"80\" height=\"80\" alt=\"mantener.png\"/></div>");
            out.println("");
            out.println("<div class=\"alert alert-success\" align=\"center\"><h1>ESE CÓDIGO DE PACIENTE YA ESTÁ EN USO</h1></div>");
            out.println("");
            out.println("<div align=\"center\"><a href=\"agregar.jsp\"><button type=\"button\" class=\"btn-boton\">REGRESAR</button></a></div>");
            out.println("</body>");
            out.println("</html>");
        }
        
        }else{
        PacienteDTO pdto = new PacienteDTO(id, nombre, apellido, sexo, fenac, peso, estatura);// INGRESO LOS DATOS OBTENIDOS DEL FORMUALRIO EN UN OBJETO

        PacienteDAO pdao = new PacienteDAO();  //INSTANCIO EL OBEJTO DAO Y UTILIZO EL MÉTODO QUE TIENE DENTRO DE INSERTAR UN PACIENTE EN LA BASE DE DATOS
        pdao.insertPac(pdto);
        
        try (PrintWriter out = response.getWriter())  //LUEGO MUESTRO UN MENSAJE QUE SE INGRESO UN PACIENTE
        {
            out.println(" <link href=\"CSS/agregarform.css\" rel=\"stylesheet\" type=\"text/css\"/>");
            out.println("<link href=\"CSS/Boton.css\" rel=\"stylesheet\" type=\"text/css\"/>");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>MENSAJE DE INGRESO</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div align=\"center\"><img src=\"ICONOS/icons8-marca-de-verificación-64.png\" width=\"64\" height=\"64\" alt=\"icons8-marca-de-verificación-64\"/></div>");
            out.println("");
            out.println("<div class=\"alert alert-success\" align=\"center\"><h1>EL PACIENTE SE HA INGRESADO CORRECTAMENTE</h1></div>");
            out.println("");
            out.println("<div align=\"center\"><a href=\"menu.jsp\"><button type=\"button\" class=\"btn-boton\">REGRESAR</button></a></div>");
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
