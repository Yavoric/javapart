package com.yavoric.tests.lesson23.test;

import com.yavoric.tests.lesson23.page.AccountPage;
import com.yavoric.tests.lesson23.page.AddressPage;
import com.yavoric.tests.lesson23.page.FormAddressPage;
import com.yavoric.tests.lesson23.page.HomePage;
import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class AddressTest extends BaseTest {
    @Test(dataProvider = "ProviderAddress")
    public void addAddress(String company, String address1, String address2, String city,String state,
                           String postcode, String phone, String phonemobile, String other,String alias)throws Exception {    // добавить адрес
       FormAddressPage formaddressPage =
               new AddressPage(driver)
               .addNewAddress()
               .inputCompany(company)
               .inputAddress1(address1)
               .inputAddress2(address2)
               .inputCity(city)
               .inputState(state)
               .inputPostcode(postcode)
               .inputPhone(phone)
               .inputPhoneMobile(phonemobile)
               .inputOther(other)
               .inputAlias(alias)
               .clickSave();
    }

    @BeforeMethod(alwaysRun = true)
    //@Test(dataProvider = "authProvider")
    public void Login() throws Exception {
        String email = propertyManager.getProperty("automation.username");
        String password = propertyManager.getProperty("automation.password");
        AccountPage accountPage  =
                new HomePage(driver)
                        .clickSingIn()
                        .inputEmail(email)
                        .inputPassword(password)
                        .clickSingIn();
        String userNameLinkText = accountPage.getUserNameLinkText();
        assertEquals(userNameLinkText, "Pasha Yavorskiy");
        accountPage
                .clickMyAddress()
                .clickDelete();
    }
    @DataProvider(name = "ProviderAddress")
    public Object[][] provideData() {
        return new Object[][]{
                {"AAAAA","AAAAA","AAAAA","AAAAA","Alaska","55555","123456789632","123456789632","AAAAA","My address-AAAAA"}
        };
    }
}
