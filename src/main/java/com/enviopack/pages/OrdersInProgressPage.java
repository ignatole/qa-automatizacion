package com.enviopack.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OrdersInProgressPage extends OrderCommonPage {
    
    private By ordersInProgressSidenavBtn = By.cssSelector("a.sidenav__sub-item[href*='/ordenes/en-proceso'] div.sidenav__second.active");
    private By orderStuckInProcessMessageLbl = By.cssSelector("div.sc-bczRLJ.cDPcaG > div.sc-bczRLJ.elnhuc > svg + div.sc-bczRLJ.dkqXed");

    public OrdersInProgressPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOrdersInProgressSidenavBtn() {
        click(ordersInProgressSidenavBtn, "Orders In Progress Sidenav Button");
    }

    public String getOrderStuckInProcessMessage() {
        return getText(orderStuckInProcessMessageLbl, "Order Stuck In Process Message");
    }

}
