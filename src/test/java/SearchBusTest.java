import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class SearchBusTest {
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
    public void searchBus() {
        driver.get("https://www.tutu.ru/");
        driver.manage().window().setSize(new Dimension(1163, 1032));
        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[1]/div[4]/div/div[1]/div[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"bus-form\"]/div/div/div[1]/div/span/div/div/input")).click();
        driver.findElement(By.xpath("//*[@id=\"bus-form\"]/div/div/div[1]/div/span/div/div/input")).sendKeys("Астрахань");
        driver.findElement(By.xpath("//*[@id=\"bus-form\"]/div/div/div[2]/div/span/div/div/input")).click();
        driver.findElement(By.xpath("//*[@id=\"bus-form\"]/div/div/div[2]/div/span/div/div/input")).sendKeys("Казань");
        {
            WebElement element = driver.findElement(By.cssSelector(".l-screen-top"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).release().perform();
        }
        driver.findElement(By.xpath("//*[@id=\"bus-form\"]/div/div/div[3]/div/div/div/input")).click();
        driver.findElement(By.xpath("//*[@id=\"bus-form\"]/div/div/div[3]/div/div/div/input")).sendKeys("25.05.2022");
        driver.findElement(By.xpath("//*[@id=\"bus-form\"]/div/div/div[5]/div/button/div")).click();
        {
            List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"content\"]/div/div[1]/header/div/div/div/div[3]/div[1]/a[2]/span[2]"));
            assert (elements.size() > 0);
        }
    }
}
