package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
WebDriver driver;

public  LoginPage(WebDriver driver){
    this.driver= driver;
    PageFactory.initElements(driver,this);
}
    public void enterEnterprise(){
        WebElement enterpriseNumber = driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"LS_ENTERPRISE_ID_FIELD\"]/XCUIElementTypeOther[2]"));
        Assert.assertTrue(enterpriseNumber.isDisplayed());
        enterpriseNumber.sendKeys("ALLEN");
    }
    public void enterUsername(){
        WebElement username = driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"LS_USERNAME_FIELD\"]/XCUIElementTypeOther[2]"));
        Assert.assertTrue(username.isDisplayed());
        username.sendKeys("nida.maqsood@discorp.com");
    }

    public void enterPassword(){
        WebElement password = driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"LS_PASSWORD_FIELD\"]/XCUIElementTypeOther[2]"));
        Assert.assertTrue(password.isDisplayed());
        password.sendKeys("Service1");
        WebElement element = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"LS_COPY\"]"));
        element.click();

    }

    public void clickLogin(){
        WebElement loginButton = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Login\"]"));
        Assert.assertTrue(loginButton.isDisplayed());
        loginButton.click();
    }





}
