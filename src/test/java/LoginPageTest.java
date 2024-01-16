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

    String username = "problem_user";
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
    public void test_if_user_can_login() throws InterruptedException {
        Thread.sleep(1000);
        assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
