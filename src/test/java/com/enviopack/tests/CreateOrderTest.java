package com.enviopack.tests;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import com.enviopack.common.BaseTest;
import com.enviopack.pages.AccessAccountPage;
import com.enviopack.pages.BackOfficePage;
import com.enviopack.pages.LoginPage;
import com.enviopack.pages.order.FirsStepCreateOrderPage;
import com.enviopack.pages.order.OrderCommonPage;
import com.enviopack.pages.order.SecondStepCreateOrderPage;
import com.enviopack.pages.order.ThirdStepCreateOrderPage;

public class CreateOrderTest extends BaseTest {

	@Test
	public void login() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail("carla.r@enviopack.com");
		loginPage.enterPassword("noAiaO7l");
		loginPage.clickLogin();
	}

	@Test
	@Ignore
	public void createOrden() throws InterruptedException {
		loginAs("admin");

		BackOfficePage backOfficePage = new BackOfficePage(driver);
		Thread.sleep(3000);
		backOfficePage.clickAccessAccountButton();
		AccessAccountPage accessAccountPage = new AccessAccountPage(driver);
		accessAccountPage.sendKeysAccessAccountInput("24740");
		accessAccountPage.clickAccessAccountFirstListResult();
		OrderCommonPage orderCommonPage = new OrderCommonPage(driver);
		orderCommonPage.clickCreateOrden();

		// Paso 1

		FirsStepCreateOrderPage firsStepCreateOrderPage = new FirsStepCreateOrderPage(driver);
		firsStepCreateOrderPage.enterZipCode("1235");
		firsStepCreateOrderPage.enterContentValue("20000");
		firsStepCreateOrderPage.enterOrderProducts("1234");
		firsStepCreateOrderPage.enterHeight("10");
		firsStepCreateOrderPage.enterLength("10");
		firsStepCreateOrderPage.enterWidth("20");
		firsStepCreateOrderPage.enterWeight("15");
		firsStepCreateOrderPage.enterFirstDescription("Esto es una prueba QA automation");
		System.out.println("Espera de carga de datos -------------------- ");
		Thread.sleep(3000);
		firsStepCreateOrderPage.clickContinueToStepTwoButton();

		// Paso 2

		System.out.println("Paso dos -------------------- ");
		Thread.sleep(3000);
		SecondStepCreateOrderPage secondStepCreateOrderPage = new SecondStepCreateOrderPage(driver);
		Thread.sleep(3000);
		// secondStepCreateOrderPage.clickdeliveryBtn();
		secondStepCreateOrderPage.clickQuotationTypeTbl();
		Thread.sleep(3000);
		secondStepCreateOrderPage.clickcontinueBtn();

		// Paso 3

		ThirdStepCreateOrderPage thirdStepCreateOrderPage = new ThirdStepCreateOrderPage(driver);
		thirdStepCreateOrderPage.enterOrderNumber("QA-Automation-001");
		thirdStepCreateOrderPage.enterFirstName("Maria");
		thirdStepCreateOrderPage.enterLastName("Perez");
		thirdStepCreateOrderPage.enterEmail("prueba@prueba.com");
		thirdStepCreateOrderPage.enterPhone("1111111111");
		thirdStepCreateOrderPage.enterRecipient("Maria Perez");
		thirdStepCreateOrderPage.enterStreet("Av la plata");
		thirdStepCreateOrderPage.enterNumber("688");
		thirdStepCreateOrderPage.enterFloor("8");
		thirdStepCreateOrderPage.enterApartment("H");
		thirdStepCreateOrderPage.enterCity("Capital Federal");
		thirdStepCreateOrderPage.clickProvinceSelector();
		thirdStepCreateOrderPage.clickProvinceName();
		Thread.sleep(3000);
		thirdStepCreateOrderPage.clickContainedBtn();

	}

	public void accessIntoAccount() throws InterruptedException {
		loginAs("admin");

		BackOfficePage backOfficePage = new BackOfficePage(driver);
		Thread.sleep(3000);
		backOfficePage.clickAccessAccountButton();
		AccessAccountPage accessAccountPage = new AccessAccountPage(driver);
		accessAccountPage.sendKeysAccessAccountInput("24740");
		accessAccountPage.clickAccessAccountFirstListResult();
		OrderCommonPage orderCommonPage = new OrderCommonPage(driver);
		orderCommonPage.clickCreateOrden();

	}

	public void firsStep() throws InterruptedException {
		FirsStepCreateOrderPage firsStepCreateOrderPage = new FirsStepCreateOrderPage(driver);
		firsStepCreateOrderPage.enterZipCode("1235");
		firsStepCreateOrderPage.enterContentValue("20000");
		firsStepCreateOrderPage.enterOrderProducts("1234");
		firsStepCreateOrderPage.enterHeight("10");
		firsStepCreateOrderPage.enterLength("10");
		firsStepCreateOrderPage.enterWidth("20");
		firsStepCreateOrderPage.enterWeight("15");
		firsStepCreateOrderPage.enterFirstDescription("Esto es una prueba QA automation");
		System.out.println("Espera de carga de datos -------------------- ");
		Thread.sleep(3000);
		firsStepCreateOrderPage.clickContinueToStepTwoButton();

	}

	public void secondStep() throws InterruptedException {
		System.out.println("Paso dos -------------------- ");
		Thread.sleep(3000);
		SecondStepCreateOrderPage secondStepCreateOrderPage = new SecondStepCreateOrderPage(driver);
		Thread.sleep(3000);
		secondStepCreateOrderPage.clickQuotationTypeTbl();
		Thread.sleep(3000);
		secondStepCreateOrderPage.clickcontinueBtn();

	}

	public void thirdStep() throws InterruptedException {
		ThirdStepCreateOrderPage thirdStepCreateOrderPage = new ThirdStepCreateOrderPage(driver);
		thirdStepCreateOrderPage.enterOrderNumber("QA-Automation-001");
		thirdStepCreateOrderPage.enterFirstName("Maria");
		thirdStepCreateOrderPage.enterLastName("Perez");
		thirdStepCreateOrderPage.enterEmail("prueba@prueba.com");
		thirdStepCreateOrderPage.enterPhone("1111111111");
		thirdStepCreateOrderPage.enterRecipient("Maria Perez");
		thirdStepCreateOrderPage.enterStreet("Av la plata");
		thirdStepCreateOrderPage.enterNumber("688");
		thirdStepCreateOrderPage.enterFloor("8");
		thirdStepCreateOrderPage.enterApartment("H");
		thirdStepCreateOrderPage.enterCity("Capital Federal");
		thirdStepCreateOrderPage.clickProvinceSelector();
		thirdStepCreateOrderPage.clickProvinceName();
		thirdStepCreateOrderPage.clickContainedBtn();
	}

	@Test
	public void createOrder() throws InterruptedException {
		accessIntoAccount();
		firsStep();
		secondStep();
		thirdStep();
	}
}