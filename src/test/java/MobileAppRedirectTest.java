import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MobileAppRedirectTest {
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
    public void mobileAppRedirect() {
        driver.get("https://www.tutu.ru/");
        driver.manage().window().setSize(new Dimension(974, 1032));
        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[1]/div[6]/div/div[3]/div[1]/a[1]/img")).click();
        vars.put("url", js.executeScript("return window.location.href"));
        vars.put("res", js.executeScript("return arguments[0].startsWith(\"https://apps.apple.com/ru/app/id1296791829\")", vars.get("url")));
        assertEquals(vars.get("res").toString(), "true");
    }
}
