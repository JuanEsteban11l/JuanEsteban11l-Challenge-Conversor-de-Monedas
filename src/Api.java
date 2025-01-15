import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Api {
    public static double obtenerTasaConversion(String monedaOrigen, String monedaDestino) throws Exception {
        String apiKey = "3777f2be58e071a5aedb0e81";
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + monedaOrigen;

        URL apiUrl = new URL(url);
        HttpURLConnection conexion = (HttpURLConnection) apiUrl.openConnection();
        conexion.setRequestMethod("GET");

        BufferedReader lector = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        StringBuilder respuesta = new StringBuilder();
        String linea;
        while ((linea = lector.readLine()) != null) {
            respuesta.append(linea);
        }
        lector.close();

        JSONObject json = new JSONObject(respuesta.toString());
        return json.getJSONObject("conversion_rates").getDouble(monedaDestino);
    }
}
