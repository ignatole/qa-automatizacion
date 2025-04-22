package com.enviopack.tests;

import com.enviopack.common.BaseTest;
import com.enviopack.integration.testrailintegration; // 🔹 Importar la clase de integración
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import org.json.JSONObject;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginTest extends BaseTest {
    private static final int PROJECT_ID = 16; // ID real del proyecto en TestRail
    private static final String TEST_CASE_ID_ADMIN = "C8025"; // Login admin
    private static final String TEST_CASE_ID_SELLER = "C8026"; // Login seller
    private static final String TEST_CASE_ID_INVALID = "C8029"; // Login inválido
    private int runId; // Almacena el ID del Test Run

    public LoginTest() {
        try {
            // 1️⃣ Crear un Test Run en TestRail
            JSONObject runPayload = new JSONObject();
            runPayload.put("name", "Login Test Run - " + System.currentTimeMillis());
            runPayload.put("include_all", true);

            JSONObject runResponse = testrailintegration.sendPost("add_run/" + PROJECT_ID, runPayload);

            // Validar si el runId se obtuvo correctamente
            if (runResponse.has("id")) {
                runId = runResponse.getInt("id");
                System.out.println("✅ Test Run creado con ID: " + runId);
            } else {
                throw new RuntimeException("⚠ Error al crear Test Run en TestRail.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("🚨 No se pudo conectar con TestRail.");
        }
    }

    @Test
    public void testLoginAsAdmin() {
        reportTestResult(() -> {
            loginAs("admin");
            String currentUrl = driver.getCurrentUrl();
            assertTrue(currentUrl.contains("/backoffice"), "La URL no corresponde a la página de admin.");
        }, TEST_CASE_ID_ADMIN);
    }

    @Test
    public void testLoginAsSeller() {
        reportTestResult(() -> {
            loginAs("seller");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains("ordenes"));
            String currentUrl = driver.getCurrentUrl();
            assertTrue(currentUrl.contains("ordenes"), "La URL no corresponde a la página de seller.");
        }, TEST_CASE_ID_SELLER);
    }

    @Test
    public void testLoginFailWithInvalidRole() {
        reportTestResult(() -> {
            try {
                loginAs("invalidRole");
                fail("Se esperaba una excepción por rol no válido.");
            } catch (IllegalArgumentException e) {
                assertEquals(e.getMessage(), "Rol de usuario desconocido: invalidRole", "El mensaje de error no es el esperado.");
            }
        }, TEST_CASE_ID_INVALID);
    }

    private void reportTestResult(Runnable test, String testCaseId) {
        int status = 1; // 1 = Passed, 5 = Failed
        int caseId = Integer.parseInt(testCaseId.replace("C", "")); // Convertir a número

        try {
            test.run(); // Ejecutar la prueba
        } catch (Exception e) {
            status = 5; // Marcar como fallida
            e.printStackTrace(); // Mostrar error en consola
        } finally {
            try {
                JSONObject payload = new JSONObject();
                payload.put("status_id", status);
                payload.put("comment", "Resultado de la prueba automatizada.");

                JSONObject response = testrailintegration.sendPost("add_result_for_case/" + runId + "/" + caseId, payload);
                System.out.println("✅ Resultado reportado en TestRail para el caso: " + testCaseId + " (ID real: " + caseId + ")");

            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("❌ Error al reportar resultado en TestRail para el caso: " + testCaseId);
            }
        }
    }
}