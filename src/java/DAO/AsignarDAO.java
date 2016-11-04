
package DAO;

import BD.Conexion;
import Entidad.Inspector;
import Entidad.Sector;
import Entidad.SubSector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;


public class AsignarDAO {
    
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
    
    public static LinkedList<Sector> obtenerSector() throws SQLException{
        LinkedList<Sector> listaSector=new LinkedList<Sector>();
    String query="select id_sector, nombre_sector from sector;";
        Connection connection=Conexion.conectarBD();
        Statement statement= connection.createStatement();
        ResultSet resultSet= statement.executeQuery(query);  
        while(resultSet.next()){
            Sector sector=new Sector();
            sector.setNombre(resultSet.getString("nombre_sector"));
            sector.setId(resultSet.getString("id_sector"));
            listaSector.add(sector);    
            
        }
        return listaSector;    
}
    
    public static LinkedList<SubSector> obtenerSubSector(String id) throws SQLException{
        LinkedList<SubSector> listaSubSector=new LinkedList<SubSector>();
    String query="select id_subsector, nombre_subsector from sub_sector where id_sector="+id;
        Connection connection=Conexion.conectarBD();
        Statement statement= connection.createStatement();
        ResultSet resultSet= statement.executeQuery(query);  
        while(resultSet.next()){
            SubSector subSector=new SubSector();
            subSector.setNombre(resultSet.getString("nombre_subsector"));
            subSector.setId(resultSet.getString("id_subsector"));
            listaSubSector.add(subSector);
            
        }
        return listaSubSector;    
}
    
    public static void Asignar(String idObra, String idSector, String idSubSector, String idInspector) throws SQLException{
        String query="insert into o_asignada(id_obra_asignada, id_obra, id_sector, id_subsector, id_inspector, fecha) values((SELECT MAX(id_obra_asignada) + 1 FROM o_asignada),"
                + idObra+","+idSector+","+idSubSector+",'"+idInspector+"',GETDATE());";
        Connection connection=Conexion.conectarBD();
        Statement statement= connection.createStatement();
        statement.executeUpdate(query);
           
    }}
