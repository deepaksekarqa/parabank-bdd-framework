package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.RegisterPage;

public class LogoutSteps {

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    LogoutPage logoutPage = new LogoutPage();

    @Given("I am logged in with a registered user for logout")
    public void i_am_logged_in_with_a_registered_user_for_logout() {
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

        System.out.println("Logged in for Logout test. User: " + BaseClass.username);
    }

    @When("I click the logout link")
    public void i_click_the_logout_link() {
        logoutPage.logout();
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        System.out.println("Logout link clicked.");
    }

    @Then("I should be returned to the login page")
    public void i_should_be_returned_to_the_login_page() {
        WebElement loginButton = BaseClass.driver.findElement(
            By.xpath("//input[@value='Log In']"));
        Assert.assertTrue(loginButton.isDisplayed(),
            "Login button not visible — logout may have failed.");
        System.out.println("Logout successful — Login page confirmed.");
    }
}