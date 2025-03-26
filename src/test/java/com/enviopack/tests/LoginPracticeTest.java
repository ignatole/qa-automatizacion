package com.enviopack.tests;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.enviopack.annotations.TestCaseId;
import com.enviopack.common.BaseTest;
import com.enviopack.pages.BackOfficePage;
import com.enviopack.pages.order.OrderCommonPage;
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
}