package com.enviopack.integrations;

import org.json.simple.JSONObject;
import org.testng.ITestResult;
import com.enviopack.annotations.TestCaseId;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class TestRailService {

    private TestRailAPIClient apiClient;
    private int runId;

    public TestRailService(String username, String password, String url) throws Exception {
        String runIdStr = System.getProperty("run_id");
        if (runIdStr != null && !runIdStr.isEmpty()) {
            try {
                this.runId = Integer.parseInt(runIdStr);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("El run_id debe ser un número entero válido.");
            }
        } else {
            this.runId = -1; // Valor por defecto si no se proporciona run_id
        }

        this.apiClient = new TestRailAPIClient(username, password, url);
    }

    public void reportTestResultFromResult(ITestResult result) {
        try {
            Method method = result.getMethod().getConstructorOrMethod().getMethod();
            if (method.isAnnotationPresent(TestCaseId.class)) {
                int testCaseId = method.getAnnotation(TestCaseId.class).value();
                
                int status;
                String comment;

                if (result.getStatus() == ITestResult.SUCCESS) {
                    status = 1; // Passed
                    comment = "Prueba pasada exitosamente.";
                } else {
                    status = 5; // Failed
                    
                    // Obtener el mensaje del error si falló
                    Throwable throwable = result.getThrowable();
                    comment = (throwable != null) ? "Error: " + throwable.getMessage() : "Prueba fallida.";
                }

                System.out.println("Subiendo resultado a TestRail...");
                reportTestResult(testCaseId, status, comment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reportTestResult(int testCaseId, int status, String comment) {
        if (runId == -1) {
            System.out.println("No se proporcionó run_id. No se reportará el resultado en TestRail.");
            return;
        }

        try {
            String endpoint = String.format("add_result_for_case/%d/%d", runId, testCaseId);
            Map<String, String> data = new HashMap<>();
            data.put("status_id", String.valueOf(status));
            data.put("comment", comment);

            JSONObject response = apiClient.sendPostRequest(endpoint, data);
            if (response != null) {
                System.out.println("Resultado reportado en TestRail con éxito.");
            } else {
                System.out.println("Error al reportar el resultado en TestRail.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al reportar el resultado en TestRail.");
        }
    }
}
