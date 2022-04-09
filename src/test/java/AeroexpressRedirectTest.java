import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AeroexpressRedirectTest {
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
    public void aeroexpressRedirect() {
        driver.get("https://www.tutu.ru/");
        driver.manage().window().setSize(new Dimension(948, 1032));
        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[1]/div[4]/div/div[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[1]/div[4]/div/div[3]/div[1]/a[3]/div[2]")).click();
        vars.put("url", js.executeScript("return window.location.href"));
        assertEquals(vars.get("url").toString(), "https://aeroexpress.tutu.ru/");
    }
}
