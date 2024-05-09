package tests;
import base.AppiumCapability;
import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import pages.LoginPage;


import java.net.URL;

public class LoginTest extends  AppiumCapability{
    AppiumDriver driver;
@Test
        public void login() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:deviceName", "iphone 14");
        caps.setCapability("platformName", "iOS");
        caps.setCapability("appium:platformVersion", "16.4");
        caps.setCapability("appium:automationName", "XCUITest");
        caps.setCapability("appium:udid", "F55BEF6F-0CCC-4B5A-8DF2-1B6B93D9C108");
        caps.setCapability("appium:bundleId", "com.discorp.mobile.servicelogistics");
        AppiumDriver<MobileElement> driver = new IOSDriver<>(new URL("http://localhost:4723"), caps);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEnterprise();
        loginPage.enterUsername();
        loginPage.enterPassword();

        loginPage.clickLogin();
    System.out.println("Logged in successfully");


    }



    }
