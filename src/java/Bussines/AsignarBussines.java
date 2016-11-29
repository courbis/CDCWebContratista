
package Bussines;

import DAO.AsignarDAO;
import DAO.InspectorDAO;
import java.sql.SQLException;
import java.util.LinkedList;


public class AsignarBussines {
    
    public static LinkedList ListaInspector() throws SQLException{
        return AsignarDAO.obtenerInspector();
    }
    
    public static LinkedList ListaSector(int idObra) throws SQLException{
        return AsignarDAO.obtenerSector(idObra);
    }
    
    public static LinkedList ListaSubSector(int id) throws SQLException{
        return AsignarDAO.obtenerSubSector(id);
    }
    
    public static LinkedList ListaFormulario() throws SQLException{
        return AsignarDAO.obtenerTipoFormulario();
    }
    
    public void Asignar(int idObra, int idSector, int idSubSector,int idInspector, int idFormulario) throws SQLException{
     AsignarDAO aO=new AsignarDAO();
     aO.Asignar(idObra, idSector, idSubSector, idInspector,idFormulario);
    }

    
}
