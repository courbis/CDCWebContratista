<%-- 
    Document   : home
    Created on : 18-oct-2016, 20:10:27
    Author     : Julio
--%>

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
                <div class="boton">Asignar</div>
            </div>
            <div class="span6">
                <link><div class="boton">Visualizar</div>
                
            </div>
            </div>
        </div>
        
    </body>
</html>
