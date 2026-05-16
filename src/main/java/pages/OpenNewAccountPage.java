package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import base.BaseClass;

public class OpenNewAccountPage {

    // Locators
    By openNewAccountLink = By.linkText("Open New Account");
    By accountTypeDropdown = By.id("type");
    By openAccountButton = By.xpath("//input[@value='Open New Account']");
    By successMessage = By.xpath("//h1[contains(text(),'Account Opened!')]");

    // Step 1: Navigate
    public void navigateToOpenAccount() {

        BaseClass.driver.findElement(openNewAccountLink).click();

        System.out.println("Navigated to Open New Account Page");
    }

    // Step 2: Open Account
    public void openNewAccount() {

        Select select = new Select(BaseClass.driver.findElement(accountTypeDropdown));
        select.selectByVisibleText("SAVINGS");

        BaseClass.driver.findElement(openAccountButton).click();

        System.out.println("Clicked Open New Account Button");
    }

    // Step 3: Verify
    public void verifyAccountCreated() {

        try {

            Thread.sleep(2000); // wait for page load

            boolean status = BaseClass.driver.findElement(successMessage).isDisplayed();

            if (status) {
                System.out.println("New Account Created Successfully");
            } else {
                System.out.println("Account Creation Failed");
            }

        } catch (Exception e) {
            System.out.println("Account Creation Failed - Element Not Found");
        }
    }
}