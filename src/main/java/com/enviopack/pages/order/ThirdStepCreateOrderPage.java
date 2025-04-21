package com.enviopack.pages.order;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.enviopack.pages.BasePage;

public class ThirdStepCreateOrderPage extends BasePage {

	// Localizadores de elementos
    // Campos relacionados con la orden
    private By orderNumberInput = By.name("id_externo"); 
    private By firstNameInput = By.name("nombre");       
    private By lastNameInput = By.cssSelector("input[name='apellido'][style='flex: 0 1 0%;']"); 
    private By emailInput = By.cssSelector("input[name='email'][class*='dYJfyG']");             
    private By phoneInput = By.xpath("//input[@name='telefono']");                             

    // Campos relacionados con la dirección
    private By recipientInput = By.cssSelector("input[name='destinatario']");                 
    private By streetInput = By.name("calle");                                               
    private By numberInput = By.cssSelector("input[name='numero']");                          
    private By floorInput = By.cssSelector("input[name='piso'][style*='width: 165px']");   
    private By apartmentInput = By.xpath("//input[@name='depto']");
    private By cityInput = By.xpath("//input[@name='localidad']"); /// Agrego esto para localizar el campo ciudad
    private By provinceSelector = By.xpath("//div[@class='input__select-wrapper']");
    private By provinceNameSelector = By.xpath("//span[normalize-space()='Buenos Aires']");

    // Nuevos elementos agregados
    private By containedBtn = By.cssSelector("#app > div.sc-bczRLJ.hjEakJ > div.sc-bczRLJ.loZxdD > div > div.sc-bczRLJ.efEKrF > div.sc-bczRLJ.gPgnSp > div.sc-bczRLJ.inNZIJ > div > button.button.ripple.button--contained > div > span");
    private By outlinedBtn = By.cssSelector("#app > div.sc-bczRLJ.hjEakJ > div.sc-bczRLJ.loZxdD > div > div.sc-bczRLJ.efEKrF > div.sc-bczRLJ.gPgnSp > div.sc-bczRLJ.inNZIJ > div > button.button.ripple.button--outlined > div > span");
    private By linkElement = By.cssSelector("#app > div.sc-bczRLJ.hjEakJ > div.sc-bczRLJ.loZxdD > div > div.sc-bczRLJ.efEKrF > div.sc-bczRLJ.gPgnSp > div.sc-bczRLJ.inNZIJ > span > span > a");


    // Constructor para inicializar el driver
    public ThirdStepCreateOrderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Método para cargar la página
    public ThirdStepCreateOrderPage load() {
        super.load("/order-page"); // Reemplaza con la URL de tu página
        return this;
    }

	 // Métodos para interactuar con los elementos
	 // Interacciones con campos de la orden
	 public void enterOrderNumber(String orderNumber) {
	     sendKeys(orderNumberInput, orderNumber, "Entering order number/identifier");
	 }
	
	 public void enterFirstName(String firstName) {
	     sendKeys(firstNameInput, firstName, "Entering first name");
	 }
	
	 public void enterLastName(String lastName) {
	     sendKeys(lastNameInput, lastName, "Entering last name");
	 }
	
	 public void enterEmail(String email) {
	     sendKeys(emailInput, email, "Entering email");
	 }
	
	 public void enterPhone(String phone) {
	     sendKeys(phoneInput, phone, "Entering phone number");
	 }
	
	 // Interacciones con campos de la dirección
	 public void enterRecipient(String recipient) {
	     sendKeys(recipientInput, recipient, "Entering recipient");
	 }
	
	 public void enterStreet(String street) {
	     sendKeys(streetInput, street, "Entering street");
	 }
	
	 public void enterNumber(String number) {
	     sendKeys(numberInput, number, "Entering street number");
	 }
	
	 public void enterFloor(String floor) {
	     sendKeys(floorInput, floor, "Entering floor");
	 }
	
	 public void enterApartment(String apartment) {
	     sendKeys(apartmentInput, apartment, "Entering apartment");
	 }
	 //Agrego esto para llamar al localizador de ciudad
	 public void enterCity(String city) {
		 sendKeys(cityInput, city, "Entering city");
	 }
	 
	 public void clickProvinceSelector() {
		 click(provinceSelector, "Click provice selector");
	 }
	 
	 public void clickProvinceName() {
		 click(provinceNameSelector, "Click provice name");
	 }
	
	 // Métodos para interactuar con los nuevos elementos
	 public void clickContainedBtn() {
	     click(containedBtn, "Clicking contained button");
	 }
	
	 public void clickOutlinedBtn() {
	     click(outlinedBtn, "Clicking outlined button");
	 }
	
	 public void clickLinkElement() {
	     click(linkElement, "Clicking link element");
	 }
}

