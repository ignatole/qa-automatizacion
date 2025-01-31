package com.enviopack.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SecondStepCreateOrderPage extends BasePage{

	private By step2Ttl = By.cssSelector("div.sc-bczRLJ.hjEakJ:nth-child(3) div.sc-bczRLJ.loZxdD:nth-child(2) div.sc-bczRLJ.aJYXL div.sc-bczRLJ.EcUGL.sc-gsnTZi.ijyXhc:nth-child(1) div.sc-bczRLJ.hdFuNh:nth-child(3) > div.sc-bczRLJ.jFlnUV");
	private By ensureShipmentCheckbox = By.id("seguro-check");
	private By moreInformationLinkBtn = By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/a");
	private By fromMyWarehousePickupBtnSwitch = By.cssSelector("div.sc-bczRLJ.hjEakJ:nth-child(3) div.sc-bczRLJ.loZxdD:nth-child(2) div.sc-bczRLJ.aJYXL div.sc-bczRLJ.efEKrF:nth-child(2) div.sc-bczRLJ.efEKrF:nth-child(1) div.sc-bczRLJ.iWABbI div.sc-bczRLJ.beyQxW.sc-gsnTZi.ijyXhc:nth-child(1) div.sc-bczRLJ.fwWgpS:nth-child(1) > div.sc-bczRLJ.kAizsf");
	private By fromBranchBtnSwitch = By.cssSelector("div.sc-bczRLJ.hjEakJ:nth-child(3) div.sc-bczRLJ.loZxdD:nth-child(2) div.sc-bczRLJ.aJYXL div.sc-bczRLJ.efEKrF:nth-child(2) div.sc-bczRLJ.efEKrF:nth-child(1) div.sc-bczRLJ.iWABbI div.sc-bczRLJ.beyQxW.sc-gsnTZi.ijyXhc:nth-child(1) div.sc-bczRLJ.fwWgpS:nth-child(2) > div.sc-bczRLJ.kAizsf");
	private By toDeliveryBtnSwitch = By.cssSelector("div.sc-bczRLJ.hjEakJ:nth-child(3) div.sc-bczRLJ.loZxdD:nth-child(2) div.sc-bczRLJ.aJYXL div.sc-bczRLJ.efEKrF:nth-child(2) div.sc-bczRLJ.efEKrF:nth-child(1) div.sc-bczRLJ.iWABbI div.sc-bczRLJ.beyQxW.sc-gsnTZi.ijyXhc:nth-child(1) div.sc-bczRLJ.fwWgpS:nth-child(3) > div.sc-bczRLJ.kAizsf");
	private By toBranchBtnSwitch = By.cssSelector("div.sc-bczRLJ.hjEakJ:nth-child(3) div.sc-bczRLJ.loZxdD:nth-child(2) div.sc-bczRLJ.aJYXL div.sc-bczRLJ.efEKrF:nth-child(2) div.sc-bczRLJ.efEKrF:nth-child(1) div.sc-bczRLJ.iWABbI div.sc-bczRLJ.beyQxW.sc-gsnTZi.ijyXhc:nth-child(1) div.sc-bczRLJ.fwWgpS:nth-child(4) > div.sc-bczRLJ.kAizsf");
	private By quotationTypeTbl = By.xpath("//*[contains(@id, 'cotizacion-')]");
	private By continueBtn = By.cssSelector("div.sc-bczRLJ.hjEakJ:nth-child(3) div.sc-bczRLJ.loZxdD:nth-child(2) div.sc-bczRLJ.aJYXL div.sc-bczRLJ.efEKrF:nth-child(2) div.sc-bczRLJ.efEKrF:nth-child(1) div.sc-bczRLJ.iWABbI div.sc-bczRLJ.inNZIJ:nth-child(3) div.sc-bczRLJ.kodNjj button.button.ripple.button--contained div.button__wrapper.button__wrapper--contained.button__wrapper--contained-primary > span.button__name");
	private By backBtn = By.cssSelector("div.sc-bczRLJ.hjEakJ:nth-child(3) div.sc-bczRLJ.loZxdD:nth-child(2) div.sc-bczRLJ.aJYXL div.sc-bczRLJ.efEKrF:nth-child(2) div.sc-bczRLJ.efEKrF:nth-child(1) div.sc-bczRLJ.iWABbI div.sc-bczRLJ.inNZIJ:nth-child(3) span.link-ui span.link-ui__wrapper > a.link-ui__label.link-ui__label--bold");
	private By modifyBtn = By.cssSelector("div.sc-bczRLJ.hjEakJ:nth-child(3) div.sc-bczRLJ.loZxdD:nth-child(2) div.sc-bczRLJ.aJYXL div.sc-bczRLJ.efEKrF:nth-child(2) div.sc-bczRLJ.lkpwjH.sc-gsnTZi.kTHsrv:nth-child(3) div.sc-bczRLJ.itijgB.sc-jTYCaT.fCEkdV div.sc-bczRLJ.drblFL:nth-child(1) > span.sc-evZas.kmKcKl.LinkButton__SLinkButton-sc-1dzp66t-0.cvsCJw:nth-child(2)");
	private By viewLocationLinkBtn = By.cssSelector("div.sc-bczRLJ.hjEakJ:nth-child(3) div.sc-bczRLJ.loZxdD:nth-child(2) div.sc-bczRLJ.aJYXL div.sc-bczRLJ.efEKrF:nth-child(2) div.sc-bczRLJ.efEKrF:nth-child(1) div.sc-bczRLJ.iWABbI div.sc-bczRLJ.dMlKGt.sc-gsnTZi.bDDOzU:nth-child(2) div.sc-bczRLJ.lkpwjH.sc-gsnTZi.kTHsrv div.sc-bczRLJ.hzHcQF.sc-jTYCaT.fCEkdV.CotizacionItem__CotizacionWrapper-sc-1qm0bf7-0.gBwLQW:nth-child(1) div.sc-bczRLJ.dfYsda:nth-child(2) > span.sc-evZas.kmKcKl.LinkButton__SLinkButton-sc-1dzp66t-0.cvsCJw:nth-child(2)");
	private By cleanFiltersLinkBtn = By.cssSelector("div.sc-bczRLJ.hjEakJ:nth-child(3) div.sc-bczRLJ.loZxdD:nth-child(2) div.sc-bczRLJ.aJYXL div.sc-bczRLJ.efEKrF:nth-child(2) div.sc-bczRLJ.efEKrF:nth-child(1) div.sc-bczRLJ.iWABbI div.sc-bczRLJ.dMlKGt.sc-gsnTZi.bDDOzU:nth-child(2) div.sc-bczRLJ.kIEjpf:nth-child(1) div.sc-bczRLJ.bcikhl:nth-child(2) > span.sc-evZas.kmKcKl.LinkButton__SLinkButton-sc-1dzp66t-0.cvsCJw:nth-child(3)");
	private By withoutQuoteTbl = By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div/div[2]/div[1]/div/div[3]/div[2]/div[2]");
	
	 
	// Este método inicializa el driver en la página
	public SecondStepCreateOrderPage(WebDriver driver) {
	        super(driver);
	        PageFactory.initElements(driver, this);
	    }
	
	// Este método carga la URL de la página
	public SecondStepCreateOrderPage load() {
	        super.load("/Orders");
	        return this;
	    }
	
	// Estos métodos realizan la acción de click sobre los elementos   
	
	public void clickstep2() {
		 click(step2Ttl, "title verification step 2");
	 	}
	 
	// Modal quiero asegurar mi envío
	
	public void ensureShipmentCheckbox () {
		click(ensureShipmentCheckbox, "Click Checkbox Ensure Shipment");
	}
	
	public void moreInformationLinkBtn () { 
		click(moreInformationLinkBtn, "Click LinkButton More Information");
	}
	 
	 public void clickfromMyWarehousePickupBtnSwitch() {
		 click(fromMyWarehousePickupBtnSwitch, "click Button Switch from My Warehouse Pickup");
	 	}
	   
	 public void fromBranchBtn() {
		 click(fromBranchBtnSwitch, "Click Button Switch From Branch");
		}
	    
	 public void deliveryBtn() {
		 click(toDeliveryBtnSwitch, "Click Button Switch To Delivery ");
	 	}
	 
	 public void branchBtn() {
		 click(toBranchBtnSwitch, "Click utton Switch To Branch");
	 	}
	 
	 // Elemento capturado de la tabla padre de las cotizaciones 
	 public void quotationTypeTbl() {
		 click(quotationTypeTbl, "Click Quotation Type table");
	 	}
	 
	 public void continueBtn() {
		 click(continueBtn, "CLick Continue Button");
	 	}
	 
	 public void backBtn() {
		 click(backBtn, "Click Back Button");
	 	}
	 
	 public void modifyBtn () {
		 click(modifyBtn, "Click Modify Button");
	 	}
		 
	 public void viewLocationBtn () {
		 click(viewLocationLinkBtn, "Click View Location Button");
	 	}
	 
	 // Este elemento solo se ve cuando no hay cotizaciones disponibles.
	 public void cleanFiltersBtn () {
		 click(cleanFiltersLinkBtn, "Click Clean Filters Button");
	 	}
	 
	 // Modal Entrega a sucursal: No hay cotizaciones disponibles con el código postal ingresado se capturo el elemento de la tabla completa, luego para el caso de prueba se tiene que enlistas en CP a tomar 
	 public void withoutQuoteTbl () {
		 click(withoutQuoteTbl, "Click select zip code");
	 }
}
