
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
    
    public static LinkedList ListaSubSector(int id) throws SQLException{
        return AsignarDAO.obtenerSubSector(id);
    }
    
}
