package com.yavoric.tests.lesson23.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {
    @FindBy(linkText = "Sign out")
    private WebElement signOutLink;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Sign out'])[1]/preceding::span[1]")
    private WebElement userLink;

    @FindBy(xpath = "//span[contains(.,'My addresses')]")
    private WebElement myAddress;


    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getUserNameLinkText() {
        return userLink.getText().trim();
    }

    public HomePage clickSignOut() {
        signOutLink.click();
        return new HomePage(driver);
    }

    public AddressPage clickMyAddress() {
        myAddress.click();
        return new AddressPage(driver);
    }
}
