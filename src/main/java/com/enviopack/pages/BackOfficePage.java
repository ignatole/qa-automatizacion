package com.enviopack.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BackOfficePage extends BasePage {

    private By accessAccountBtn = By.xpath("//span[normalize-space()='Acceder a una cuenta']");
    private By dataAccountBtn = By.cssSelector("div.layout div.layout__content div.sc-bczRLJ.eQTuku div.sc-bczRLJ.XZEUS div.sc-bczRLJ.hcDqkt:nth-child(2) > div.styled__BackofficeCard-sc-cp812e-3.GNatm:nth-child(2)");
    private By usersManagmentBtn = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1)");
    private By creditRechargeBtn = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(11) > div:nth-child(1)");
    private By shipmentsBtn = By.cssSelector("div.layout div.layout__content div.sc-bczRLJ.eQTuku div.sc-bczRLJ.XZEUS div.sc-bczRLJ.hcDqkt:nth-child(2) > div.styled__BackofficeCard-sc-cp812e-3.GNatm:nth-child(3)");
    private By claimsBtn = By.cssSelector("div[id='app'] div:nth-child(5)");
    private By contactCenterBtn = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(6) > div:nth-child(1)");
    private By pickupBtn = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(7) > div:nth-child(1)");
    private By fullpackBtn = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(8) > div:nth-child(1)");
    private By chargesAndFeesBtn = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(9) > div:nth-child(1)");
    private By managementBtn = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(10) > div:nth-child(1)");
    private By platformsBtn = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(12) > div:nth-child(1)");
    private By b2bBtn = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(13) > div:nth-child(1)");
    
    
    // Este método inicializa el driver en la página.
    public BackOfficePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    // Este método carga la URL de la página
    public BackOfficePage load() {
        super.load("/backoffice");
        return this;
    }
    
    // Estos métodos realizan la acción de click sobre los elementos
    public void clickAccessAccountButton() {
        click(accessAccountBtn, "Click Access Account Button");
    }
    
    public void  clickDataAccountbtn(){
    	click(dataAccountBtn,"Click Data Account Button");
    }
    
    public void clickManagmentUsers() {
    	click(usersManagmentBtn,"Click Users managment");
    }
    
    public void clickAccessCreditRechargeButton() {
    	click(creditRechargeBtn, "Click Recharge Credit Button");
    }
    
    public void clickAccessShipmentsButton()  {
        click(shipmentsBtn, "Click Shipments Button");    
    }
    
    public void clickClaimsBtn() {
    	click(claimsBtn, "Click Claims Button");
    }
    
    public void clickcontactCenterBtn() {
    	click(contactCenterBtn, "Click Contact Center Button");
    }
    
    public void pickupBtn() {
    	click(pickupBtn, "Click Pickup Button");
    }
    
    public void fullpackBtn() {
    	click(fullpackBtn, "Click Fullpack Button");
    }
    
    public void chargesAndFeesBtn() {
    	click(chargesAndFeesBtn, "Click Charges and Fees Button");
    }
    
    public void administrationBtn() {
    	click(managementBtn, "Click Management Button");
    }
    
    public void platformsBtn() {
    	click(platformsBtn, "Click Platforms Button");
    }
    
    public void b2bBtn() {
    	click(b2bBtn, "Click B2b Button");
    }
}
