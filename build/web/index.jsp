<%@page import="Bussines.LoginBussines"%>
<%@page import="java.sql.SQLException"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="complementos/bootstrap/css/bootstrap.css"/>    
        <link rel="stylesheet" type="text/css" href="complementos/css/login.css"/>
        <title>CDC Web</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="span4"></div>
                <div class="span4">
                    <div class="contenedorLogin">
                    <h2>Autenticación</h2>
                    <br>
                    <br>
            <form action="LoginBussines" method="post" >
                Usuario
                <br>
                <input type="text" name="user" id="user"/> 
                <br>
                Contraseña
                <br>
                <input type="password" name="pass" id="pass"/> 
                    <br>
                    <br>
                    <input type="submit" name="entrar" id="entrar" value="Entrar"/> 
        </form>
                    <img id="imgInspeccion" src="complementos/imagenes/img_inspeccion.png"/>
                    <h4 id="slogan">Control de calidad para obras civiles</h4>
                    </div>
                </div>
                <div class="span4"></div>
                
          </div>  
        </div>
        
    </body>
</html>


<% 

LoginBussines lbussines=new LoginBussines();
%>