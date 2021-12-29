package com.demo.nopcommerce.page;

import com.demo.nopcommerce.utils.Constants;
import com.demo.nopcommerce.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    WebDriver driver;
    Utils utils;
    By Register = By.className("ico-register");
    // By Gender = By.xpath("//lable[@for='gender']");
    By genderFemale = By.id("gender-female");
    By firstName = By.id("FirstName");
    By lastName = By.id("LastName");
    By Day = By.cssSelector("select[name='DateOfBirthDay']");
    By Month = By.xpath("//select[@name='DateOfBirthMonth']");
    By Year = By.name("DateOfBirthYear");
    By EmailId = By.id("Email");
    By CompanyName = By.id("Company");
    By newsletter = By.id("Newsletter");
    By Password = By.id("Password");
    By Confirmpassword = By.id("ConfirmPassword");
    By registerButton = By.id("register-button");
    By Electronics = By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/a");
    By camera = By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/div/a/img");
    By Leica = By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/div[3]/div[2]/button[1]");
   // By Addcart = By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div/form/div[2]/div[1]/div[2]/div[7]/div/button");
    By shoppingCart = By.xpath("//*[@id=\"topcartlink\"]/a/span[1]");
    By Term = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[3]/div[2]/div[3]/input");
    By checkout = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[3]/div[2]/div[4]/button");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        utils = new Utils(driver);

    }

    public String getRegisterPageTitle() {
        return utils.waitForTitlePresent(Constants.REGISTER_PAGE_TITLE, 10);
        //String RPTitle = driver.getTitle();
        //Thread.sleep(4000);
        //    System.out.println("Register page title is" + RPTitle);
        //  return RPTitle;
    }

    //  public boolean VerifyRegisterButton() throws InterruptedException {
    //     Thread.sleep(4000);
    //      return driver.findElement(registerButton).isDisplayed();
    //   }

    public void registerUser(String FirstName, String LastName, String day, String month, String year, String emails,
                             String Company, String password, String ConfirmPassword) throws InterruptedException {
        utils.doClick(Register);
        //  Thread.sleep(3000);
        // utils.doClick(Gender);
        utils.doClick(genderFemale);
        Thread.sleep(3000);
        utils.doSendKeys(firstName, FirstName);
        utils.doSendKeys(lastName, LastName);
        Thread.sleep(3000);
        utils.selectValueFromDropDown(Day, day);
        Thread.sleep(3000);
        utils.selectValueFromDropDown(Month, month);
        utils.selectValueFromDropDown(Year, year);
        Thread.sleep(3000);
        utils.doSendKeys(EmailId, emails);
        utils.doSendKeys(CompanyName, Company);
        utils.doSendKeys(Password, password);
        Thread.sleep(3000);
        utils.doSendKeys(Confirmpassword, ConfirmPassword);
        utils.doClick(registerButton);
        Thread.sleep(3000);
        utils.doClick(Electronics);
        Thread.sleep(3000);
        utils.doClick(camera);
        utils.doClick(Leica);
        //utils.doClick(Addcart);
        utils.doClick(shoppingCart);
        utils.doClick(Term);
        utils.doClick(checkout);
        // System.out.println("Credentials are" + FirstName + "" + LastName + "" + emails + "" + day + "" +
        //       month + "" + Company + "" + password + "" + ConfirmPassword);


    }
}