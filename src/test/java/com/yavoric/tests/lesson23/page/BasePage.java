package com.yavoric.tests.lesson23.page;

//import com.yavoric.lesson18.dao.impl.jdbc.BaseDao;
import com.yavoric.lesson18.manager.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected PropertyManager propertyManager = PropertyManager.getInstance();
    protected String login = propertyManager.getProperty("automation.login.email");
    protected String password= propertyManager.getProperty("automation.login.password");

    protected BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    protected void inputTextField(WebElement field, String value) {
        field.click();
        field.clear();
        field.sendKeys(value);
    }
    protected void inputSelectTextField(WebElement field, String value) {
        new Select(driver.findElement(By.id("id_state"))).selectByVisibleText(value);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Alabama'])[1]/following::option[2]")).click();

    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }


}