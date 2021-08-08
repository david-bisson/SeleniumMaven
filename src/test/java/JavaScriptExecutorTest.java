import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorTest {
    public static WebDriver driver;

    @BeforeClass
    public static void runOnceBeforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dgotl\\Downloads\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test03_javascriptExecutorTest(){
        ((JavascriptExecutor)driver).executeScript("alert('This is an alert!!');");
    }
}
