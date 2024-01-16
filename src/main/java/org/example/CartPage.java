package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * The CartPage class represents the shopping cart page.
 * It contains methods to interact with the cart items and proceed to checkout.
 */
public class CartPage {

    /**
     * WebElement representing the remove item button in the cart.
     */
    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement remove_item;

    /**
     * WebElement representing the checkout button in the cart.
     */
    @FindBy(id = "checkout")
    private WebElement checkout;

    /**
     * Constructor to initialize the CartPage with the WebDriver.
     *
     * @param driver The WebDriver instance to use for interacting with the web browser.
     */
    public CartPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks the remove item button to remove an item from the cart.
     */
    public void removeItemFromCart() {
        remove_item.click();
    }

    /**
     * Clicks the checkout button to proceed to checkout.
     */
    public void proceedToCheckout() {
        checkout.click();
    }
}
