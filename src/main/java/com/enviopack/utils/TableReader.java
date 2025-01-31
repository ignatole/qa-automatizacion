package com.enviopack.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TableReader {

    private static final String CELL_XPATH = ".//div[contains(@class, 'table__cell')]"; // Fijamos el XPath de las celdas

    public List<List<String>> readTableRows(WebDriver driver, String rowXPath, int numRows) {
        List<List<String>> tableData = new ArrayList<>();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        for (int i = 1; i <= numRows; i++) {
            String dynamicRowXPath = rowXPath + "[" + i + "]";
            WebElement row = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicRowXPath)));
            List<WebElement> cells = row.findElements(By.xpath(CELL_XPATH));
            List<String> rowData = new ArrayList<>();
            for (WebElement cell : cells) {
                rowData.add(cell.getText());
            }
            tableData.add(rowData);
        }

        return tableData;
    }
}