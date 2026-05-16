package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.OpenNewAccountPage;
import pages.RegisterPage;

public class OpenAccountSteps {

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    OpenNewAccountPage openAccountPage = new OpenNewAccountPage();

    @Given("I am logged in as a registered user")
    public void i_am_logged_in_as_a_registered_user() {
        // Register fresh user
        homePage.clickRegister();
        registerPage.enterUserDetails();
        registerPage.clickRegister();

        try { Thread.sleep(2000); } catch (InterruptedException e) {}

        // Logout first — ParaBank auto-logs in after register
        BaseClass.driver.get("https://parabank.parasoft.com/parabank/logout.htm");

        try { Thread.sleep(1500); } catch (InterruptedException e) {}

        // Now login
        loginPage.login();

        try { Thread.sleep(2000); } catch (InterruptedException e) {}

        System.out.println("Logged in as: " + BaseClass.username);
    }

    @When("I navigate to Open New Account page")
    public void i_navigate_to_open_new_account_page() {
        openAccountPage.navigateToOpenAccount();
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        System.out.println("Navigated to Open New Account page.");
    }

    @And("I select account type as SAVINGS and submit")
    public void i_select_account_type_savings_and_submit() {
        openAccountPage.openNewAccount();
        System.out.println("Selected SAVINGS and clicked Open New Account.");
    }

    @Then("I should see the account created success message")
    public void i_should_see_account_created_success_message() {
        try { Thread.sleep(3000); } catch (InterruptedException e) {}
        WebElement successMsg = BaseClass.driver.findElement(
            By.xpath("//h1[contains(text(),'Account Opened!')]"));
        Assert.assertTrue(successMsg.isDisplayed(),
            "Account Opened! message not displayed.");
        System.out.println("New account opened successfully!");
    }
}