import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
public class test {
    ChromeDriver chromeDriver;

    @BeforeMethod
    public void Setup() {
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
        System.out.println("Setup method");
    }

    @AfterMethod
    public void CleanUp() {
        chromeDriver.quit();
        System.out.println("After");
    }

    @Test
    public void Run() {
        System.out.println("Starting the test");

        chromeDriver.get("https://sso.skhcn.erp.meu-solutions.com/auth/login");

        WebElement btnLogin = chromeDriver.findElement(By.id("login-btn"));
        WebElement emailInput = chromeDriver.findElement(By.cssSelector("input[formcontrolname='email']"));
        WebElement passwordInput = chromeDriver.findElement(By.cssSelector("input[formcontrolname='password']"));

        emailInput.sendKeys("admin@meu-solutions.com");
        passwordInput.sendKeys("123456");


        btnLogin.click();
        sleep(3000);

    }

    private void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
