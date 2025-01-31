package com.enviopack.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.enviopack.enums.WaitStrategy;
import com.enviopack.driver.DriverManager;
import java.time.Duration;

public final class ExplicitWaitUtil {

    private static final int EXPLICIT_WAIT_TIME = 10; // Espera de 10 segundos

    private ExplicitWaitUtil() {
    }

    public static WebElement performExplicitWait(WaitStrategy waitStrategy, By by) {

        WebElement element = null;
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(EXPLICIT_WAIT_TIME));

        if (waitStrategy == WaitStrategy.CLICKABLE) {
            element = wait.until(ExpectedConditions.elementToBeClickable(by));
        } else if (waitStrategy == WaitStrategy.PRESENCE) {
            element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } else if (waitStrategy == WaitStrategy.VISIBLE) {
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } else if (waitStrategy == WaitStrategy.NONE) {
            System.out.println("Not Waiting for anything");
            element = DriverManager.getDriver().findElement(by);
        }
        return element;
    }
}
