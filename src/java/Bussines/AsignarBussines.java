
package Bussines;

import Entidad.Formulario;
import Entidad.Inspector;
import Entidad.Obra;
import Entidad.Sector;
import Entidad.SubSector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class AsignarBussines {
    
    public static LinkedList<Inspector> ListaInspector() throws SQLException, JSONException{
        LinkedList<Inspector> listaInspector=new LinkedList<Inspector>();
    try {

		URL url = new URL("http://localhost:8084/WebServiceCDC/webresources/generic/obtenerInspector");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		String output;
		output = br.readLine();
                
            JSONArray array = new JSONArray(output);
            for (int i = 0; i < array.length(); i++) {
            JSONObject row = array.getJSONObject(i);
            Inspector inspector=new Inspector();
            inspector.setId(row.getInt("id"));
            inspector.setNombre(row.getString("nombre"));
            inspector.setApellido(row.getString("apellido"));
            inspector.setRut(row.getString("rut"));
            
            listaInspector.add(inspector);
}
            conn.disconnect();
          } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	  }
        return listaInspector;    
}
    
    
    public static LinkedList ListaSector(int idObra) throws SQLException, JSONException{
       LinkedList<Sector> listaSector=new LinkedList<Sector>();
 
                try {

		URL url = new URL("http://localhost:8084/WebServiceCDC/webresources/generic/obtenerSector?idObra="+idObra);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		String output;
		output = br.readLine();
                
            JSONArray array = new JSONArray(output);
            for (int i = 0; i < array.length(); i++) {
            JSONObject row = array.getJSONObject(i);
            Sector sector=new Sector();
            sector.setId(row.getString("id"));
            sector.setNombre(row.getString("nombre"));
                       
            listaSector.add(sector);
}
            conn.disconnect();
          } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	  }
        
        return listaSector;    
    }
    
    public static LinkedList ListaSubSector(int id) throws SQLException, JSONException{
       LinkedList<SubSector> listaSubSector=new LinkedList<SubSector>();
 
                try {

		URL url = new URL("http://localhost:8084/WebServiceCDC/webresources/generic/obtenerSubSector?idSector="+id);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		String output;
		output = br.readLine();
                
            JSONArray array = new JSONArray(output);
            for (int i = 0; i < array.length(); i++) {
            JSONObject row = array.getJSONObject(i);
            SubSector subSector=new SubSector();
            subSector.setId(row.getInt("id"));
            subSector.setNombre(row.getString("nombre"));
                       
            listaSubSector.add(subSector);
}
            conn.disconnect();
          } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	  }
        
        return listaSubSector;    
    }
    
    public static LinkedList ListaFormulario() throws SQLException, JSONException{
       LinkedList<Formulario> listaFormulario=new LinkedList<Formulario>();
    
                       try {

		URL url = new URL("http://localhost:8084/WebServiceCDC/webresources/generic/obtenerFormulario");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		String output;
		output = br.readLine();
                
            JSONArray array = new JSONArray(output);
            for (int i = 0; i < array.length(); i++) {
            JSONObject row = array.getJSONObject(i);
            Formulario formulario=new Formulario();
            formulario.setId(row.getInt("id"));
            formulario.setNombre(row.getString("nombre"));
                       
            listaFormulario.add(formulario);
}
            conn.disconnect();
          } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	  }
       
        return listaFormulario;   
    }
    
    public void Asignar(int idObra, int idSector, int idSubSector,int idInspector, int idFormulario) throws SQLException{
      try {

		URL url = new URL("http://localhost:8084/WebServiceCDC/webresources/generic/asignar?idObra="+idObra+"&idSector="+idSector+""
                        + "&idSubSector="+idSubSector+"&idInspector="+idInspector+"&idFormulario="+idFormulario);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		String output;
		output = br.readLine();
                
            conn.disconnect();
          } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	  }
    }

    
}
