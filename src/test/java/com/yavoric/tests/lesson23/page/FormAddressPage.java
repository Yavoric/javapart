package com.yavoric.tests.lesson23.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormAddressPage extends BasePage {

    @FindBy(xpath="//span[contains(.,'Add a new address')]")
    private WebElement addNewAddress;

    @FindBy(xpath="//button[@id='submitAddress']")
    private WebElement save;

    @FindBy(xpath="//input[@id='company']")
    private WebElement company;

    @FindBy(xpath="//input[@id='address1']")
    private WebElement address1;

    @FindBy(xpath="//input[@id='address2']")
    private WebElement address2;

    @FindBy(xpath="//input[@id='city']")
    private WebElement city;

    @FindBy(xpath="//select[@id='id_state']")
    private WebElement state;

    @FindBy(xpath="//input[@id='postcode']")
    private WebElement postcode;

    @FindBy(xpath="//input[@id='phone']")
    private WebElement phone;

    @FindBy(xpath="//input[@id='phone_mobile']")
    private WebElement phoneMobile ;

    @FindBy(xpath="//textarea[@id='other']")
    private WebElement other;

    @FindBy(xpath="//input[@id='alias']")
    private WebElement alias;


    public FormAddressPage(WebDriver driver) {
        super(driver);
    }

    public FormAddressPage clickAddNewAddress() {
        addNewAddress.click();
        return new FormAddressPage(driver);

    }
    public FormAddressPage clickSave() {
        save.click();
        return new FormAddressPage(driver);
    }
    public FormAddressPage inputCompany(String companyFild) {
        inputTextField(company, companyFild);
        return this;
    }
    public FormAddressPage inputAddress1(String address1Fild) {
        inputTextField(address1, address1Fild);
        return this;
    }
    public FormAddressPage inputAddress2(String address2Fild) {
        inputTextField(address2, address2Fild);
        return this;
    }
    public FormAddressPage inputCity(String cityFild) {
        inputTextField(city, cityFild);
        return this;
    }
    public FormAddressPage inputState(String stateFild) {
        inputSelectTextField(state, stateFild);
        return this;
    }
    public FormAddressPage inputPostcode(String postcodeFild) {
        inputTextField(postcode, postcodeFild);
        return this;
    }
    public FormAddressPage inputPhone(String phoneFild) {
        inputTextField(phone, phoneFild);
        return this;
    }
    public FormAddressPage inputPhoneMobile(String phoneMobileFild) {
        inputTextField(phoneMobile, phoneMobileFild);
        return this;
    }
    public FormAddressPage inputOther(String otherFild) {
        inputTextField(other, otherFild);
        return this;
    }
    public FormAddressPage inputAlias(String aliasFild) {
        inputTextField(alias, aliasFild);
        int random_number1 = 1 + (int) (Math.random() * 10);
        aliasFild = aliasFild+random_number1;
        return this;

    }

}