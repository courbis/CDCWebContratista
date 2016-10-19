<%-- 
    Document   : home
    Created on : 18-oct-2016, 20:10:27
    Author     : Julio
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.util.LinkedList"%>
<%@page import="Bussines.ObraBussines" %>
<%@page import="Entidad.Obra" %>
<%
    
    String nombre=request.getParameter("nombre");
    String apellido=request.getParameter("apellido");
    
%>

              
                        
                    
                    

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="complementos/bootstrap/css/bootstrap.css"/>    
        <link rel="stylesheet" type="text/css" href="complementos/css/home.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
            <div class="span12">
                <h3 id="bienvenido"> Bienvenido <%=nombre%> <%=apellido%></h3>
            </div>            
            <div class="span6">              
               
                <input type="submit" class="boton" value="Asignar" onclick="mostrarListaA()">  

            </div>
            <div class="span6">
               
                <input type="submit" class="boton" value="Visualizar" onclick="mostrarListaV()">                   
                          
            </div>
            <div class="span2"></div>
            <div class="span8">
                <div id="contenedorTabla">
      
                    <table id="tabla" border="1">
                        <thead>
                            <tr>
                                <th class="tituloTabla"><h5>Nombre de obra</h5></th>
                                <th class="tituloTabla"><h5>Direccion</h5></th>
                                
                            </tr>
                        </thead>
                        <tbody id="bodyAsignar" class="noVisible">
                                      <%    
                        LinkedList<Obra> listAsignar=ObraBussines.asignar();
                        for(int i=0;i<listAsignar.size();i++){
                            out.println("<tr>");
                            out.println("<td>"+listAsignar.get(i).getNombre()+"</td>");
                            out.println("<td>"+listAsignar.get(i).getDireccion()+"</td>");
                            out.println("</tr>");
                        }
                    %>                              
             
                        
                        </tbody>
                        
                        <tbody id="bodyVisualizar" class="noVisible">
                         <%    
                        LinkedList<Obra> listVisualizar=ObraBussines.visualizar();
                        for(int i=0;i<listVisualizar.size();i++){
                            out.println("<tr>");
                            out.println("<td>"+listVisualizar.get(i).getNombre()+"</td>");
                            out.println("<td>"+listVisualizar.get(i).getDireccion()+"</td>");
                            out.println("</tr>");
                        }
                    %>
                    </tbody>
                    </table>

                </div>
            </div>
            <div class="span2"></div>
            </div>
        </div>
        
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script type="text/javascript"	src="complementos/js/homeScript.js"></script>

    </body>
</html>
