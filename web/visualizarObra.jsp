<%-- 
    Document   : asignar
    Created on : 23-oct-2016, 15:06:03
    Author     : Julio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String nombreObra=""; %>

<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="complementos/bootstrap/css/bootstrap.css"/>  
        <link rel="stylesheet" type="text/css" href="complementos/css/visualizarObra.css"/>
        <title>Visualizar</title>
    </head>
    <body>
        <h1>Visualizar Obra <%=nombreObra%></h1>
        
        <div class="container">
            
            <div class="row">
                
                <div>
                    
                    <div class="span3">
                        
                        Sector<select name="comboSector">
                            <option></option>
                            <option></option>
                        </select>
                        
                    </div>
                    <div class="span3">
                        
                        Sub-Sector<select name="comboSubSector">
                            <option></option>
                            <option></option>
                        </select>
                        
                    </div>
                    <div class="span3">
                        
                        Fecha<select name="comboFecha">
                            <option></option>
                            <option></option>
                        </select>
                      
                        
                    </div>
                    <div class="span3">
                        
                        Tipo de Formulario<select name="comboTipoDeFormulario">
                            <option></option>
                            <option></option>
                        </select>
                        
                    </div>
                    
                </div>
                
            </div>
            
        </div>
        


</html>
