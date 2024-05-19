package tests;
import base.AppiumCapability;
import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import pages.LoginPage;


import java.net.URL;

public class LoginTest extends  AppiumCapability{


@Test
        public void login() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:deviceName", "iphone 14");
        caps.setCapability("platformName", "iOS");
        caps.setCapability("appium:platformVersion", "16.4");
        caps.setCapability("appium:automationName", "XCUITest");
        caps.setCapability("appium:udid", "F55BEF6F-0CCC-4B5A-8DF2-1B6B93D9C108");
        caps.setCapability("appium:bundleId", "com.discorp.mobile.servicelogistics");



        DesiredCapabilities androidCaps = new DesiredCapabilities();
        androidCaps.setCapability("deviceName", "vivo v2322");
        androidCaps.setCapability("platformName", "android");
        androidCaps.setCapability("platformVersion", "13.0");
        androidCaps.setCapability("automationName", "uiautomator2");
//        androidCaps.setCapability("appiumSettingsWaitDuration", 60000);
//        androidCaps.setCapability("bundleId", "com.discorp.mobile.servicelogistics");
        androidCaps.setCapability("app", "/Users/nidamaqsood/IdeaProjects/SLGoPOC/SL.apk");
        androidCaps.setCapability("appPackage", "com.discorp.mobile.servicelogistics");
        androidCaps.setCapability("appActivity", "com.discorp.mobile.servicelogistics.activity.MainActivity");



//        caps.setCapability(MobileCapabilityType.NO_RESET, false);



        AppiumDriver<MobileElement> driver = new AppiumDriver<>(new URL("http://localhost:4723"), androidCaps);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEnterprise();
//        loginPage.enterUsername();
//        loginPage.enterPassword();
//        loginPage.clickLogin();
        System.out.println("Logged in successfully");





    }
//    private static AppiumDriver<MobileElement> driver;




    }
