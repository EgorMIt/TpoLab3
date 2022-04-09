import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class RecoverPasswordTest {
    private WebDriver driver;
    JavascriptExecutor js;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        js = (JavascriptExecutor) driver;
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void recoverPassword() {
        driver.get("https://www.tutu.ru/");
        driver.manage().window().setSize(new Dimension(1163, 1032));
        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[1]/div[1]/div[1]/div[2]/div[6]/div/div/div/div[1]/div/div/span")).click();
        driver.findElement(By.name("password")).sendKeys("yaf3421");
        driver.findElement(By.xpath("//*[@id=\"login-container\"]/div/div/div[1]/form/div[4]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"login-container\"]/div/div/div[1]/form/div[3]/div/span")).click();
        driver.findElement(By.xpath("//*[@id=\"login-container\"]/div/div/div[2]/form/div[1]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"login-container\"]/div/div/div[2]/form/div[1]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"login-container\"]/div/div/div[2]/form/div[1]/input")).sendKeys("egor.m1trofanov@yandex.ru");
        driver.findElement(By.xpath("//*[@id=\"login-container\"]/div/div/div[2]/form/div[2]/button")).click();
        {
            List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"login-container\"]/div/div/div[3]"));
            assert (elements.size() > 0);
        }
    }
}
