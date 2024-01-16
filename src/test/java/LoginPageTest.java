import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.InventoryPage;
import org.example.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class LoginPageTest {
    WebDriver driver;
    LoginPage login;

    String username = "standard_user";
    String password = "secret_sauce";

    @BeforeMethod
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(3000);
    }

    private void login() {
        login = new LoginPage(driver);
        login.enterUsername(username);
        login.enterPassword(password);
        login.clickSubmit();
    }

    @Test
    public void test_if_standard_user_can_login() throws InterruptedException {
        username = "standard_user";
        login();
        Thread.sleep(1000);
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @Test
    public void test_if_locked_out_user_can_login() throws InterruptedException {
        username = "locked_out_user";
        login();
        Thread.sleep(1000);
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @Test
    public void test_if_problem_user_can_login() throws InterruptedException {
        username = "problem_user";
        login();
        Thread.sleep(1000);
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @Test
    public void test_if_performance_glitch_user_can_login() throws InterruptedException {
        username = "performance_glitch_user";
        login();
        Thread.sleep(1000);
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @Test
    public void test_if_error_user_can_login() throws InterruptedException {
        username = "error_user";
        login();
        Thread.sleep(1000);
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @Test
    public void test_if_visual_user_can_login() throws InterruptedException {
        username = "visual_user";
        login();
        Thread.sleep(1000);
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
