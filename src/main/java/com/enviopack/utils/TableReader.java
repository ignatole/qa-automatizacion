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

    // Método para leer los encabezados de la tabla
    public List<String> readTableHeaders(WebDriver driver, String headerRowXPath) {
        List<String> headers = new ArrayList<>();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement headerRow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(headerRowXPath)));
        List<WebElement> headerCells = headerRow.findElements(By.xpath(CELL_XPATH));
        for (WebElement headerCell : headerCells) {
            String headerText = headerCell.getText().trim();
            // Ignorar celdas vacías y celdas con checkboxes
            if (!headerText.isEmpty()) {
                headers.add(headerText);
            }
        }
        return headers;
    }

    // Método para leer las filas de la tabla
    public List<List<String>> readTableRows(WebDriver driver, String rowXPath, int numRows) {
        List<List<String>> tableData = new ArrayList<>();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        for (int i = 1; i <= numRows; i++) {
            String dynamicRowXPath = rowXPath + "[" + i + "]";
            WebElement row = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicRowXPath)));
            List<WebElement> cells = row.findElements(By.xpath(CELL_XPATH));
            List<String> rowData = new ArrayList<>();
            for (WebElement cell : cells) {
                rowData.add(cell.getText().trim());
            }
            tableData.add(rowData);
        }

        return tableData;
    }
}
