/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussines;


import Entidad.Obra;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Julio
 */
public class ObraBussines {
    
   
public static LinkedList<Obra> asignar() throws JSONException {
        LinkedList<Obra> listaAsignar=new LinkedList<Obra>();
try {

		URL url = new URL("http://localhost:8084/WebServiceCDC/webresources/generic/obtenerObra");
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
            Obra obra=new Obra();
            obra.setId(row.getInt("id"));
            obra.setNombre(row.getString("nombre"));
            obra.setDireccion(row.getString("direccion"));
            listaAsignar.add(obra);      
}
            conn.disconnect();
                

		

	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	  }
     return listaAsignar;
    }
    
public static LinkedList<Obra> visualizar() throws JSONException {
        LinkedList<Obra> listaAsignar=new LinkedList<Obra>();
try {

		URL url = new URL("http://localhost:8084/WebServiceCDC/webresources/generic/obtenerObra");
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
            Obra obra=new Obra();
            obra.setId(row.getInt("id"));
            obra.setNombre(row.getString("nombre"));
            obra.setDireccion(row.getString("direccion"));
            listaAsignar.add(obra);      
}
            conn.disconnect();
                

		

	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	  }
     return listaAsignar;
    }
      
          
    
}
