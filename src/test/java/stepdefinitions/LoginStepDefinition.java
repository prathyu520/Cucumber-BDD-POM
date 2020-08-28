package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.BaseDriver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginStepDefinition extends BaseDriver {

    WebDriver driver;
    LoginPage loginpage;


    @Given("^User opens Amazon page$")
    public void user_opens_Amazon_page() throws InterruptedException {
        driver=BaseDriver.baseDriver();
        // Write code here that turns the phrase above into concrete actions
        String title = driver.getTitle();
        Assert.assertEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more", title);
        //Assert.assertEquals("Amazon Sign-In", title);
    }

   @When("^User clicks on signin$")
    public void user_clicks_on_signin() {
        loginpage = new LoginPage();
       // PageFactory.initElements(driver,LoginPage.class);

        loginpage.clkloginPage();
        //loginpage.clksignIn();
    }

    @Then("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_enters_and(String arg1, String arg2) {
        loginpage=new LoginPage();
        loginpage.enterEmail(arg1);
        loginpage.clkcont();
        loginpage.enterPassword(arg2);
    }

    @Then("^User clicks sign in button$")
    public void user_clicks_sign_in_button() {
        loginpage.clklogIn();
    }

    @Then("^User is on Home page$")
    public void user_is_on_Home_page() throws Throwable {
        String checkUserNameIsDisplayed = loginpage.checkUserNameIsDisplayed();
        Assert.assertEquals("Hello, Naga", checkUserNameIsDisplayed);
    }

}
