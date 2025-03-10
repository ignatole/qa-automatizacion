package com.enviopack.pages.order;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.enviopack.pages.BasePage;
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
	private By returnBtn = By.cssSelector("div[class='button-select__options-wrapper'] div:nth-child(1) span:nth-child(1)");
	private By uploadCsvBtn = By.cssSelector("div[class='layout__main-header'] div[class='sc-bczRLJ lkpwjH'] div:nth-child(2) span:nth-child(1)");
	private By tableSearchModalTitle = By.cssSelector(".sc-evZas.iOWtmw");
	private By tableSearchBySelector = By.cssSelector(".input__content.input__content--hover.input__content--select");
	private By tableSearchByOrder = By.cssSelector(".input__select-option.input__select-option--selected");
	private By tableSearchByCustomer = By.cssSelector("div[class='input__select-option']");
	private By tableSearchInput = By.cssSelector("input[placeholder='Buscar por número de orden']");
	private By tableSearchFindBtn = By.cssSelector(".sc-bczRLJ.cvcONn");
    private By filterBtn = By.xpath("//span[text()='Filtros']");
    // Localizador de las cabeceras de las columnas
    private String headerRowXPath = "//div[@class='table__head']//div[contains(@class, 'table-row-selector')]";
    private String rowXPath = "//body/div[@id='app']/div[@class='sc-bczRLJ fPqkYZ']/div[@class='sc-bczRLJ bFhEtX']/div[@class='sc-bczRLJ fIvMuv']/div[@class='layout__main-content']/div[@role='table']/div[@class='styled__TableBody-sc-pv1bhz-1 eouKRU']/div";
    private TableReader tableReader;

    public OrderCommonPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.tableReader = new TableReader();
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

    // Métodos de Herni actualizados con los nuevos localizadores
    public void clickReturnBtn() {
        click(returnBtn, "Click Return Button");
    }

    public void clickUploadCsvBtn() {
        click(uploadCsvBtn, "Click Upload CSV Button");
    }

    public void clickTableSearchBySelector() {
        click(tableSearchBySelector, "Click Table Search By Selector");
    }

    public void clickTableSearchByOrder() {
        click(tableSearchByOrder, "Click Table Search By Order");
    }

    public void clickTableSearchByCustomer() {
        click(tableSearchByCustomer, "Click Table Search By Customer");
    }

    public void sendKeysToTableSearchInput(String customerOrOrder) {
        sendKeys(tableSearchInput, customerOrOrder, "Send Order/Customer");
    }

    public void clickTableSearchFindBtn() {
        click(tableSearchFindBtn, "Click Find Button");
    }

    public List<List<String>> getFirstTenRows() {
        return tableReader.readTableRows(driver, rowXPath, 10);
    }

    public List<String> getTableHeaders() {
        TableReader tableReader = new TableReader();
        return tableReader.readTableHeaders(driver, headerRowXPath);
    }
}
