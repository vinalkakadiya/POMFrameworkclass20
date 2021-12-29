package com.demo.nopcommerce.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage {
    WebDriver driver;
    Properties prop;
    FileInputStream file;


    /**
     * This method is used to initialise the driver on the basis of browername.
     *
     * @param browserName
     */

    public WebDriver initialiseDriver(String browserName) {
        if (browserName.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\kakad\\IdeaProjects\\PracticeLeaning\\" +
                    "POMFramework1\\src\\test\\resources\\BrowersDrivers\\chromedriver.exe");
            //  WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();//initialised the driver with browser
        } else if (browserName.equals("edge")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\kakad\\IdeaProjects\\PracticeLeaning\\POMFramework1" +
                    "\\src\\test\\resources\\BrowersDrivers\\msedgedriver.exe");
            driver = new EdgeDriver();
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/BrowersDrivers/geckodriver.exe\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            System.out.println(browserName + "Browser is invalid,please enter correct browser name");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        return driver;

    }

    public Properties initialiseProperties() {
        prop = new Properties();

        try {  //Location of file
            file = new FileInputStream("C:\\Users\\kakad\\IdeaProjects\\PracticeLeaning\\" +
                    "POMFarmework5\\src\\test\\resources\\config.properties");

            prop.load(file);

        } catch (FileNotFoundException e) {
            System.out.println("Config file is not found, please check...");
        } catch (IOException e) {
            System.out.println("Properties could not be loaded...");
            e.printStackTrace();

        }
        return prop;
    }



}

