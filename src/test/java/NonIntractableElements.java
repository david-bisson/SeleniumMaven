import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NonIntractableElements {
    public static WebDriver driver;

    @BeforeClass
    public static void runOnceBeforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dgotl\\Downloads\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://translate.google.com");
    }

    @Test
    public void test01_waitForDisturbingElementToDisappear(){
        By disturbingElement = By.className("ui-tabs-panel");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(disturbingElement));
    }

    @Test
    public void test02_moveFocusToElement(){
        WebElement elementToClick = driver.findElement(By.className("fa"));
        new Actions(driver).moveToElement(elementToClick).click().perform();

    }

    @Test
    public void test03_useJavascriptExecutor(){
        WebElement elementToClick = driver.findElement(By.className("fa"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", elementToClick);
    }
}
