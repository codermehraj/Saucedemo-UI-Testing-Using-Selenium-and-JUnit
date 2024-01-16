import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.InventoryPage;
import org.example.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class InventoryPageTest {
    WebDriver driver;
    LoginPage login;

//    String username = "standard_user";
    String username = "problem_user";
//    String username = "error_user";
    String password = "secret_sauce";

    @BeforeMethod
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(3000);
        login = new LoginPage(driver);
        login.enterUsername(username);
        login.enterPassword(password);
        login.clickSubmit();
    }

    @Test
    public void test_if_user_can_add_all_Items_to_cart() throws InterruptedException {
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
        InventoryPage ip = new InventoryPage(driver);
        assertTrue(ip.additemToCart(driver));
    }

    @Test
    public void  test_filter_ZtoA() throws InterruptedException {
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
        InventoryPage ip = new InventoryPage(driver);
        assertTrue("FAILED TO FILTER Z TO A", ip.checkZtoA(driver));
    }

    @Test
    public void  test_filter_Hi_to_Lo() throws InterruptedException {
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
        InventoryPage ip = new InventoryPage(driver);
        assertTrue("FAILED TO FILTER Price Hi to Low", ip.checkPriceHitoLo(driver));
    }

    @Test
    public void  test_filter_Lo_to_hi() throws InterruptedException {
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
        InventoryPage ip = new InventoryPage(driver);
        assertTrue("FAILED TO FILTER Price Low to Hi", ip.checkPriceLotoHi(driver));
    }

    @Test
    public void  test_logout() throws InterruptedException {
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
        InventoryPage ip = new InventoryPage(driver);
        ip.clickInventoryLink();
        ip.clickLogoutLink();
        Thread.sleep(500);
        assertEquals("https://www.saucedemo.com/", driver.getCurrentUrl());
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
