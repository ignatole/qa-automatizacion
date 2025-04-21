package com.enviopack.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.enviopack.common.BaseTest;
import com.enviopack.pages.AccessAccountPage;
import com.enviopack.pages.BackOfficePage;
import com.enviopack.pages.LoginPage;
import com.enviopack.pages.order.FirsStepCreateOrderPage;
import com.enviopack.pages.order.OrderCommonPage;
import com.enviopack.pages.order.SecondStepCreateOrderPage;
import com.enviopack.pages.order.ThirdStepCreateOrderPage;

public class LoginPracticeTest extends BaseTest{
	@Test
	public void login() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail("carla.r@enviopack.com");
		loginPage.enterPassword("noAiaO7l");
		loginPage.clickLogin();
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
		Thread.sleep(3000);
		firsStepCreateOrderPage.clickContinueToStepTwoButton();
		Thread.sleep(3000);
		SecondStepCreateOrderPage secondStepCreateOrderPage =new SecondStepCreateOrderPage(driver);
		secondStepCreateOrderPage.quotationTypeTbl();
		Thread.sleep(3000);
		secondStepCreateOrderPage.continueBtn();
		Thread.sleep(3000);
		ThirdStepCreateOrderPage thirdStepCreateOrderPage =new ThirdStepCreateOrderPage(driver);
		int numeroAleatorio = (int)(Math.random() * 900) + 100;
		thirdStepCreateOrderPage.enterOrderNumber("testHerni" + "-" + numeroAleatorio);
		thirdStepCreateOrderPage.enterFirstName("Hernan");
		thirdStepCreateOrderPage.enterLastName("Exner");
		thirdStepCreateOrderPage.enterEmail("hernan.e@enviopack.com");
		thirdStepCreateOrderPage.enterPhone("11562623636");
		thirdStepCreateOrderPage.enterStreet("Monaco");
		thirdStepCreateOrderPage.enterNumber("3579");
		thirdStepCreateOrderPage.enterFloor("2");
		thirdStepCreateOrderPage.enterApartment("26");
		thirdStepCreateOrderPage.enterCity("Pilar");
		thirdStepCreateOrderPage.clickProvinceSelector();
		thirdStepCreateOrderPage.clickProvinceName();
		Thread.sleep(3000);
		///para testear
	}
}
