
package Bussines;

import DAO.InspectorDAO;
import java.sql.SQLException;
import java.util.LinkedList;


public class InspectorBussines {
    
    
    public static LinkedList ListaInspector() throws SQLException{
        return InspectorDAO.obtenerInspector();
    }
    
}
