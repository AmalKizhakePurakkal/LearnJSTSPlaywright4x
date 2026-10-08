package com.salesforce.tests;

import com.salesforce.base.BaseTest;
import com.salesforce.pages.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ValidLoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            Assert.assertTrue(loginPage.isPageLoaded(), "Login page failed to load properly");

            loginPage.doLogin("automation.user@enterprise.salesforce.com", "ValidPass123!", true);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            boolean redirected = wait.until(ExpectedConditions.or(
                    ExpectedConditions.urlContains("lightning"),
                    ExpectedConditions.urlContains("salesforce.com"),
                    ExpectedConditions.not(ExpectedConditions.urlToBe(baseUrl))
            ));

            Assert.assertTrue(redirected, "Authentication failed: Browser did not navigate away from login page");
        } catch (Exception e) {
            Assert.fail("Valid login execution failed: " + e.getMessage(), e);
        }
    }
}

