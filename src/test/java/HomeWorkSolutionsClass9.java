import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeWorkSolutionsClass9 {

    private static ChromeDriver driver;

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Git\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://dgotlieb.github.io/WebCalculator/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test101_button_7_dimensions() {
        WebElement buttonElement = driver.findElement(By.id("seven"));
        System.out.println(buttonElement.getRect().getDimension());
    }

    @Test
    public void test102_is_button_6_displayed() {
        WebElement buttonElement = driver.findElement(By.id("six"));
        Assert.assertEquals(true, buttonElement.isDisplayed());
    }

    @Test
    public void test103_assert_results() {
        String number = "12";
        WebElement sixButton = driver.findElement(By.id("six"));
        WebElement twoButton = driver.findElement(By.id("two"));
        WebElement multiplyButton = driver.findElement(By.id("multiply"));
        WebElement equalButton = driver.findElement(By.id("equal"));
        WebElement screen = driver.findElement(By.id("screen"));

        sixButton.click();
        multiplyButton.click();
        twoButton.click();
        equalButton.click();
        Assert.assertEquals(number, screen.getText());

    }

    @Test
    public void test2_assert_website_url() {
        String amazonURL = "https://www.amazon.com/";
        driver.get("https://www.amazon.com/");
        Assert.assertEquals(amazonURL, driver.getCurrentUrl());

    }

    @Test
    public void test3_assert_website_title_and_refresh() {
        String amazonTitle = "Amazon.com. Spend less. Smile more.";
        driver.get("https://www.amazon.com/");
        Assert.assertEquals(amazonTitle, driver.getTitle());
    }

    @Test
    public void test4_no_extensions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        driver = new ChromeDriver(options);
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void test5_no_extensions() throws InterruptedException {
        driver.get("https://dgotlieb.github.io/Actions/");
        WebElement box = driver.findElementById("div1");
        WebElement wheel = driver.findElementById("drag1");
        takeElementScreenshot(box);
        Actions drag = new Actions(driver);
        drag.dragAndDrop(wheel, box).build().perform();
//        drag.clickAndHold(wheel).moveToElement(box).release(box).build().perform();
//        Thread.sleep(10000);
        WebElement From = driver.findElement(By.id("drag1"));
        WebElement To = driver.findElement(By.id("div1"));

        //HTML 5
        final String java_script =
                "var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +
                        "ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +
                        "ction(format,data){this.items[format]=data;this.types.append(for" +
                        "mat);},getData:function(format){return this.items[format];},clea" +
                        "rData:function(format){}};var emit=function(event,target){var ev" +
                        "t=document.createEvent('Event');evt.initEvent(event,true,false);" +
                        "evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +
                        "dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +
                        "'drop',tgt);emit('dragend',src);";

        ((JavascriptExecutor) driver).executeScript(java_script, From, To);
        Actions builder = new Actions(driver);
        Action dragAndDrop = builder.clickAndHold(From)
                .moveToElement(To)
                .release(To)
                .build();
        dragAndDrop.perform();

//        WebElement doubleClickText = driver.findElementByXPath("//p[@ondblclick='doubleClickFunction()']");
        WebElement doubleClickText = driver.findElementByXPath("//p[@ondblclick='doubleClickFunction()']");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        drag.doubleClick(doubleClickText);

        WebElement xImage = driver.findElementById("close");
        drag.moveToElement(xImage).perform();

        Select myFood = new Select(driver.findElement(By.name("food")));
        myFood.selectByVisibleText("Pizza");
        myFood.selectByVisibleText("Pasta");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@type='file' and @name='pic']")).sendKeys("C:\\Git\\Expert\\SeleniumMaven\\element-screenshot.png"); //NOT WORKING

        WebElement clickMe = driver.findElementById("clickMe");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickMe);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", box);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//        System.out.println(clickMe.getLocation());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(8,860)");

    }

    @Test
    public void test6() {
        driver.get("https://dgotlieb.github.io/Controllers/");
        driver.findElementByCssSelector("input[value=Cheese]").click();
        Select list = new Select(driver.findElement(By.name("dropdownmenu")));
        list.selectByVisibleText("Milk");
//        System.out.println(list);
        List<WebElement> buttonsList = driver.findElements(By.name("dropdownmenu"));
        for (WebElement currentButton : buttonsList) {
            System.out.println(currentButton.getText());
        }

    }

    @Test
    public void test7() {
        driver.get("https://dgotlieb.github.io/WebCalculator/");
        System.out.println("2 button height is: " + driver.findElementById("two").getSize().height);
        System.out.println("6 button width is: " + driver.findElementById("six").getSize().width);
    }

    @Test
    public void test8() {
        driver.get("https://www.themarker.com/");
        String str = driver.getPageSource();
        String findStr = "news";
        int rowcount = str.split(findStr, -1).length-1;
        System.out.println(rowcount);
    }

    @Test
    public void test9_print_page() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--kiosk-printing");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://dgotlieb.github.io/WebCalculator/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.print();");
    }


    @AfterClass
    public static void tearDown() {
        driver.quit();
    }


    private static void takeElementScreenshot(WebElement element) {
        File screenShotFile = element.getScreenshotAs(OutputType.FILE); // take the screenshot
        try {
            FileUtils.copyFile(screenShotFile, new File("element-screenshot.png")); // save screenshot to disk
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
