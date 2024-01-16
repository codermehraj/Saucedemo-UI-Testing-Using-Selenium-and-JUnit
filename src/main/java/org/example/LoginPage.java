package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * LoginPage class for the website https://www.saucedemo.com/
 * The LoginPage class represents the page where users can log in.
 * It contains methods to interact with the login form elements.
 */
public class LoginPage {

    /*
     * WebElement representing the username input field.
     */
    @FindBy(id="user-name")
    private WebElement userName;

    /*
     * WebElement representing the password input field.
     */
    @FindBy(id="password")
    private WebElement password;

    /*
     * WebElement representing the submit button for login.
     */
    @FindBy(id="login-button")
    private WebElement submit;

    /**
     * Constructor to initialize the LoginPage with the WebDriver.
     * @param driver The WebDriver instance to use for interacting with the web browser.
     */
    public LoginPage(WebDriver driver){
        /*
         * The WebDriver instance for interacting with the web browser.
         */
        PageFactory.initElements(driver, this);
    }

    /**
     * Enters the provided username into the username input field.
     * @param strUserName The username to be entered.
     */
    public void enterUsername(String strUserName){
        userName.sendKeys(strUserName);
    }

    /**
     * Enters the provided password into the password input field.
     * @param strPassword The password to be entered.
     */
    public void enterPassword(String strPassword){
        password.sendKeys(strPassword);
    }

    /**
     * Clicks the submit button to log in.
     */
    public void clickSubmit(){
        submit.click();
    }

    /**
     * Enters the provided username and password and submits the login form.
     * @param strUserName The username to be entered.
     * @param strPassword The password to be entered.
     */
    public void enterCredentials(String strUserName,String strPassword){
        this.enterUsername(strUserName);
        this.enterPassword(strPassword);
    }
}
