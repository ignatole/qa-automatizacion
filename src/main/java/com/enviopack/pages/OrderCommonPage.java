package com.enviopack.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.enviopack.utils.TableReader;
import java.util.ArrayList;
import java.util.List;

public class OrderCommonPage extends BasePage {
	// Elementos comunes
    private By ordersSidenavItem = By.xpath("//div[contains(@class, 'MuiButtonBase-root') and contains(@class, 'MuiListItem-root') and contains(@class, 'sidenav__first') and .//span[contains(text(),'Órdenes')]]");
    private By createOrdenBtn = By.cssSelector(".button-select__wrapper--contained-primary");
    private By createOrderDropdownBtn = By.cssSelector("button[class='button-select__with-caret']");
    private By searchBarBtn = By.name("q");
    private By moreActionsBtn = By.xpath("//span[@class='button-select__name' and text()='Más acciones']");
    // Elementos de Herni
	private By toProcessReturnBtn = By.cssSelector("div[class='button-select__options-wrapper'] div:nth-child(1) span:nth-child(1)");
	private By toProcessUploadCsvBtn = By.cssSelector("div[class='layout__main-header'] div[class='sc-bczRLJ lkpwjH'] div:nth-child(2) span:nth-child(1)");
	private By toProcessTableSearchModalTitle = By.cssSelector(".sc-evZas.iOWtmw");
	private By toProcessTableSearchBySelector = By.cssSelector(".input__content.input__content--hover.input__content--select");
	private By toProcessTableSearchByOrder = By.cssSelector(".input__select-option.input__select-option--selected");
	private By toProcessTableSearchByCustomer = By.cssSelector("div[class='input__select-option']");
	private By toProcessTableSearchInput = By.cssSelector("input[placeholder='Buscar por número de orden']");
	private By toProcessTableSearchFindBtn = By.cssSelector(".sc-bczRLJ.cvcONn");
    private By filterBtn = By.xpath("//span[text()='Filtros']");
    // Localizador de las cabeceras de las columnas
    private By headers = By.cssSelector(".table__head .table__cell");
    private String rowXPath = "//body/div[@id='app']/div[@class='sc-bczRLJ fPqkYZ']/div[@class='sc-bczRLJ bFhEtX']/div[@class='sc-bczRLJ fIvMuv']/div[@class='layout__main-content']/div[@role='table']/div[@class='styled__TableBody-sc-pv1bhz-1 eouKRU']/div";
    private TableReader tableReader;

    public OrderCommonPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Métodos comunes para botones y navegación
    public void clickOrdersSidenavItem() {
        click(ordersSidenavItem, "Order Sidenav Item");
    }

    public void clickCreateOrden() {
        click(createOrdenBtn, "Create Orden Button");
    }

    public void clickCreateOrderDropdown() {
        click(createOrderDropdownBtn, "Create Order Dropdown Button");
    }

    public void clickSearchBar() {
        click(searchBarBtn, "Search Bar");
    }

    public void clickMoreActions() {
        click(moreActionsBtn, "More Actions Button");
    }

    public void clickFilter() {
        click(filterBtn, "Filter Button");
    }
    // Metodos de Herni trasladados
    public void clickToProcessReturnBtn() {
    	click(toProcessReturnBtn, "Click Return Button");
    }
    
    public void clicktoProcessUploadCsvBtn() {
    	click(toProcessUploadCsvBtn, "Click Upload CSV Button");
    }
    
    public void clickToProcessTableSearchBySelector() {
    	click(toProcessTableSearchBySelector, "Click Table Search By Selector");
    }
    
    public void clickToProcessTableSearchByOrder() {
    	click(toProcessTableSearchByOrder, "Click Table Search By Order");
    }
    
    public void clickToProcessTableSearchByCustomer() {
    	click(toProcessTableSearchByCustomer, "Click Table Search By Customer");
    }
    
    public void sendKeystoProcessTableSearchInput(String customerOrOrder) {
    	sendKeys(toProcessTableSearchInput,customerOrOrder,"Send Order/Customer");
    }
    
    public void clickToProcessTableSearchFindBtn() {
    	click(toProcessTableSearchFindBtn, "Click Find Button");
    }

    public List<List<String>> getFirstTenRows() {
        return tableReader.readTableRows(driver, rowXPath, 10);
    }
}
