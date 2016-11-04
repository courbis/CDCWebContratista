
package Bussines;

import DAO.AsignarDAO;
import DAO.InspectorDAO;
import java.sql.SQLException;
import java.util.LinkedList;


public class AsignarBussines {
    
    public static LinkedList ListaInspector() throws SQLException{
        return AsignarDAO.obtenerInspector();
    }
    
    public static LinkedList ListaSector() throws SQLException{
        return AsignarDAO.obtenerSector();
    }
    
    public static LinkedList ListaSubSector(String id) throws SQLException{
        return AsignarDAO.obtenerSubSector(id);
    }
    public void Asignar(String idObra, String idSector, String idSubSector, String idInspector) throws SQLException{
     AsignarDAO aO=new AsignarDAO();
     aO.Asignar(idObra, idSector, idSubSector, idInspector);
    }
    
}
