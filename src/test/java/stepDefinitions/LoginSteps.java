package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class LoginSteps {

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();

    @Given("I have registered a new ParaBank user")
    public void i_have_registered_a_new_parabank_user() {
        homePage.clickRegister();
        registerPage.enterUserDetails();
        registerPage.clickRegister();

        try { Thread.sleep(2000); } catch (InterruptedException e) {}

        // Logout — ParaBank auto-logs in after registration
        BaseClass.driver.get("https://parabank.parasoft.com/parabank/logout.htm");

        try { Thread.sleep(1500); } catch (InterruptedException e) {}
        System.out.println("Registered and logged out. Username: " + BaseClass.username);
    }

    @When("I navigate to the login page")
    public void i_navigate_to_the_login_page() {
        String url = BaseClass.driver.getCurrentUrl();
        Assert.assertTrue(url.contains("parabank"), "Not on ParaBank. URL: " + url);
        System.out.println("On login page. URL: " + url);
    }

    @And("I login with valid credentials")
    public void i_login_with_valid_credentials() {
        loginPage.login();
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        System.out.println("Login attempted. Username: " + BaseClass.username);
    }

    @Then("I should see the Accounts Overview page")
    public void i_should_see_accounts_overview_page() {
        WebElement heading = BaseClass.driver.findElement(
            By.xpath("//h1[contains(text(),'Accounts Overview')]"));
        Assert.assertTrue(heading.isDisplayed(), "Accounts Overview not visible.");
        System.out.println("Login successful — Accounts Overview confirmed.");
    }
}