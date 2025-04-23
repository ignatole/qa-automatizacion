package com.enviopack.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.enviopack.annotations.TestCaseId;
import com.enviopack.common.BaseTest;
import com.enviopack.pages.BackOfficePage;
import com.enviopack.pages.order.FirsStepCreateOrderPage;
import com.enviopack.pages.order.OrderCommonPage;
import com.enviopack.pages.order.SecondStepCreateOrderPage;
import com.enviopack.pages.AccessAccountPage;
public class LoginPracticeTest extends BaseTest {
    
	@Test
    @TestCaseId(8023)
    public void clickaccesaccount() throws InterruptedException {
        BackOfficePage backOfficePage = new BackOfficePage(driver);
        loginAs("admin");
        Thread.sleep(11000);
        String expected = "https://qa1-appv2.enviopack.om/backoffice";
        String actual = backOfficePage.getCurrentUrl();
        Assert.assertEquals(actual, expected);
       }
    
    @Test@Ignore
    @TestCaseId(8023)
    public void acceseAccountInput() throws InterruptedException {
        BackOfficePage backOfficePage = new BackOfficePage(driver);
        loginAs("admin");
        backOfficePage.clickAccessAccountButton();
        AccessAccountPage acccesAccountPage = new AccessAccountPage(driver);
        acccesAccountPage.sendKeysAccessAccountInput("5710");
        acccesAccountPage.clickAccessAccountFirstListResult();
        OrderCommonPage orderCommonPage = new OrderCommonPage(driver);
        orderCommonPage.clickCreateOrden();
        Thread.sleep(5000);
        }
    @Test
    public void clickBackofficeButton() throws InterruptedException {
        loginAs("admin");
        BackOfficePage backofficePage = new BackOfficePage(driver);
        Thread.sleep(3000);
        backofficePage.clickAccessAccountButton();

        AccessAccountPage accessAccountPage = new AccessAccountPage(driver);
        accessAccountPage.sendKeysAccessAccountInput("27858");
        accessAccountPage.clickAccessAccountFirstListResult();

        OrderCommonPage orderCommonPage = new OrderCommonPage(driver);
        orderCommonPage.clickCreateOrden();

        FirsStepCreateOrderPage firsStepCreateOrderPage = new FirsStepCreateOrderPage(driver); 
        firsStepCreateOrderPage.enterZipCode("1653");
        firsStepCreateOrderPage.enterContentValue("10000");
        firsStepCreateOrderPage.enterOrderProducts("10-10148-001");
        firsStepCreateOrderPage.clickFirstProductButton();
        firsStepCreateOrderPage.clickUseProductToBuildPackage();

        // Validación antes del click
        WebElement continueButton = driver.findElement(By.xpath("//button[contains(., 'Continuar')]"));

        System.out.println("Visible: " + continueButton.isDisplayed());
        System.out.println("Habilitado: " + continueButton.isEnabled());

        Assert.assertTrue(continueButton.isDisplayed(), "El botón 'Continuar' no está visible.");
        Assert.assertTrue(continueButton.isEnabled(), "El botón 'Continuar' no está habilitado.");

        // Scroll hasta el botón
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", continueButton);
        Thread.sleep(1000); // Pausa corta después del scroll

        // Intentar click normal
        try {
            continueButton.click();
        } catch (Exception e) {
            System.out.println("Click normal falló, intentando con JavaScript...");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueButton);
        }

        Thread.sleep(5000); // Para ver si se navega al segundo paso
    }



}
