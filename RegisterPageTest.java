package com.demo.nopcommerce.test;

import com.demo.nopcommerce.base.BasePage;
import com.demo.nopcommerce.page.RegisterPage;
import com.demo.nopcommerce.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Properties;

public class RegisterPageTest {
    BasePage basePage; //I can create class level reference
    Properties prop;
    WebDriver driver;
    RegisterPage registerPage;


    @BeforeTest
    public void openBrowser() {

        basePage = new BasePage();
        prop = basePage.initialiseProperties();
        String browser = prop.getProperty("browser");
        driver = basePage.initialiseDriver(browser);
        driver.get(prop.getProperty("url"));
        registerPage = new RegisterPage(driver);
    }

    @Test(priority = 1)
    public void verifyRegisterPageTitleTest() {
        String title = registerPage.getRegisterPageTitle();
        System.out.println("RegisterPage title is :" + title);
        Assert.assertEquals(title, Constants.REGISTER_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void RegisterTest() throws InterruptedException {
        registerPage.registerUser(prop.getProperty("FirstName"), prop.getProperty("LastName"), prop.getProperty("day"), prop.getProperty("month"),
                prop.getProperty("year"), prop.getProperty("emails"), prop.getProperty("Company"), prop.getProperty("password"), prop.getProperty("ConfirmPassword"));

    }

  @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
