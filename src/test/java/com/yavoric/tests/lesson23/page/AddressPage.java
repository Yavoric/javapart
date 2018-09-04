package com.yavoric.tests.lesson23.page;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddressPage extends BasePage {
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @FindBy(xpath = "//span[contains(.,'Add a new address')]")
    private WebElement addNewAddress;

    @FindBy(xpath = "//span[contains(.,'Delete')]")
    private WebElement delete;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='My addresses'])[2]/following::p[2]")
    private WebElement availabilityAddress;

    public AddressPage(WebDriver driver) {
        super(driver);
    }

    public String getAvailabilityAddressText() {
        return availabilityAddress.getText().trim();
    }


    public FormAddressPage addNewAddress() {
        addNewAddress.click();
        return new FormAddressPage(driver);
    }
//совсем не красиво! нужно переделать
    public AddressPage clickDelete() {
        delete.click();
        assertTrue(closeAlertAndGetItsText().matches("^Are you sure[\\s\\S]$"));
        try {
            assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My addresses'])[2]/following::p[2]")).getText(), "No addresses are available. Add a new address");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        return new AddressPage(driver);
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

