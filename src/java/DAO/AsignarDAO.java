
package DAO;

import BD.Conexion;
import Entidad.Formulario;
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
    String query="select id_usuario, nombre, apellido, rut from usuario where tipo_usuario=2";
        Connection connection=Conexion.conectarBD();
        Statement statement= connection.createStatement();
        ResultSet resultSet= statement.executeQuery(query);  
        while(resultSet.next()){
            Inspector inspector=new Inspector();
            inspector.setNombre(resultSet.getString("nombre"));
            inspector.setApellido(resultSet.getString("apellido"));
            inspector.setRut(resultSet.getString("rut"));
            inspector.setId(resultSet.getInt("id_usuario"));
            listaInspector.add(inspector);    
            
        }
        return listaInspector;    
}
    
    public static LinkedList<Sector> obtenerSector(int idObra) throws SQLException{
        LinkedList<Sector> listaSector=new LinkedList<Sector>();
    String query="select sector.id_sector, tipo_sector.detalle+''+sector.detalle as sector from sector, tipo_sector, sector_obra where sector.id_sector=sector_obra.id_sector and sector.id_tipo_sector=tipo_sector.id_tipo_sector and id_obra="+idObra+";";
        Connection connection=Conexion.conectarBD();
        Statement statement= connection.createStatement();
        ResultSet resultSet= statement.executeQuery(query);  
        while(resultSet.next()){
            Sector sector=new Sector();
            sector.setNombre(resultSet.getString("sector"));
            sector.setId(resultSet.getString("id_sector"));
            listaSector.add(sector);    
            
        }
        return listaSector;    
}
    
    public static LinkedList<SubSector> obtenerSubSector(int id) throws SQLException{
        LinkedList<SubSector> listaSubSector=new LinkedList<SubSector>();
    String query="select id_subsector, tipo_subsector.detalle+''+subsector.detalle as subsector "
            + "from obra,sector,tipo_sector,subsector,tipo_subsector,sector_obra "
            + "where sector_obra.id_sector=sector.id_sector and sector_obra.id_obra=obra.id_obra and "
            + "sector.id_tipo_sector=tipo_sector.id_tipo_sector and subsector.id_obra_sector=sector_obra.id_sector_obra and "
            + "tipo_subsector.id_tipo_subsector=subsector.id_tipo_subsector and sector.id_sector="+id+";";
        Connection connection=Conexion.conectarBD();
        Statement statement= connection.createStatement();
        ResultSet resultSet= statement.executeQuery(query);  
        while(resultSet.next()){
            SubSector subSector=new SubSector();
            subSector.setNombre(resultSet.getString("subsector"));
            subSector.setId(resultSet.getInt("id_subsector"));
            listaSubSector.add(subSector);
            
        }
        return listaSubSector;    
}
    
    public static void Asignar(int idObra, int idSector, int idSubSector, int idInspector, int idFormulario) throws SQLException{
        String query="insert into tarea_asignada(id_tarea_asignada,id_usuario,id_sector_obra,id_subsector,id_obra,fecha,id_tipo_formulario)values"
                + "((SELECT MAX(id_tarea_asignada)+1 from tarea_asignada),"+idInspector+","+idSector+","+idSubSector+","+idObra+",GETDATE(),"+idFormulario+");";
        Connection connection=Conexion.conectarBD();
        Statement statement= connection.createStatement();
        statement.executeUpdate(query);
           
    }

    public static LinkedList<Formulario> obtenerTipoFormulario() throws SQLException{
        LinkedList<Formulario> listaFormulario=new LinkedList<Formulario>();
    String query="select *from cdc_contratista.dbo.tipo_formulario;";
        Connection connection=Conexion.conectarBD();
        Statement statement= connection.createStatement();
        ResultSet resultSet= statement.executeQuery(query);  
        while(resultSet.next()){
            Formulario formulario=new Formulario();
            formulario.setNombre(resultSet.getString("detalle"));
            formulario.setId(resultSet.getInt("id_tipo_formulario"));
            listaFormulario.add(formulario);    
            
        }
        return listaFormulario;    
}}