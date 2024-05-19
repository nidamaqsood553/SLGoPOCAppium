package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
WebDriver driver;


    @FindBy(xpath = "//*[@text=\"Enterprise ID\"]/../..//android.widget.EditText | //*[@name='LS_ENTERPRISE_ID_FIELD']//XCUIElementTypeTextField")
//    @AndroidFindBy(accessibility = "LS_ENTERPRISE_ID_FIELD")
    WebElement enterprise;
public  LoginPage(WebDriver driver){
    this.driver= driver;
    PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

//    PageFactory.initElements(driver,this);
}

    //android.view.ViewGroup[@content-desc="LS_ENTERPRISE_ID_FIELD"]/android.view.ViewGroup[1]/android.widget.FrameLayout
    public void enterEnterprise(){
//        WebElement enterpriseNumber = driver.findElement(By.className("android.view.ViewGroup"));
        Assert.assertTrue(enterprise.isDisplayed());
        enterprise.sendKeys("ALLEN");
//        Assert.assertTrue(enterprise.isDisplayed());
//        enterprise.sendKeys("ALLEN");
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
