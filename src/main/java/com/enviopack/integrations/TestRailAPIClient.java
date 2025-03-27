package com.enviopack.integrations;

import com.gurock.testrail.APIClient;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.Map;

public class TestRailAPIClient {
    private final APIClient client;

    public TestRailAPIClient(String username, String password, String url) {
        client = new APIClient(url);
        client.setUser(username);
        client.setPassword(password);
    }

    /**
     * Envía una solicitud GET a TestRail y devuelve la respuesta en formato JSON.
     * 
     * @param "endpoint" Ruta del API de TestRail (ejemplo: "get_case/1").
     * @return "Respuesta" de la API en formato JSONObject.
     * @throws "IOException" Si hay un problema en la comunicación con la API.
     */
    public JSONObject sendGetRequest(String endpoint) throws IOException {
        try {
            return (JSONObject) client.sendGet(endpoint);
        } catch (Exception e) {
            throw new IOException("Error al enviar solicitud GET a TestRail: " + endpoint, e);
        }
    }

    /**
     * Envía una solicitud POST a TestRail con los datos especificados.
     * 
     * @param "endpoint" Ruta del API de TestRail (ejemplo: "add_result_for_case/1/1001").
     * @param "data" Datos que se enviarán en la solicitud.
     * @return "Respuesta" de la API en formato JSONObject.
     * @throws "IOException" Si hay un problema en la comunicación con la API.
     */
    public JSONObject sendPostRequest(String endpoint, Map<String, String> data) throws IOException {
        try {
            return (JSONObject) client.sendPost(endpoint, data);
        } catch (Exception e) {
            throw new IOException("Error al enviar solicitud POST a TestRail: " + endpoint, e);
        }
    }
}

