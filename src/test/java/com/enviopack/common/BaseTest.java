package com.enviopack.common;

import com.enviopack.driver.DriverManager;
import com.enviopack.factory.DriverManagerFactory;
import com.enviopack.pages.LoginPage;
import com.enviopack.driver.IDriverManager;
import com.enviopack.config.ConfigLoader;
import com.enviopack.enums.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    private String url;
    protected ConfigLoader configLoader = ConfigLoader.getInstance();
    
    @BeforeMethod
    public void setUp() {
        url = configLoader.getBaseUrl();
        Browser browser = Browser.valueOf(configLoader.getBrowser().toUpperCase());
        IDriverManager driverManager = DriverManagerFactory.getManager(browser);
        driver = driverManager.createDriver();
        DriverManager.setDriver(driver);
        driver.get(url);
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }

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

