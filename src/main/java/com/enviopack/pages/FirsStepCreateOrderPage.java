package com.enviopack.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FirsStepCreateOrderPage extends BasePage {
    // Modal de cambio de deposito
    private By depositOptionsInModal = By.cssSelector(".form__group .input__content--radio input[type='radio']");
	private By saveInModalBtn = By.xpath("//button[.//span[text()='Guardar']]");
	private By cancelInModalBtn = By.xpath("//button[.//span[text()='Cancelar']]");
    // Botón para el modal de conocer CP o sucursales por CP
    private By consultOfficesOrPostCodesBtn = By.cssSelector("div.sc-bczRLJ.ocmTX a.link-ui__label");
    // Opciones del modal de "Consultar CP"
    private By postalOfficesByPostCodeOption = By.cssSelector("span.sc-evZas.bwDHNw");
    private By findPostCodeOption = By.cssSelector("div.sc-bczRLJ.eYkxgA span.sc-evZas.eqQgiL");
    // Botones de "Sucursales por CP"
    private By postalCodeInConsultModalInput = By.name("codigo_postal");
    // Botones de "Conocer CP"
    private By provinceInModalCbo = By.xpath("//div[contains(@class, 'input__content') and contains(@class, 'input__content--select') and contains(@class, 'input__content--select-big')]");
    private By localityInModalInput = By.xpath("//div[contains(@class, 'input__content') and contains(@class, 'input__content--autosuggest')]//input[@name='localidad']");
    private By streetInputInModal = By.name("calle");
    private By addressNumberInModalInput = By.name("altura");
    // El botón "Consultar" sirve para ambas opciones
    private By consultButtonInModal = By.xpath("//span[normalize-space()='Consultar']");
    // Campos del form
    private By zipCodeInput = By.name("codigoPostalDestino");
    private By contentValueInput = By.name("valorContenido");
    private By switchStockFullpackCheckbox = By.id("switch-stock-fullpack");
    private By modifyOriginWarehouseBtn = By.cssSelector("div[class='sc-bczRLJ lkpwjH'] a[class='link-ui__label']");
    private By orderProductsInput = By.name("productosEnOrden");
    private By personalizedPackageRbtn = By.id("paquetes.0.tipoPaquete_personalizado");
    private By chooseSavedPackageRbtn = By.id("paquetes.0.tipoPaquete_propio");
    private By savedPackageCbo = By.cssSelector(".input__select-wrapper .input__select-display");
    private By heightInput = By.name("paquetes.0.alto");
    private By lengthInput = By.name("paquetes.0.largo");
    private By widthInput = By.name("paquetes.0.ancho");
    private By weightInput = By.name("paquetes.0.peso");
    private By firstDescriptionInput = By.name("paquetes.0.descripcion_primera_linea");
    private By secondDescriptionInput = By.name("paquetes.0.descripcion_segunda_linea");
    private By assignProductsToPackageBtn = By.cssSelector("div[class='sc-bczRLJ fIwBX'] div[class='sc-bczRLJ kDKcRz']");
    private By automaticallyAssignProductsInput = By.name("productosEnPaquete0");
    private By addAnotherPackageBtn = By.cssSelector("body > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(4) > span:nth-child(1) > span:nth-child(1) > a:nth-child(1) > div.sc-bczRLJ.kDKcRz");
    private By deletePackageBtn = By.xpath("//body/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/*[name()='svg'][1]");
    private By exitCreateOrderBtn = By.xpath("//a[contains(@class, 'link-ui__label') and contains(@class, 'link-ui__label--bold') and normalize-space()='Salir']");
    private By continueToStepTwoBtn = By.xpath("//span[normalize-space()='Continuar']");

    public FirsStepCreateOrderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public FirsStepCreateOrderPage load() { 
        super.load("/orden/crear"); 
        return this; 
    }
    
    // Metodo para interectuar con el modal de Cambiar depo
    public FirsStepCreateOrderPage clickSaveInModalButton() {
        click(saveInModalBtn, "Botón Cancelar");
        return this;
    }
    
    public FirsStepCreateOrderPage clickCancelButton() {
        click(cancelInModalBtn, "Botón Cancelar");
        return this;
    }
    
    // Método para seleccionar una opción de radio button por índice para el modal de cambio de deposito
    public FirsStepCreateOrderPage selectDepositOptionsInModalByIndex(int index) {
        List<WebElement> options = driver.findElements(depositOptionsInModal);
        if (index >= 0 && index < options.size()) {
            By optionBy = By.xpath("(//div[@class='form__group']//input[@type='radio'])[" + (index + 1) + "]");
            click(optionBy, "Opción de Depósito en el Índice " + index);
        } else {
            System.out.println("Índice fuera de rango: " + index);
        }
        return this;
    }
    
    // Metodo para interectuar con el modal de cambio consulta de CP
    public FirsStepCreateOrderPage clickConsultOfficesOrPostCodesButton() {
        click(consultOfficesOrPostCodesBtn, "Consult Offices or Post Codes Button");
        return this;
    }

    public FirsStepCreateOrderPage clickPostalOfficesByPostCodeOption() {
        click(postalOfficesByPostCodeOption, "Postal Offices by Post Code Option");
        return this;
    }

    public FirsStepCreateOrderPage clickFindPostCodeOption() {
        click(findPostCodeOption, "Find Post Code Option");
        return this;
    }

    public FirsStepCreateOrderPage enterPostalCodeInConsultModal(String postalCode) {
        sendKeys(postalCodeInConsultModalInput, postalCode, "Postal Code in Consult Modal Input");
        return this;
    }

    public FirsStepCreateOrderPage clickProvinceInModalCbo() {
        click(provinceInModalCbo, "Province in Modal ComboBox");
        return this;
    }

    public FirsStepCreateOrderPage enterLocalityInModal(String locality) {
        sendKeys(localityInModalInput, locality, "Locality in Modal Input");
        return this;
    }

    public FirsStepCreateOrderPage enterStreetInModal(String street) {
        sendKeys(streetInputInModal, street, "Street Input in Modal");
        return this;
    }

    public FirsStepCreateOrderPage enterAddressNumberInModal(String addressNumber) {
        sendKeys(addressNumberInModalInput, addressNumber, "Address Number in Modal Input");
        return this;
    }

    public FirsStepCreateOrderPage clickConsultButtonInModal() {
        click(consultButtonInModal, "Consult Button in Modal");
        return this;
    }
    
    // Métodos para interactuar con los elementos del form
    
    public FirsStepCreateOrderPage enterZipCode(String value) {
        sendKeys(zipCodeInput, value, "Zip Code Input");
        return this;
    }
    
    public FirsStepCreateOrderPage enterContentValue(String value) {
        sendKeys(contentValueInput, value, "Content Value Input");
        return this;
    }

    public FirsStepCreateOrderPage clickSwitchStockFullpackCheckbox() {
        click(switchStockFullpackCheckbox, "Switch Stock Fullpack Checkbox");
        return this;
    }

    public FirsStepCreateOrderPage clickModifyOriginWarehouseButton() {
        click(modifyOriginWarehouseBtn, "Modify Origin Warehouse Button");
        return this;
    }

    public FirsStepCreateOrderPage enterOrderProducts(String product) {
        sendKeys(orderProductsInput, product, "Order Products Input");
        return this;
    }

    public FirsStepCreateOrderPage clickPersonalizedPackageRadioButton() {
        click(personalizedPackageRbtn, "Personalized Package Radio Button");
        return this;
    }

    public FirsStepCreateOrderPage clickChooseSavedPackageRadioButton() {
        click(chooseSavedPackageRbtn, "Choose Saved Package Radio Button");
        return this;
    }

    public FirsStepCreateOrderPage clickSavedPackageComboBox() {
        click(savedPackageCbo, "Saved Package ComboBox");
        return this;
    }

    public FirsStepCreateOrderPage enterHeight(String Height) {
        sendKeys(heightInput, Height, "Height Input");
        return this;
    }

    public FirsStepCreateOrderPage enterLength(String Length) {
        sendKeys(lengthInput, Length, "Length Input");
        return this;
    }

    public FirsStepCreateOrderPage enterWidth(String Width) {
        sendKeys(widthInput, Width, "Width Input");
        return this;
    }

    public FirsStepCreateOrderPage enterWeight(String Weight) {
        sendKeys(weightInput, Weight, "Weight Input");
        return this;
    }

    public FirsStepCreateOrderPage enterFirstDescription(String description) {
        sendKeys(firstDescriptionInput, description, "First Description Input");
        return this;
    }

    public FirsStepCreateOrderPage enterSecondDescription(String description) {
        sendKeys(secondDescriptionInput, description, "Second Description Input");
        return this;
    }

    public FirsStepCreateOrderPage clickAssignProductsToPackageButton() {
        click(assignProductsToPackageBtn, "Assign Products to Package Button");
        return this;
    }
    
    public FirsStepCreateOrderPage enterProductsToAssingAutomatically(String products) {
        sendKeys(automaticallyAssignProductsInput, products, "Automatically Assign Products Input");
        return this;
    }

    public FirsStepCreateOrderPage clickAddAnotherPackageButton() {
        click(addAnotherPackageBtn, "Add Another Package Button");
        return this;
    }
    
    public FirsStepCreateOrderPage clickDeletePackageButton() {
    	click(deletePackageBtn,"Delete package Button");
		return this;
    }

    public FirsStepCreateOrderPage clickExitCreateOrderButton() {
        click(exitCreateOrderBtn, "Exit Create Order Button");
        return this;
    }

    public FirsStepCreateOrderPage clickContinueToStepTwoButton() {
        click(continueToStepTwoBtn, "Continue to Step Two Button");
        return this;
    }
}

