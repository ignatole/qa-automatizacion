package com.enviopack.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AccessAccountPage extends BasePage {
	
	private By accessAccounTitle = By.cssSelector(".styled__Title-sc-cp812e-0.fCPrqG");
	private By accessAccountInput = By.id("empresa");
	private By accessAccountBackBtn = By.cssSelector(".link-ui__label");
	private By accessAccountFirstListResult = By.id("react-autowhatever-1--item-0");
	
	
    public AccessAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    public AccessAccountPage load() {
        super.load("/ingresar-como");
        return this;
    }
    
  

    public void sendKeysAccessAccountInput(String account) {
    	sendKeys(accessAccountInput,account,"Send Account ID/Name");
    }
    
    public void clickAccessAccountBackBtn() {
    	click(accessAccountBackBtn, "Click Access Account Button");
    }
    
    public void clickAccessAccountFirstListResult() {
    	click(accessAccountFirstListResult, "Click Access Account First Line Result");
    }
}

