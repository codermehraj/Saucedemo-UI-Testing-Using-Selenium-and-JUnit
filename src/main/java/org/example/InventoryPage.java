package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;

/**
 * The InventoryPage class represents the page displaying items for sale.
 * It contains methods to interact with various elements on the page.
 */
public class InventoryPage {

    /*
     * WebElement representing the "View Cart" link.
     */
    @FindBy(id = "shopping_cart_link")
    private WebElement viewCart;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div/span/select/option[2]")
    private WebElement sorterZtoA;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div/span/select/option[4]")
    private WebElement  sorterHiToLo;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]")
    private WebElement  sorterLoToHi;

    /*
     * WebElement representing the "Add to Cart" button for a specific item (e.g., Sauce Labs Backpack).
     */
    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    private WebElement add_bag_to_cart;
    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")
    private WebElement add_bike_to_cart;
    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")
    private WebElement add_tshirt_to_cart;
    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")
    private WebElement add_jacket_to_cart;
    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-onesie\"]")
    private WebElement add_genji_to_cart;
    @FindBy(xpath = "//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]")
    private WebElement add_red_tshirt_to_cart;

    /*
     * WebElement representing the link to the inventory link on the sidebar.
     */
//    @FindBy(id = "inventory_sidebar_link")
    @FindBy(id = "react-burger-menu-btn")
    private WebElement inventory_link;

    /*
     * WebElement representing the link to the about link on the sidebar.
     */
    @FindBy(id = "about_sidebar_link")
    private WebElement about_link;

    /*
     * WebElement representing the link to log out from the application.
     */
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[1]/div[1]/div/div[2]/div[1]/nav/a[3]")
    private WebElement logout_link;

    /*
     * WebElement representing the link to reset the application state.
     */
    @FindBy(id = "reset_sidebar_link")
    private WebElement reset_link;

    /**
     * Constructor to initialize the InventoryPage with the WebDriver.
     *
     * @param driver The WebDriver instance to use for interacting with the web browser.
     */
    public InventoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks the "View Cart" link to navigate to the shopping cart page.
     */
    public void clickViewCart() {
        viewCart.click();
    }

    /**
     * Clicks the "Add to Cart" button for a specific item (e.g., Sauce Labs Backpack)
     */
    public boolean additemToCart(WebDriver driver) throws InterruptedException {
        add_bag_to_cart.click();
        add_bike_to_cart.click();
        add_genji_to_cart.click();
        add_tshirt_to_cart.click();
        add_jacket_to_cart.click();
        add_red_tshirt_to_cart.click();
        return checkIfAllCartIsAdded(driver);
    }

    private boolean checkIfAllCartIsAdded(WebDriver driver) throws InterruptedException {

        WebElement btn1 = driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]"));
        WebElement btn2 = driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-bike-light\"]"));
        WebElement btn3 = driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-bolt-t-shirt\"]"));
        WebElement btn4 = driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-fleece-jacket\"]"));
        WebElement btn5 = driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-onesie\"]"));
        WebElement btn6 = driver.findElement(By.xpath("//*[@id=\"remove-test.allthethings()-t-shirt-(red)\"]"));

        return  true;
    }

    public boolean checkZtoA(WebDriver driver) throws InterruptedException {
        sorterZtoA.click();
        Thread.sleep(500);
        if(!driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div[1]/div[2]/div[1]/a/div")).getText().equals("Test.allTheThings() T-Shirt (Red)")) return false;
        if(!driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div[2]/div[2]/div[1]/a/div")).getText().equals("Sauce Labs Onesie")) return false;
        if(!driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div[3]/div[2]/div[1]/a/div")).getText().equals("Sauce Labs Fleece Jacket")) return false;
        if(!driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div[4]/div[2]/div[1]/a/div")).getText().equals("Sauce Labs Bolt T-Shirt")) return false;
        if(!driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div[5]/div[2]/div[1]/a/div")).getText().equals("Sauce Labs Bike Light")) return false;
        if(!driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div[6]/div[2]/div[1]/a/div")).getText().equals("Sauce Labs Backpack")) return false;
        return true;
    }

    public boolean checkPriceLotoHi(WebDriver driver) throws InterruptedException {
        sorterLoToHi.click();
        Thread.sleep(500);
        if(!driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div[1]/div[2]/div[1]/a/div")).getText().equals("Sauce Labs Onesie")) return false;
        if(!driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div[2]/div[2]/div[1]/a/div")).getText().equals("Sauce Labs Bike Light")) return false;
        if(!driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div[3]/div[2]/div[1]/a/div")).getText().equals("Sauce Labs Bolt T-Shirt")) return false;
        if(!driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div[4]/div[2]/div[1]/a/div")).getText().equals("Test.allTheThings() T-Shirt (Red)")) return false;
        if(!driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div[5]/div[2]/div[1]/a/div")).getText().equals("Sauce Labs Backpack")) return false;
        if(!driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div[6]/div[2]/div[1]/a/div")).getText().equals("Sauce Labs Fleece Jacket")) return false;
        return true;
    }

    public boolean checkPriceHitoLo(WebDriver driver) throws InterruptedException {
        sorterHiToLo.click();
        Thread.sleep(500);
        if(!driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div[6]/div[2]/div[1]/a/div")).getText().equals("Sauce Labs Onesie")) return false;
        if(!driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div[5]/div[2]/div[1]/a/div")).getText().equals("Sauce Labs Bike Light")) return false;
        if(!driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div[4]/div[2]/div[1]/a/div")).getText().equals("Test.allTheThings() T-Shirt (Red)")) return false;
        if(!driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div[3]/div[2]/div[1]/a/div")).getText().equals("Sauce Labs Bolt T-Shirt")) return false;
        if(!driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div[2]/div[2]/div[1]/a/div")).getText().equals("Sauce Labs Backpack")) return false;
        if(!driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div[1]/div[2]/div[1]/a/div")).getText().equals("Sauce Labs Fleece Jacket")) return false;
        return true;
    }

    /**
     * Clicks the link to navigate to the inventory link on the sidebar.
     */
    public void clickInventoryLink() {
        inventory_link.click();
    }

    /**
     * Clicks the link to navigate to the about link on the sidebar.
     */
    public void clickAboutLink() {
        about_link.click();
    }

    /**
     * Clicks the link to log out from the application.
     */
    public void clickLogoutLink() throws InterruptedException {
        Thread.sleep(500);
        logout_link.click();
    }

    /**
     * Clicks the link to reset the application state.
     */
    public void clickResetLink() {
        reset_link.click();
    }
}
