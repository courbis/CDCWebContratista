/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussines;

import DAO.ObraDao;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Julio
 */
public class ObraBussines {
    
   
    public static LinkedList asignar() throws SQLException{
        return ObraDao.asignar();
    }
    
    public static LinkedList visualizar() throws SQLException{
        return ObraDao.visualizar();
    }
      
          
    
}
