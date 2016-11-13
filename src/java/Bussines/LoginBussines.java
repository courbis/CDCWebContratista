/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussines;

import DAO.usuarioDAO;
import Entidad.Usuario;
import com.sun.corba.se.impl.activation.ServerMain;
import com.sun.corba.se.spi.presentation.rmi.StubAdapter;
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
import javax.swing.JOptionPane;

/**
 *
 * @author Julio
 */
@WebServlet(name = "LoginBussines", urlPatterns = {"/LoginBussines"})
public class LoginBussines extends HttpServlet {

String user;
String pass;
String nombre;
String apellido;

    public void obtenerDatosAutenticacion() throws SQLException{
        usuarioDAO uDAO= new usuarioDAO();
      
        uDAO.autenticacion(user,pass);
        nombre=uDAO.nombre();
        apellido=uDAO.apellido();
        }
    
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        user=request.getParameter("user");
        pass=request.getParameter("pass");        
        
        obtenerDatosAutenticacion();
      
        if(nombre!=""&&apellido!=""){
             response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           response.sendRedirect("../CDCWebContratista/home.jsp?nombre="+nombre+"&apellido="+apellido+"&idObra=0");
        }
                }
        else{
              
{           response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           response.sendRedirect("../CDCWebContratista/AutenticacionIncorrecta.html");
}
               
        }}
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
    try {
        processRequest(request, response);
    } catch (SQLException ex) {
        Logger.getLogger(LoginBussines.class.getName()).log(Level.SEVERE, null, ex);
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
        Logger.getLogger(LoginBussines.class.getName()).log(Level.SEVERE, null, ex);
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
