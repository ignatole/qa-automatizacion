package com.enviopack.tests;

import com.enviopack.common.BaseTest;
import org.testng.annotations.Test;
import com.enviopack.pages.BackOfficePage;

public class BackOfficeTest extends BaseTest {

    @Test
    public void testClickAccessAccountButton() {
        BackOfficePage backOfficePage = new BackOfficePage(driver);
        loginAs("admin");
        backOfficePage.clickAccessAccountButton();
    }
}
