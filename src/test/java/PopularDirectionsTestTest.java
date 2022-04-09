import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PopularDirectionsTestTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        js = (JavascriptExecutor) driver;
        vars = new HashMap<>();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void popularDirectionsTest() {
        driver.get("https://www.tutu.ru/");
        driver.manage().window().setSize(new Dimension(974, 1032));
        WebElement link = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[4]/div/div[1]/div/span[3]/a"));
        js.executeScript("arguments[0].click()", link);

        link = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[1]/div[1]/div/div[1]/a"));
        js.executeScript("arguments[0].click()", link);

        {
            String value = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div[2]/div[2]/div/div/div/div/div[1]/div/div[1]/div[1]/div/div[2]/div/div/div/input")).getAttribute("value");
            assertEquals(value, "Санкт-Петербург");
        }
        {
            String value = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div[2]/div[2]/div/div/div/div/div[1]/div/div[1]/div[2]/div/div[2]/div/div/div/input")).getAttribute("value");
            assertEquals(value, "Москва");
        }
        vars.put("url", js.executeScript("return window.location.href"));
        assertEquals(vars.get("url").toString(), "https://avia.tutu.ru/%D1%80%D0%B0%D1%81%D0%BF%D0%B8%D1%81%D0%B0%D0%BD%D0%B8%D0%B5_%D1%81%D0%B0%D0%BC%D0%BE%D0%BB%D0%B5%D1%82%D0%BE%D0%B2/%D0%A1%D0%B0%D0%BD%D0%BA%D1%82-%D0%9F%D0%B5%D1%82%D0%B5%D1%80%D0%B1%D1%83%D1%80%D0%B3__%D0%9C%D0%BE%D1%81%D0%BA%D0%B2%D0%B0/");
    }
}
