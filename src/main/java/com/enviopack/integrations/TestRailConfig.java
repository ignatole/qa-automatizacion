package com.enviopack.integrations;

public class TestRailConfig {
    private static TestRailAPIClient apiClient;
    private static TestRailService testRailService;

    // Método de inicialización que solo configura la APIClient y TestRailService una vez
    public static void initialize(String username, String password, String url, int runId) throws Exception {
        if (apiClient == null || testRailService == null) {
            apiClient = new TestRailAPIClient(username, password, url);
        }
    }

    // Métodos para obtener las instancias configuradas
    public static TestRailAPIClient getApiClient() {
        return apiClient;
    }
}

