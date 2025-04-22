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
    private By cityInput = By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div/div[2]/div[1]/div[1]/div/div[4]/div[5]/div/input"); // se agrego el localizador ciudad
    private By provinceInput = By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div/div[2]/div[1]/div[1]/div/div[4]/div[6]/div/div/div"); // se agrega localizador provincia
    private By additionalReferenceInput = By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div/div[2]/div[1]/div[1]/div/div[5]/div/input"); // se agrega localizador referencia adicional
    
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
	 
	 public void enterCity (String city) {
		 sendKeys(cityInput, city, "Entering city");
	 }
	 
	 public void enterProvince (String province) {
		 sendKeys(provinceInput, province, "Entering city");
	 }
	 
	 public void enterAdditionalReference (String additionalReference) {
		 sendKeys(additionalReferenceInput, additionalReference, "Entering additional Reference");
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

