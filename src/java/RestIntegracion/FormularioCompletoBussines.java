
package RestIntegracion;

import Entidad.FormularioCompleto;
import Entidad.Obra;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FormularioCompletoBussines {
    
    public static LinkedList<FormularioCompleto> visualizarGlobal() throws JSONException {
        LinkedList<FormularioCompleto> listaFormularioCompleto=new LinkedList<FormularioCompleto>();
try {

		URL url = new URL("http://localhost:8084/WebServiceCDC/webresources/generic/visualizar1");
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
            FormularioCompleto fc=new FormularioCompleto();
            fc.setIdTareaAsignada(row.getInt("idTareaAsignada"));
            fc.setObra(row.getString("obra"));
            fc.setFecha(row.getString("fecha"));
            fc.setInspector(row.getString("inspector"));
            listaFormularioCompleto.add(fc);
}
            conn.disconnect();
                

		

	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	  }
     return listaFormularioCompleto;
    }
    
}
