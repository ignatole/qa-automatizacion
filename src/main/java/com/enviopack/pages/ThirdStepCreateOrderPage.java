package com.enviopack.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ThirdStepCreateOrderPage extends BasePage {

    // Localizadores de elementos
    // Campos relacionados con la orden
    private By orderNumberField = By.name("id_externo"); // NÚMERO/IDENTIFICADOR DE LA ORDEN
    private By firstNameField = By.name("nombre");       // NOMBRE
    private By lastNameField = By.cssSelector("input[name='apellido'][style='flex: 0 1 0%;']"); // APELLIDO (con flex style)
    private By emailField = By.cssSelector("input[name='email'][class*='dYJfyG']");             // EMAIL
    private By phoneField = By.xpath("//input[@name='telefono']");                             // TELÉFONO

    // Campos relacionados con la dirección
    private By recipientField = By.cssSelector("input[name='destinatario']");                 // DESTINATARIO
    private By streetField = By.name("calle");                                               // CALLE
    private By numberField = By.cssSelector("input[name='numero']");                          // NÚMERO
    private By floorField = By.cssSelector("input[name='piso'][style*='width: 165px']");     // PISO (con ancho específico)
    private By apartmentField = By.xpath("//input[@name='depto']");                          // DEPTO

    // Nuevos elementos agregados
    private By containedButton = By.cssSelector("#app > div.sc-bczRLJ.hjEakJ > div.sc-bczRLJ.loZxdD > div > div.sc-bczRLJ.efEKrF > div.sc-bczRLJ.gPgnSp > div.sc-bczRLJ.inNZIJ > div > button.button.ripple.button--contained > div > span");
    private By outlinedButton = By.cssSelector("#app > div.sc-bczRLJ.hjEakJ > div.sc-bczRLJ.loZxdD > div > div.sc-bczRLJ.efEKrF > div.sc-bczRLJ.gPgnSp > div.sc-bczRLJ.inNZIJ > div > button.button.ripple.button--outlined > div > span");
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
        sendKeys(orderNumberField, orderNumber, "Entering order number/identifier");
    }

    public void enterFirstName(String firstName) {
        sendKeys(firstNameField, firstName, "Entering first name");
    }

    public void enterLastName(String lastName) {
        sendKeys(lastNameField, lastName, "Entering last name");
    }

    public void enterEmail(String email) {
        sendKeys(emailField, email, "Entering email");
    }

    public void enterPhone(String phone) {
        sendKeys(phoneField, phone, "Entering phone number");
    }

    // Interacciones con campos de la dirección
    public void enterRecipient(String recipient) {
        sendKeys(recipientField, recipient, "Entering recipient");
    }

    public void enterStreet(String street) {
        sendKeys(streetField, street, "Entering street");
    }

    public void enterNumber(String number) {
        sendKeys(numberField, number, "Entering street number");
    }

    public void enterFloor(String floor) {
        sendKeys(floorField, floor, "Entering floor");
    }

    public void enterApartment(String apartment) {
        sendKeys(apartmentField, apartment, "Entering apartment");
    }

    // Métodos para interactuar con los nuevos elementos
    public void clickContainedButton() {
        click(containedButton, "Clicking contained button");
    }

    public void clickOutlinedButton() {
        click(outlinedButton, "Clicking outlined button");
    }

    public void clickLinkElement() {
        click(linkElement, "Clicking link element");
    }
}

