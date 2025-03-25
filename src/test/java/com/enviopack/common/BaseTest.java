package com.enviopack.common;

import com.enviopack.annotations.TestCaseId;
import com.enviopack.driver.DriverManager;
import com.enviopack.factory.DriverManagerFactory;
import com.enviopack.pages.LoginPage;
import com.enviopack.driver.IDriverManager;
import com.enviopack.config.ConfigLoader;
import com.enviopack.enums.Browser;
import com.enviopack.integrations.TestRailService;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public abstract class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    private String url;
    protected ConfigLoader configLoader = ConfigLoader.getInstance();
    private TestRailService testRailService;

    // Inicialización de TestRailService en el setup
    @BeforeMethod
    public void setUp() {
        try {
            // Inicializar el servicio TestRailService con las credenciales y la URL del TestRail
            String username = configLoader.getTestRailUsername();
            String password = configLoader.getTestRailPassword();
            String testRailUrl = configLoader.getTestRailUrl();
            this.testRailService = new TestRailService(username, password, testRailUrl);

            // Configuración del WebDriver
            url = configLoader.getBaseUrl();
            Browser browser = Browser.valueOf(configLoader.getBrowser().toUpperCase());
            IDriverManager driverManager = DriverManagerFactory.getManager(browser);
            driver = driverManager.createDriver();
            DriverManager.setDriver(driver);
            driver.get(url);
            loginPage = new LoginPage(driver);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al inicializar la configuración o el WebDriver: " + e.getMessage(), e);
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (DriverManager.getDriver() != null) {
            try {
                if (testRailService != null) {
                    testRailService.reportTestResultFromResult(result);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }


    // Método para hacer login según el rol
    public void loginAs(String role) {
        loginPage.load();
        String email = "";
        String password = "";
        if (role.equals("admin")) {
            email = configLoader.getAdminEmail();
            password = configLoader.getAdminPassword();
        } else if (role.equals("seller")) {
            email = configLoader.getSellerEmail();
            password = configLoader.getSellerPassword();
        } else {
            throw new IllegalArgumentException("Rol de usuario desconocido: " + role);
        }
        loginPage.enterEmail(email)
                 .enterPassword(password)
                 .clickLogin();
    }
}
