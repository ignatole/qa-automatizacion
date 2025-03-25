package com.enviopack.integrations;

import com.gurock.testrail.APIClient;
import org.json.simple.JSONObject;

import java.util.Map;

public class TestRailAPIClient {
    private APIClient client;

    public TestRailAPIClient(String username, String password, String url) throws Exception {
        client = new APIClient(url);
        client.setUser(username);
        client.setPassword(password);
    }

    // Métodos para enviar solicitudes GET y POST a la API.
    public JSONObject sendGetRequest(String endpoint) throws Exception {
        return (JSONObject) client.sendGet(endpoint);
    }

    public JSONObject sendPostRequest(String endpoint, Map<String, String> data) throws Exception {
        return (JSONObject) client.sendPost(endpoint, data);
    }
}

