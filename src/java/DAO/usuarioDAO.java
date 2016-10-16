package DAO;

import BD.Conexion;
import Entidad.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

public class usuarioDAO {
Usuario usuario = new Usuario();
    String nombre="";
    String apellido="";
    
    Conexion conexion=new Conexion();
    
    public void autenticacion(String rut, String pass) throws SQLException{
        String query="select nombre, apellido from usuario where rut='"+rut+"' and pass='"+pass+"';";
        Connection connection=conexion.conectarBD();
        Statement statement= connection.createStatement();
        ResultSet resultSet= statement.executeQuery(query);
        
while(resultSet.next()){
    nombre=resultSet.getString(1);
    apellido=resultSet.getString(2);
    
    usuario.setNombre(nombre);
    usuario.setApellido(apellido);
    System.out.println("nombre= "+nombre+", apellido= "+apellido);
}
        
        }
 
 public String nombre()   {
     return nombre;
 }
 
 public String apellido(){
     return apellido;
 }
        
    
   
} 

