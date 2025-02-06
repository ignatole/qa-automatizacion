package com.enviopack.tests;

import com.enviopack.common.BaseTest;
import com.enviopack.pages.AccessAccountPage;
import com.enviopack.pages.BackOfficePage;
import com.enviopack.pages.order.OrderCommonPage;

import java.util.List;

import org.testng.annotations.Test;

public class TableReaderTests extends BaseTest {
    @Test
    public void TestTableReaderHeaders() {
        loginAs("admin");
        BackOfficePage backOfficePage = new BackOfficePage(driver);
        backOfficePage.clickAccessAccountButton();
        AccessAccountPage accesAccountPage = new AccessAccountPage(driver);
        accesAccountPage.sendKeysAccessAccountInput("5710")
                        .clickAccessAccountFirstListResult();
        OrderCommonPage orderCommonPage = new OrderCommonPage(driver);

        // Navegar a la sección de órdenes (o la sección correspondiente)
        orderCommonPage.clickOrdersSidenavItem();

        // Obtener y probar los encabezados de la tabla
        List<String> headers = orderCommonPage.getTableHeaders();

        // Imprimir los encabezados para verificar
        for (String header : headers) {
            System.out.println(header);
        }

        // Puedes agregar aserciones aquí para validar los encabezados esperados
        // assertTrue(headers.contains("Orden / Cliente"));
        // assertTrue(headers.contains("Fecha de alta / Aforo"));
    }
    @Test 
    public void TestTableReaderRows() {
        loginAs("admin");
        BackOfficePage backOfficePage = new BackOfficePage(driver);
        backOfficePage.clickAccessAccountButton();
        AccessAccountPage accesAccountPage = new AccessAccountPage(driver);
        accesAccountPage.sendKeysAccessAccountInput("5710")
                        .clickAccessAccountFirstListResult();
        OrderCommonPage orderCommonPage = new OrderCommonPage(driver);

        // Navegar a la sección de órdenes (o la sección correspondiente)
        orderCommonPage.clickOrdersSidenavItem();

        // Obtener y probar las primeras diez filas de la tabla
        List<List<String>> rows = orderCommonPage.getFirstTenRows();

        // Imprimir las filas para verificar
        for (List<String> row : rows) {
            System.out.println(row);
        }

        // Puedes agregar aserciones aquí para validar los datos esperados
        // assertEquals("Esperado", rows.get(0).get(0));
    }
}
