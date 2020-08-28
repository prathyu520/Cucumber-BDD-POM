package pages;


import cucumber.api.java.en_old.Ac;
import driver.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BaseDriver {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "nav-link-accountList")
    public WebElement hover;


    @FindBy(xpath = "//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner']")
    public WebElement loginPage;

    @FindBy(name = "email")
    @CacheLookup
    public WebElement email;

    @FindBy(className = "a-button-input")
    public WebElement cont;

    @FindBy(id = "ap_password")
    public WebElement password;

    @FindBy(id = "signInSubmit")
    public WebElement logIn;

    @FindBy(xpath = "//*[@id=\"nav-link-accountList\"]/div/span")
    public WebElement homePage;


    public void clkloginPage() {
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Actions actions = new Actions(driver);
        actions.moveToElement(hover).click().perform();
        loginPage.click();
        //driver.findElement(By.xpath("//span[.='Hello, Sign in']"));

    }

  /*  public void clksignIn() {
        signIn.click();
    }*/

    public void enterEmail(String emailaddress) {
        //PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        email.sendKeys(emailaddress);
    }

    public void clkcont() {
        cont.click();
    }

    public void enterPassword(String pwd) {
        //PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        password.sendKeys(pwd);
    }

    public void clklogIn() {
        logIn.click();
    }

    public String checkUserNameIsDisplayed() {
        //PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return homePage.getText();
    }

}


