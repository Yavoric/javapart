package com.yavoric.tests.lesson22;
import com.yavoric.lesson18.manager.PropertyManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class MainTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private PropertyManager propertyManager = PropertyManager.getInstance();
    private Login login = new Login();

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setUp(String browser) throws Exception {
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", propertyManager.getProperty("chrome.driver"));
                driver = new ChromeDriver();
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", propertyManager.getProperty("firefox.driver"));
                driver = new FirefoxDriver();
                break;

            default:
        }
        baseUrl = propertyManager.getProperty("automation.baseurl");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
   // @Test
    public void testLogin() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.linkText(login.getSignIn())).click();
        driver.findElement(By.id(login.getEmail())).sendKeys(login.getLogin());
        driver.findElement(By.id(login.getPassword())).sendKeys(login.getcPassword());
        driver.findElement(By.id(login.getSubmitLogin())).click();
        driver.findElement(By.linkText(login.getSignOut())).click();
    }
    @Test(dataProvider = "ProviderIncorrectLogin")
    public void testIncorrectLogin(String username,String password,String errors) throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.linkText(login.getSignIn())).click();
        driver.findElement(By.id(login.getEmail())).sendKeys(username);
        driver.findElement(By.id(login.getPassword())).sendKeys(password);
        driver.findElement(By.id(login.getSubmitLogin())).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Authentication'])[1]/following::div[3]")).click();
        try {
            assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=" +
                    "'Authentication'])[2]/following::li[1]")).getText(),errors);
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
   // @Test
    public void delAddress() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.linkText(login.getSignIn())).click();
        driver.findElement(By.id(login.getEmail())).sendKeys(login.getLogin());
        driver.findElement(By.id(login.getPassword())).sendKeys(login.getcPassword());
        driver.findElement(By.id(login.getSubmitLogin())).click();
        driver.findElement(By.xpath("//span[contains(.,'My addresses')]")).click();
        driver.findElement(By.xpath("//span[contains(.,'Delete')]")).click();
        assertTrue(closeAlertAndGetItsText().matches("^Are you sure[\\s\\S]$"));
        try {
            assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My addresses'])[2]/following::p[2]")).getText(), "No addresses are available. Add a new address");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

   // @Test(dataProvider = "ProviderAddress")
    public void addAddress(String company, String address1, String address2, String city,String idState,
                           String postcode, String phone, String phonemobile, String other,String alias)throws Exception {    // добавить адрес
        driver.get(baseUrl);
        driver.findElement(By.linkText(login.getSignIn())).click();
        driver.findElement(By.id(login.getEmail())).sendKeys(login.getLogin());
        driver.findElement(By.id(login.getPassword())).sendKeys(login.getcPassword());
        driver.findElement(By.id(login.getSubmitLogin())).click();
        driver.findElement(By.xpath("//span[contains(.,'My addresses')]")).click();
        driver.findElement(By.xpath("//span[contains(.,'Add a new address')]")).click();
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys(company);
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(address1);
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys(address2);
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys(city);
        new Select(driver.findElement(By.id("id_state"))).selectByVisibleText(idState);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Alabama'])[1]/following::option[2]")).click();
        driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys(postcode);
        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phone);
        driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys(phonemobile);
        driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys(other);
        driver.findElement(By.xpath("//input[@id='alias']")).sendKeys(alias);
        driver.findElement(By.xpath("//button[@id='submitAddress']")).click();

    }
    //@Test
    public void sortDressByLowestPriceTest() {
        System.out.println("sortDressByLowestPriceTest");
        driver.get(baseUrl);
        driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(2) > a")).click();
        new Select(driver.findElement(By.id("selectProductSort"))).selectByVisibleText("Price: Lowest first");
        waitUntilScriptComplete(driver);// ждем пока прогрузится
        driver.findElement(By.xpath("//i[@class='icon-th-list']")).click();
        try {
            assertEquals(driver.findElement(By.xpath("//div[@class='product-count']")).getText(), "Showing gfgfgfgfgof 5 items");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        List<String> actualPrices = driver.findElements(By.cssSelector("#center_column > ul > li > div > div > " +
                "div.right-block.col-xs-4.col-xs-12.col-md-4 > div > div.content_price.col-xs-5.col-md-12 > span.price.product-price"))
                .stream()
                .map(WebElement::getText)
                .peek(String::trim)
                .collect(Collectors.toList());

        List<String> expectedPrices = new ArrayList<>(actualPrices);
        expectedPrices.sort(String::compareTo);
        Assert.assertEquals(actualPrices, expectedPrices);

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
    @DataProvider(name = "ProviderIncorrectLogin")
    public Object[][] provideData1() {
        return new Object[][]{
                {"qwer@qwe.qwe","123qwe","Authentication failed."},
                {"qwer@qwe.qwe","Tnm601982","Authentication failed."},
                {"yavoric@rambler.ru","123qwe","Authentication failed."},
                {"","","An email address required."},
                {"yavoric@rambler.ru","","Password is required."},
                {"","Tnm601982","An email address required."},
                {"qwerty","","Invalid email address."}
        };
    }
    @DataProvider(name = "ProviderAddress")
    public Object[][] provideData() {
        return new Object[][]{
                {"AAAAA","AAAAA","AAAAA","AAAAA","Alaska","55555","123456789632","123456789632","AAAAA","My address-AAAAA"}
        };
    }
    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        System.out.println("@AfterClass");
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
   //@BeforeTest(alwaysRun = true)
    public void Login() throws Exception {
        System.out.println("@BeforeTest");
        driver.get(baseUrl);
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).sendKeys(propertyManager.getProperty("automation.username"));
        driver.findElement(By.id("passwd")).sendKeys(propertyManager.getProperty("automation.password"));
        driver.findElement(By.id("SubmitLogin")).click();
    }
    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}

