<%-- 
    Document   : asignar
    Created on : 23-oct-2016, 15:06:03
    Author     : Julio
--%>

<%@page import="RestIntegracion.FormularioCompletoBussines"%>
<%@page import="Entidad.FormularioCompleto"%>
<%@page import="Entidad.FormularioCompleto"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String nombreObra=""; 
String idTareaAsignada=request.getParameter("idTareaAsignada");
String obra=request.getParameter("obra");
String fecha=request.getParameter("fecha");
String inspector=request.getParameter("inspector");
%>

<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="complementos/bootstrap/css/bootstrap.css"/>  
        <link rel="stylesheet" type="text/css" href="complementos/css/visualizarObra.css"/>
               <link rel="stylesheet" type="text/css" href="complementos/css/home.css"/>
        <link rel="stylesheet" type="text/css" href="complementos/css/asignar.css"/>
        <title>Visualizar</title>
    </head>
    <body>
        <h1 style="text-align: center">Visualizar Obra <%=nombreObra%></h1>
        <br>
        <div class="container">
            <div class="row">
                <div class="span4">
                    <p>Obra: <%=obra%></p>
                </div>
                <div class="span4">
                    <p>Fecha: <%=fecha%></p>
                </div>
                <div class="span4">
                    <p>Inspector: <%=inspector  %></p>
                </div>
            </div>
        </div>
        
        
        
        <br>
        <br>
        <div class="container">
            
            <div class="row">
                
                <div>
                    <div class="col-md-8">
                <div id="contenedorTabla">
      
                    <table border="1" style="width: 100%" >
                        <thead>
                            <tr>
                                <th class="tituloTabla" style='width:25%'><h5>Sector</h5></th>
                                <th class="tituloTabla" style='width:25%'><h5>Sub sector</h5></th>
                                <th class="tituloTabla" style='width:25%'><h5>Pregunta</h5></th>
                                <th class="tituloTabla" style='width:25%'><h5>Respuesta</h5></th>
                            
                            </tr>
                        </thead>

                    
                     <%    
                        LinkedList<FormularioCompleto> listVisualizar=FormularioCompletoBussines.visualizar(Integer.parseUnsignedInt(idTareaAsignada));
                        for(int i=0;i<listVisualizar.size();i++){
                            out.println("<tr>");
                            out.println("<td style='width:25%'>"+listVisualizar.get(i).getSector()+"</td>");
                            out.println("<td style='width:25%'>"+listVisualizar.get(i).getSubSector()+"</td>");
                            out.println("<td style='width:25%'>"+listVisualizar.get(i).getPregunta()+"</td>");
                            out.println("<td style='width:25%'>"+listVisualizar.get(i).getRespuesta()+"</td>");
                            out.println("</tr>");
                        }
                    %>
                    
                                        </table>
                </div>
                    </div>
                    
                    
                    
                    
                    
                </div>
                
            </div>
            
        </div>
        


</html>
