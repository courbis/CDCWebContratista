
package DAO;

import BD.Conexion;
import Entidad.Inspector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;


public class InspectorDAO {
    String nombreInspector;
    String apellidoInspector;
    String rutInspector;
    String estado;
    String query;
    Conexion conexion=new Conexion();
    public void AsignarObra(String rutInspector, String obra) throws SQLException{
    query="insert into obra_asignada(rut_inspector, obra) values('"+rutInspector+"','"+obra+"');";
        Connection connection=conexion.conectarBD();
        Statement statement= connection.createStatement();
        ResultSet resultSet= statement.executeQuery(query);
}
    
    public static LinkedList<Inspector> obtenerInspector() throws SQLException{
        LinkedList<Inspector> listaInspector=new LinkedList<Inspector>();
    String query="select nombre, apellido, rut from inspector";
        Connection connection=Conexion.conectarBD();
        Statement statement= connection.createStatement();
        ResultSet resultSet= statement.executeQuery(query);  
        while(resultSet.next()){
            Inspector inspector=new Inspector();
            inspector.setNombre(resultSet.getString("nombre"));
            inspector.setApellido(resultSet.getString("apellido"));
            inspector.setRut(resultSet.getString("rut"));
            listaInspector.add(inspector);
            
            
        }
        return listaInspector;
            
        
    }
            
}
