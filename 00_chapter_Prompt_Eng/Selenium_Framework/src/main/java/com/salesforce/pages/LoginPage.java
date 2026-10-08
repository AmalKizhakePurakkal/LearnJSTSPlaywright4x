package com.salesforce.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@id='rememberUn']")
    private WebElement rememberMeCheckbox;

    @FindBy(xpath = "//div[@id='error']")
    private WebElement errorMessage;

    @FindBy(xpath = "//a[@id='forgot_pw_link']")
    private WebElement forgotPasswordLink;

    public LoginPage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("Driver instance cannot be null");
        }
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        try {
            wait.until(ExpectedConditions.visibilityOf(usernameInput));
            usernameInput.clear();
            usernameInput.sendKeys(username);
        } catch (TimeoutException e) {
            throw new RuntimeException("Username input field was not interactable: " + e.getMessage(), e);
        }
    }

    public void enterPassword(String password) {
        try {
            wait.until(ExpectedConditions.visibilityOf(passwordInput));
            passwordInput.clear();
            passwordInput.sendKeys(password);
        } catch (TimeoutException e) {
            throw new RuntimeException("Password input field was not interactable: " + e.getMessage(), e);
        }
    }

    public void toggleRememberMe(boolean select) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(rememberMeCheckbox));
            if (rememberMeCheckbox.isSelected() != select) {
                rememberMeCheckbox.click();
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to toggle Remember Me checkbox: " + e.getMessage(), e);
        }
    }

    public void clickLogin() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            loginButton.click();
        } catch (TimeoutException e) {
            throw new RuntimeException("Login button was not clickable: " + e.getMessage(), e);
        }
    }

    public void doLogin(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public void doLogin(String username, String password, boolean rememberMe) {
        enterUsername(username);
        enterPassword(password);
        toggleRememberMe(rememberMe);
        clickLogin();
    }

    public String getErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            return errorMessage.getText().trim();
        } catch (TimeoutException e) {
            throw new RuntimeException("Error message element was not displayed: " + e.getMessage(), e);
        }
    }

    public boolean isErrorMessageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(errorMessage)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isPageLoaded() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(loginButton)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String getPageTitle() {
        try {
            return driver.getTitle();
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve page title: " + e.getMessage(), e);
        }
    }
}

