import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class RegEmailTest {
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
    public void regEmail() {
        driver.get("https://www.tutu.ru/");
        driver.manage().window().setSize(new Dimension(1163, 1032));
        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[1]/div[1]/div[1]/div[2]/div[6]/div/div/div/div[1]/div/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"reg-container\"]/div/div[1]/div[1]/form/input[2]")).click();
        driver.findElement(By.cssSelector(".b-input__standart:nth-child(4)")).sendKeys("egor.m1trofanov@yandex.ru");
        driver.findElement(By.cssSelector(".text:nth-child(3)")).click();
        driver.findElement(By.xpath("//*[@id=\"reg-container\"]/div/div[1]/div[1]/form/div[3]/label/input")).click();
        driver.findElement(By.xpath("//*[@id=\"reg-container\"]/div/div[1]/div[1]/form/div[4]/button")).click();
        {
            List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"reg-container\"]/div/div[1]/div[1]/form/span/span"));
            assert (elements.size() > 0);
        }
    }
}
