
package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    
    private java.sql.Connection con = null;
    private final String url = "jdbc:sqlserver://";
    private final String serverName = "USUARIO-HP";
    private final String portNumber = "1433";
    private final String databaseName = "cdc_web";
    private final String userName = "courbis";
    private final String password = "6186";
    // Indica al controlador que debe utilizar un cursor de servidor, // lo que permite más de una instrucción activa // en una conexión.
    private final String selectMethod = "cursor";

    // Constructor public Connect(){}
    private String getConnectionUrl() {
        return url + serverName + ":" + portNumber + ";databaseName=" + databaseName + ";selectMethod=" + selectMethod + ";";
    }

    private java.sql.Connection getConnection() {
        try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = java.sql.DriverManager.getConnection(getConnectionUrl(), userName, password);
            if (con != null) {
                System.out.println("Conexión correcta.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error de seguimiento en getConnection() : " + e.getMessage());
        }
        return con;
    }

    /* Mostrar las propiedades del controlador y los detalles de la base de datos */
    public void displayDbProperties() {
        java.sql.DatabaseMetaData dm = null;
        java.sql.ResultSet rs = null;
        try {
            con = this.getConnection();
            if (con != null) {
                dm = con.getMetaData();
                System.out.println("Información del controlador");
                System.out.println("\tNombre del controlador: " + dm.getDriverName());
                System.out.println("\tVersión del controlador: " + dm.getDriverVersion());
                System.out.println("\nInformación de la base de datos ");
                System.out.println("\tNombre de la base de datos: " + dm.getDatabaseProductName());
                System.out.println("\tVersión de la base de datos: " + dm.getDatabaseProductVersion());
                System.out.println("Catálogos disponibles ");
                rs = dm.getCatalogs();
                while (rs.next()) {
                    System.out.println("\tcatálogo: " + rs.getString(1));
                }
                rs.close();
                rs = null;
                closeConnection();
            } else {
                System.out.println("Error: No hay ninguna conexión activa");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        dm = null;
    }

    private void closeConnection() {
        try {
            if (con != null) {
                con.close();
            }
            con = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main (String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
         Conexion myDbTest = new Conexion();
        myDbTest.displayDbProperties();
    }
    
}
