package com.yavoric.tests.lesson19.automationpractice;

import com.yavoric.lesson18.manager.PropertyManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class LoginTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private PropertyManager propertyManager = PropertyManager.getInstance();


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
        //System.setProperty("webdriver.gecko.driver", propertyManager.getProperty("firefox.driver"));
        //driver = new FirefoxDriver();
        baseUrl = propertyManager.getProperty("automation.baseurl");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testAuthCorrect() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).sendKeys(propertyManager.getProperty("automation.username"));
        driver.findElement(By.id("passwd")).sendKeys(propertyManager.getProperty("automation.password"));
        driver.findElement(By.id("SubmitLogin")).click();
        driver.findElement(By.linkText("Sign out")).click();
    }
    @Test
    public void testAuthIncorrectLoginAndPassword() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).sendKeys(propertyManager.getProperty("automation.usernameincorect"));
        driver.findElement(By.id("passwd")).sendKeys(propertyManager.getProperty("automation.passwordincorect"));
        driver.findElement(By.id("SubmitLogin")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Authentication'])[1]/following::div[3]")).click();
        try {
            assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=" +
                    "'Authentication'])[2]/following::li[1]")).getText(),propertyManager.getProperty("automation.errormessage1"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
    @Test
    public void testAuthIncorrectLogin()throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).sendKeys(propertyManager.getProperty("automation.usernameincorect"));
        driver.findElement(By.id("passwd")).sendKeys(propertyManager.getProperty("automation.password"));
        driver.findElement(By.id("SubmitLogin")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Authentication'])[1]/following::div[3]")).click();
        try {
            assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=" +
                    "'Authentication'])[2]/following::li[1]")).getText(),propertyManager.getProperty("automation.errormessage1"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
    @Test
    public void testAuthIncorrectPassword()throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).sendKeys(propertyManager.getProperty("automation.username"));
        driver.findElement(By.id("passwd")).sendKeys(propertyManager.getProperty("automation.passwordincorect"));
        driver.findElement(By.id("SubmitLogin")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Authentication'])[1]/following::div[3]")).click();
        try {
            assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=" +
                    "'Authentication'])[2]/following::li[1]")).getText(),propertyManager.getProperty("automation.errormessage1"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
    @Test
    public void testAuthIncorrectNull()throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("SubmitLogin")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Authentication'])[1]/following::div[3]")).click();
        try {
            assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=" +
                    "'Authentication'])[2]/following::li[1]")).getText(),propertyManager.getProperty("automation.errormessage2"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
    @Test
    public void testAuthIncorrectPasswordNull()throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).sendKeys(propertyManager.getProperty("automation.username"));
        driver.findElement(By.id("SubmitLogin")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Authentication'])[1]/following::div[3]")).click();
        try {
            assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=" +
                    "'Authentication'])[2]/following::li[1]")).getText(),propertyManager.getProperty("automation.errormessage3"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
    @Test
    public void testAuthIncorrectLoginNull() throws Exception{
        driver.get(baseUrl);
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("passwd")).sendKeys(propertyManager.getProperty("automation.password"));
        driver.findElement(By.id("SubmitLogin")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Authentication'])[1]/following::div[3]")).click();
        try {
            assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=" +
                    "'Authentication'])[2]/following::li[1]")).getText(),propertyManager.getProperty("automation.errormessage2"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
    @Test
    public void testAuthIncorrectLoginWrong()throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).sendKeys(propertyManager.getProperty("automation.usernamefaild"));
        driver.findElement(By.id("SubmitLogin")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Authentication'])[1]/following::div[3]")).click();
        try {
            assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=" +
                    "'Authentication'])[2]/following::li[1]")).getText(),propertyManager.getProperty("automation.errormessage4"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
        @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
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
