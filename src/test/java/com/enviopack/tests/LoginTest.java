package com.enviopack.tests;

import com.enviopack.common.BaseTest;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginAsAdmin() {
        loginAs("admin");
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("/backoffice"), "La URL no corresponde a la página de admin.");
    }

    @Test
    public void testLoginAsSeller() {
        loginAs("seller");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("ordenes"));
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("ordenes"), "La URL no corresponde a la página de seller.");
    }

    @Test
    public void testLoginFailWithInvalidRole() {
        try {
            loginAs("invalidRole");
            fail("Se esperaba una excepción por rol no válido.");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Rol de usuario desconocido: invalidRole", "El mensaje de error no es el esperado.");
        }
    }
}

