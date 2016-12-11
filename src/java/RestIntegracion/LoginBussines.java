/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestIntegracion;

import Entidad.Usuario;
import com.sun.corba.se.impl.activation.ServerMain;
import com.sun.corba.se.spi.presentation.rmi.StubAdapter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

        
    public void recorrerJSONLogin(String user, String pass) throws JSONException{

          try {

		URL url = new URL("http://localhost:8084/WebServiceCDC/webresources/generic/Autenticacion?rut="+user+"&clave="+pass);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		String output;
		output = br.readLine();
                
                JSONObject jSONObject=new JSONObject(output);
                
                
           nombre = jSONObject.getString("nombre");
            apellido=jSONObject.getString("apellido");
                
         

             conn.disconnect();          
		
	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	  }

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
            throws ServletException, IOException, SQLException, JSONException {
        user=request.getParameter("user");
        pass=request.getParameter("pass");
        
       recorrerJSONLogin(user, pass);
        
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
    } catch (JSONException ex) {
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
    } catch (JSONException ex) {
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
