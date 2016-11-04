
package DAO;

import BD.Conexion;
import Entidad.Obra;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import javax.persistence.Table;
import javax.swing.table.DefaultTableModel;



public class ObraDao {
         
    DefaultTableModel dtm=new DefaultTableModel();
    
    Conexion conexion=new Conexion();
    
    public  static LinkedList<Obra> asignar() throws SQLException{
        LinkedList<Obra> listaAsignar=new LinkedList<Obra>();
                String query="select id, nombre, direccion from obra where estado='NA';";
       Connection connection=Conexion.conectarBD();
        Statement statement= connection.createStatement();
        ResultSet resultSet= statement.executeQuery(query);
        try{
            while (resultSet.next()) {
            Obra obra=new Obra();
            obra.setNombre(resultSet.getString("nombre"));
            obra.setDireccion(resultSet.getString("direccion"));
            obra.setId(Integer.parseInt(resultSet.getString("id")));
            listaAsignar.add(obra);
        }
        }catch(Exception e){
            }    
        
     return listaAsignar;
    }
    
        public static LinkedList<Obra> visualizar() throws SQLException{
        LinkedList<Obra> listaAsignar=new LinkedList<Obra>();
                String query="select nombre, direccion from obra where estado='A';";
       Connection connection=Conexion.conectarBD();
        Statement statement= connection.createStatement();
        ResultSet resultSet= statement.executeQuery(query);
        try{
            while (resultSet.next()) {
            Obra obra=new Obra();
            obra.setNombre(resultSet.getString("nombre"));
            obra.setDireccion(resultSet.getString("direccion"));
            listaAsignar.add(obra);
        }
        }catch(Exception e){
            }    
        
     return listaAsignar;
    }
}
