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
import pages.TransferFundsPage;

public class TransferFundsSteps {

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    OpenNewAccountPage openAccountPage = new OpenNewAccountPage();
    TransferFundsPage transferPage = new TransferFundsPage();

    @Given("I am logged in with a registered user for transfer")
    public void i_am_logged_in_with_a_registered_user_for_transfer() {
        // Register
        homePage.clickRegister();
        registerPage.enterUserDetails();
        registerPage.clickRegister();

        try { Thread.sleep(3000); } catch (InterruptedException e) {}

        // Logout
        BaseClass.driver.get("https://parabank.parasoft.com/parabank/logout.htm");
        try { Thread.sleep(2000); } catch (InterruptedException e) {}

        // Login
        loginPage.login();
        try { Thread.sleep(3000); } catch (InterruptedException e) {}

        // Open a second account — with longer wait for Jenkins
        BaseClass.driver.get("https://parabank.parasoft.com/parabank/openaccount.htm");
        try { Thread.sleep(3000); } catch (InterruptedException e) {}
        openAccountPage.openNewAccount();
        try { Thread.sleep(4000); } catch (InterruptedException e) {}

        System.out.println("Logged in and second account created. User: " + BaseClass.username);
    }

    @When("I navigate to the Transfer Funds page")
    public void i_navigate_to_transfer_funds_page() {
        transferPage.navigateToTransfer();
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        System.out.println("Navigated to Transfer Funds page.");
    }

    @And("I enter transfer amount and select accounts")
    public void i_enter_transfer_amount_and_select_accounts() {
        transferPage.transferFunds();
        System.out.println("Transfer amount entered and accounts selected.");
    }

    @Then("I should see the transfer complete success message")
    public void i_should_see_transfer_complete_success_message() {
        try { Thread.sleep(3000); } catch (InterruptedException e) {}
        WebElement successMsg = BaseClass.driver.findElement(
            By.xpath("//*[contains(text(),'Transfer Complete')]"));
        Assert.assertTrue(successMsg.isDisplayed(),
            "Transfer Complete message not displayed.");
        System.out.println("Transfer completed successfully!");
    }
}