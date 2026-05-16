package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.BillPayPage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class BillPaySteps {

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    BillPayPage billPayPage = new BillPayPage();

    @Given("I am logged in with a registered user for bill pay")
    public void i_am_logged_in_with_a_registered_user_for_bill_pay() {
        // Register
        homePage.clickRegister();
        registerPage.enterUserDetails();
        registerPage.clickRegister();

        try { Thread.sleep(2000); } catch (InterruptedException e) {}

        // Logout — ParaBank auto-logs in after register
        BaseClass.driver.get("https://parabank.parasoft.com/parabank/logout.htm");
        try { Thread.sleep(1500); } catch (InterruptedException e) {}

        // Login
        loginPage.login();
        try { Thread.sleep(2000); } catch (InterruptedException e) {}

        System.out.println("Logged in for Bill Pay. User: " + BaseClass.username);
    }

    @When("I navigate to the Bill Pay page")
    public void i_navigate_to_the_bill_pay_page() {
        billPayPage.navigateToBillPay();
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        System.out.println("Navigated to Bill Pay page.");
    }

    @And("I enter the payee details and submit payment")
    public void i_enter_the_payee_details_and_submit_payment() {
        billPayPage.enterBillDetails();
        billPayPage.submitPayment();
        System.out.println("Bill details entered and payment submitted.");
    }

    @Then("I should see the bill payment complete message")
    public void i_should_see_bill_payment_complete_message() {
        try { Thread.sleep(3000); } catch (InterruptedException e) {}
        WebElement successMsg = BaseClass.driver.findElement(
            By.xpath("//h1[contains(text(),'Bill Payment Complete')]"));
        Assert.assertTrue(successMsg.isDisplayed(),
            "Bill Payment Complete message not displayed.");
        System.out.println("Bill payment completed successfully!");
    }
}