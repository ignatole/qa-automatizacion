package com.enviopack.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    private By emailInput = By.name("email");
    private By passwordInput = By.name("password");
    private By loginBtn = By.xpath("//div[@class='button__wrapper button__wrapper--contained button__wrapper--contained-primary']");

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    public LoginPage load() { 
    	super.load("/login"); 
    	return this; 
    	}
    
    public LoginPage enterEmail(String email) {
        sendKeys(emailInput, email, "Email Input");
        return this;
    }

    public LoginPage enterPassword(String password) {
        sendKeys(passwordInput, password, "Password Input");
        return this;
    }

    public LoginPage clickLogin() {
        click(loginBtn, "Login Button");
        return this;
    }    
}
