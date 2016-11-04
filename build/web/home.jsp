<%-- 
    Document   : home
    Created on : 18-oct-2016, 20:10:27
    Author     : Julio
--%>

<%@page import="Bussines.InspectorBussines"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.LinkedList"%>
<%@page import="Bussines.ObraBussines" %>
<%@page import="Entidad.Obra" %>

<%@page import="Entidad.Inspector" %>
<%@page import="Entidad.Sector" %>
<%@page import="Entidad.SubSector" %>
<%@page import="Bussines.AsignarBussines" %>
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
        <link rel="stylesheet" type="text/css" href="complementos/css/asignar.css"/>
        <script type="text/javascript" src="complementos/js/jquery-3.1.1.min.js"></script> 
        
        <script type="text/javascript">
            function actComboSS(){
        //alert("Se actualiza" );    }
        $("#f_opc").val("1");
        $.post("comboD.jsp",$("#data").serialize(),function(data){
            $("#comboss").html(data);});
        }            
        </script>
        
    
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body onload="form1.submit();">
        <div class="container">
            <div class="row">
                
            <%-- Bienvenido--%>    
            <div class="span12">
                <h3 id="bienvenido"> Bienvenido <%=nombre%> <%=apellido%></h3>

            </div>   
            <%--Fin Bienvenido--%>     
            
            <%--Botonera--%> 
            <div class="span6">              
               
                <input type="submit" class="boton" value="Asignar" onclick="mostrarListaA()">  

            </div>
            <div class="span6">
               
                <input type="submit" class="boton" value="Visualizar" onclick="mostrarListaV()">                   
                          
            </div>
            <%--Fin Botonera--%>
            
            <%--Tabla--%>
            <div class="span2"></div>
            <div class="span8">
                <div id="contenedorTabla">
      
                    <table id="tabla" border="1">
                        <thead>
                            <tr>
                                <th class="tituloTabla" style='width:50%'><h5>Nombre de obra</h5></th>
                                <th class="tituloTabla" style='width:50%'><h5>Direccion</h5></th>
                            
                            </tr>
                        </thead>
                        
                                       <tbody id="bodyAsignar" class="noVisible">
                                      <%    
                        LinkedList<Obra> listAsignar=ObraBussines.asignar();
                        for(int i=0;i<listAsignar.size();i++){
                            out.println("<tr>");
                            out.println("<td value='"+listAsignar.get(i).getId()+"'><a href='?nombre="+nombre+"&apellido="+apellido+"&idObra="+listAsignar.get(i).getId()+"#openModalAsignar'>"+listAsignar.get(i).getNombre()+"</a></td>");
                            out.println("<td>"+listAsignar.get(i).getDireccion()+"</td>");
                            out.println("</tr>");
                        }
                    %>                              
             
                                       <a  ></a>
                        </tbody>
                        
                        <tbody id="bodyVisualizar" class="noVisible">
                         <%    
                        LinkedList<Obra> listVisualizar=ObraBussines.visualizar();
                        for(int i=0;i<listVisualizar.size();i++){
                            out.println("<tr value='"+listVisualizar.get(i).getId()+"' onclick=''>");
                            out.println("<td><a  href='#openModalVisualizar'>"+listVisualizar.get(i).getNombre()+"</a></td>");
                            out.println("<td>"+listVisualizar.get(i).getDireccion()+"</td>");
                            out.println("</tr>");
                        }
                    %>
                    </tbody>
                    </table>

                </div>
            </div>
             <%--Fin tabla--%>       
                    
            <div class="span2"></div>
            </div>
        </div>
                    <%-- Ventana pop-up-Asignar--%>
                    
                    <form action="DataAsign" method="post" id="data" >
                    
                    <div id="openModalAsignar" class="modalDialog">
	<div>
		<a href="#close" title="Close" class="close">X</a>
		<h2>Asignar inspector</h2>
                                
                <div class="container">
                   <div class="row">
                        <div class="span2">
                Nombre Inspector 
                </div>
                <div class="span10">                    
               
                    
                    
                    <select name="comboInspector" onclick="prueba()">
                  <%
                 LinkedList<Inspector> listaInspector=InspectorBussines.ListaInspector();
                 for(int i=0;i<listaInspector.size();i++){
                     out.println("<option value='"+listaInspector.get(i).getRut()+"'>");
                     out.println(listaInspector.get(i).getNombre()+" "+listaInspector.get(i).getApellido());
                     out.println("</option>");
                 }
                 %>      
                </select>
                               
                    </div>        
                        <div class="span2">Sector
                            </div>
                        
                        <div class="span10">
                            <select name="combo" onchange="actComboSS()">
                                
                            <%    
                        LinkedList<Sector> listSector=AsignarBussines.ListaSector();
                        for(int i=0;i<listSector.size();i++){
                            out.println("<option value='"+listSector.get(i).getId()+"'>");
                            out.println(listSector.get(i).getNombre());
                            out.println("</option>");
                                     }                                                          
                              %>
                                
                            </select>
                        </div>
                        <div class="span2">Sub sector
                            </div>
                        <div class="span10">
                            <select name="comboSubSectorAsignar" id="comboss">
                                
                                <option value="">Seleccione</option>
                                                                         
                            </select>
                            
                            <input type="hidden" name="idObra" value=<%=request.getParameter("idObra")%>>                                               
                        </div>
                </div>
                                   <input type="submit" value="Asignar" id="btnAsignar"/>
                </div>
               
	</div>
</div>
                            </form>    
        
                    <%--Fin de  Ventana pop-up--%>
                    
                    
                    <%-- Ventana pop-up-Visualizar--%>                   
                    <div id="openModalAsignar" class="modalDialog">
	<div>
		<a href="#close" title="Close" class="close">X</a>
		<h2>Visualizar obra</h2>
                
                <div class="container">
                    <div class="row">
                        <div class="span2">
                Nombre Inspector 
                </div>
                <div class="span10">
                <select name="comboInspector">
                </select>
                    </div>        
                        <div class="span2">Sector
                            </div>
                        
                        <div class="span10"><select name="comboSectorAsignar">
                            </select>
                        </div>
                        <div class="span2">Sub sector
                            </div>
                        <div class="span10"><select name="comboSubSectorAsignar">
                                   </select></div>
                </div>
                </div>
                <input type="submit" value="Asignar" id="btnAsignar"/>
	</div>
                    
</div>
                    
                    <%--Fin de  Ventana pop-up--%>
        
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script type="text/javascript"	src="complementos/js/homeScript.js"></script>

    </body>
</html>
