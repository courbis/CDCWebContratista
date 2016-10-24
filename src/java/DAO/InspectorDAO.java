
package DAO;

import BD.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


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
    
    public void obtenerInspector() throws SQLException{
    query="select nombre, apellido, rut from inspector";
        Connection connection=conexion.conectarBD();
        Statement statement= connection.createStatement();
        ResultSet resultSet= statement.executeQuery(query);    
        String arregloInspector[][];
        while(resultSet.next()){
            
        }
            
        
    }
            
}
