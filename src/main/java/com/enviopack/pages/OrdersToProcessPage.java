package com.enviopack.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OrdersToProcessPage extends BasePage {
	
	private By toProcessTitle = By.cssSelector(".sc-evZas.hrDTLF");
			
    public OrdersToProcessPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    public OrdersToProcessPage load() {
        super.load("/por-procesar?orden_columna=fecha_alta&orden_sentido=DESC&pagina=1&ppp=50");
        return this;
    }
}
