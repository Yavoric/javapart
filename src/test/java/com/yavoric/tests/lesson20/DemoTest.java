package com.yavoric.tests.lesson20;
import com.yavoric.lesson18.manager.PropertyManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class DemoTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private PropertyManager propertyManager = PropertyManager.getInstance();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", propertyManager.getProperty("firefox.driver"));
        driver = new FirefoxDriver();
        baseUrl = propertyManager.getProperty("automation.baseurl");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void menuWoman() {
        System.out.println("menuWoman");
        driver.get(baseUrl);
        driver.findElement(By.xpath("//a[@title='Women']")).click();

        waitUntilScriptComplete(driver);// ждем пока прогрузится
        try {
            assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Categories'])[3]/following::a[1]")).getText(), "Women");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='You will find here all woman fashion collections.'])[1]/following::h1[1]")).getText(), "Women There are 7 products.");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }



        // можно делать проверки

    }
    @Test
    public void sortDressByLowestPriceTest() {
        System.out.println("sortDressByLowestPriceTest");
        driver.get(baseUrl);
        driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(2) > a")).click();
        new Select(driver.findElement(By.id("selectProductSort"))).selectByVisibleText("Price: Lowest first");
        waitUntilScriptComplete(driver);// ждем пока прогрузится
        try {
            assertEquals(driver.findElement(By.xpath("//div[@class='product-count']")).getText(), "Showing 1 - 5 of 5 items");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

        /*List<WebElement> elements = driver.findElements(By.className("replace-2x img-responsive"));
        int itemCount = elements.size();
        if (itemCount == 5)
            System.out.println("Found 5 Elements");
            else
                System.out.println("NOT Found 5 Elements");*/



        // можно делать проверки

    }
    @Test
    public void testAddress() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).sendKeys(propertyManager.getProperty("automation.username"));
        driver.findElement(By.id("passwd")).sendKeys(propertyManager.getProperty("automation.password"));
        driver.findElement(By.id("SubmitLogin")).click();
        driver.findElement(By.xpath("//span[contains(.,'My addresses')]")).click();
        driver.findElement(By.xpath("//span[contains(.,'Add a new address')]")).click();
        driver.findElement(By.xpath("//input[@id='address1']")).click();
        driver.findElement(By.xpath("//input[@id='address1']")).clear();
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("gfdgdfgdf");
        driver.findElement(By.id("address2")).click();
        driver.findElement(By.id("address2")).clear();
        driver.findElement(By.id("address2")).sendKeys("gfgdfg");
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("city")).sendKeys("fgfdgdfgd");
        driver.findElement(By.id("id_state")).click();
        new Select(driver.findElement(By.id("id_state"))).selectByVisibleText("Alabama");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Alabama'])[1]/following::option[2]")).click();
        driver.findElement(By.id("postcode")).click();
        driver.findElement(By.id("postcode")).clear();
        driver.findElement(By.id("postcode")).sendKeys("61444");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='T-shirts'])[2]/following::div[1]")).click();
        driver.findElement(By.id("alias")).click();
        driver.findElement(By.id("alias")).clear();
        driver.findElement(By.id("alias")).sendKeys("My address3");
        driver.findElement(By.id("phone")).click();
        driver.findElement(By.id("phone")).clear();
        driver.findElement(By.id("phone")).sendKeys("544524534");
        driver.findElement(By.id("submitAddress")).click();
    }
    private boolean waitUntilScriptComplete(WebDriver driver1) {
        WebDriverWait wait = new WebDriverWait(driver1, 30, 300);

        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = driver -> {
            try {
                return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
            }
            catch (Exception e) {
                // no jQuery present
                return true;
            }
        };

        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor)driver).executeScript("return document.readyState")
                .toString().equals("complete");

        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }
    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }

}
