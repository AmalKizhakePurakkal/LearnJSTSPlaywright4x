package com.salesforce.tests;

import com.salesforce.base.BaseTest;
import com.salesforce.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidLoginTest extends BaseTest {

    @Test
    public void testInvalidPasswordShowsError() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            Assert.assertTrue(loginPage.isPageLoaded(), "Login page failed to load properly");

            loginPage.doLogin("invalid.user@salesforce.com", "WrongPassword123");

            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message was not displayed for invalid login");
            String actualError = loginPage.getErrorMessage();
            Assert.assertTrue(actualError.contains("check your username and password"),
                    "Unexpected error banner text: " + actualError);
        } catch (Exception e) {
            Assert.fail("Invalid login execution failed: " + e.getMessage(), e);
        }
    }

    @Test
    public void testEmptyPasswordShowsError() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            Assert.assertTrue(loginPage.isPageLoaded(), "Login page failed to load properly");

            loginPage.doLogin("invalid.user@salesforce.com", "");

            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message was not displayed for empty password");
            String actualError = loginPage.getErrorMessage();
            Assert.assertTrue(actualError.contains("Please enter your password"),
                    "Unexpected error banner text: " + actualError);
        } catch (Exception e) {
            Assert.fail("Empty password login execution failed: " + e.getMessage(), e);
        }
    }
}

