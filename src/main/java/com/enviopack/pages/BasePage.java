package com.enviopack.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;
import com.enviopack.utils.ExplicitWaitUtil;
import com.enviopack.config.ConfigLoader;
import com.enviopack.enums.WaitStrategy;
import java.time.Duration;

public class BasePage {
	
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForOverlaysToDisappear(By overlay) {
        List<WebElement> overlays = driver.findElements(overlay);
        if (overlays.size() > 0) {
            wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
        }
    }
    
    public void load(String endPoint) { 
    	ConfigLoader configLoader = ConfigLoader.getInstance(); driver.get(configLoader.getBaseUrl() + endPoint);
    }
    
    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    
    protected void click(By by, String elementName) {
        ExplicitWaitUtil.performExplicitWait(WaitStrategy.CLICKABLE, by).click();
    }

    protected void sendKeys(By by, String value, String elementName) {
        ExplicitWaitUtil.performExplicitWait(WaitStrategy.VISIBLE, by).sendKeys(value);
    }

    protected void clear(By by, String elementName) {
        ExplicitWaitUtil.performExplicitWait(WaitStrategy.VISIBLE, by).clear();
    }

    protected void clearAndSendKeys(By by, String value, String elementName) {
        WebElement element = ExplicitWaitUtil.performExplicitWait(WaitStrategy.VISIBLE, by);
        element.clear();
        element.sendKeys(value);
    }
    
    //Recupera el titulo de la pagina
    protected String getPageTitle() {
        return driver.getTitle();
    }
    
    protected String getText(By by, String elementName) {
        return ExplicitWaitUtil.performExplicitWait(WaitStrategy.VISIBLE, by).getText();
    }

    protected void waitForSomeTime() {
        Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS); 
    }

    protected void waitForGivenTime(long time) {
        Uninterruptibles.sleepUninterruptibly(time, TimeUnit.SECONDS);
    }
}

