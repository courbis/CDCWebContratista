/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussines;

import DAO.AsignarDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julio
 */
@WebServlet(name = "DataAsign", urlPatterns = {"/DataAsign"})
public class DataAsign extends HttpServlet {
int obra;
int sector;
int subSector;
int inspector;
int formulario;

public void insertar(int obra, int sector, int subSector, int inspector, int formulario) throws SQLException{
    AsignarDAO dao=new AsignarDAO();
    dao.Asignar(obra, sector, subSector, inspector, formulario);
}

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        inspector=Integer.parseInt(request.getParameter("comboInspector"));
        sector=Integer.parseInt(request.getParameter("combo"));
        subSector=Integer.parseInt(request.getParameter("comboSubSectorAsignar"));
        formulario=Integer.parseInt(request.getParameter("comboTipoFormulario"));
        obra=Integer.parseInt(request.getParameter("idObra"));
        String nombre=request.getParameter("nombre");
        String apellido=request.getParameter("apellido");
      
            insertar(obra, sector, subSector, inspector, formulario);
        
out.println(" <script type=\"text/javascript\">");
out.println("alert('Asignado')");
out.println("</script>");



        
        
        
       /* out.println("Inspector="+request.getParameter("comboInspector")+"<br>");
        out.println("Sector="+request.getParameter("combo")+"<br>");
        out.println("sub Sector="+request.getParameter("comboSubSectorAsignar")+"<br>");
        out.println("formula="+request.getParameter("comboTipoFormulario")+"<br>");
        out.println("Obra="+request.getParameter("idObra")+"<br>");*/
        }}

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
    try {
        processRequest(request, response);
    } catch (SQLException ex) {
        Logger.getLogger(DataAsign.class.getName()).log(Level.SEVERE, null, ex);
    }
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
    try {
        processRequest(request, response);
    } catch (SQLException ex) {
        Logger.getLogger(DataAsign.class.getName()).log(Level.SEVERE, null, ex);
    }
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
