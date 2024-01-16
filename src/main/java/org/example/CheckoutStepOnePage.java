package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * The CheckoutStepOnePage class represents the first step of the checkout process.
 * It contains methods to enter user information for checkout.
 */
public class CheckoutStepOnePage {

    /**
     * WebElement representing the input field for the first name.
     */
    @FindBy(id = "first-name")
    private WebElement firstName;

    /**
     * WebElement representing the input field for the last name.
     */
    @FindBy(id = "last-name")
    private WebElement lastName;

    /**
     * WebElement representing the input field for the postal code.
     */
    @FindBy(id = "postal-code")
    private WebElement postalCode;

    /**
     * WebElement representing the continue button to proceed to the next step.
     */
    @FindBy(id = "continue")
    private WebElement continueButton;

    /**
     * Constructor to initialize the CheckoutStepOnePage with the WebDriver.
     *
     * @param driver The WebDriver instance to use for interacting with the web browser.
     */
    public CheckoutStepOnePage(WebDriver driver) {
        /**
         * The WebDriver instance for interacting with the web browser.
         */
        PageFactory.initElements(driver, this);
    }

    /**
     * Enters the provided first name into the corresponding input field.
     *
     * @param firstName The first name to be entered.
     */
    public void enterFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    /**
     * Enters the provided last name into the corresponding input field.
     *
     * @param lastName The last name to be entered.
     */
    public void enterLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    /**
     * Enters the provided postal code into the corresponding input field.
     *
     * @param postalCode The postal code to be entered.
     */
    public void enterPostalCode(String postalCode) {
        this.postalCode.sendKeys(postalCode);
    }

    /**
     * Clicks the continue button to proceed to the next step of the checkout process.
     */
    public void clickContinue() {
        this.continueButton.click();
    }

    /**
     * Enters the user's checkout information by invoking the respective methods.
     *
     * @param firstName The first name to be entered.
     * @param lastName  The last name to be entered.
     * @param postalCode The postal code to be entered.
     */
    public void enterCheckoutInfo(String firstName, String lastName, String postalCode) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);
    }
}
