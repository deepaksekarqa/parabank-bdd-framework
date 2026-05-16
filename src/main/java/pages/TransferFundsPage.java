package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import base.BaseClass;

public class TransferFundsPage {

    // Locators
    By transferFundsLink = By.linkText("Transfer Funds");
    By amountField = By.id("amount");
    By fromAccountDropdown = By.id("fromAccountId");
    By toAccountDropdown = By.id("toAccountId");
    By transferButton = By.xpath("//input[@value='Transfer']");
    By successMessage = By.xpath("//*[contains(text(),'Transfer Complete')]");

    // Step 1: Navigate
    public void navigateToTransfer() {

        BaseClass.driver.findElement(transferFundsLink).click();

        System.out.println("Navigated to Transfer Funds Page");
    }

    // Step 2: Perform Transfer
    public void transferFunds() {

        try {
            Thread.sleep(3000); // wait for dropdown to load
        } catch (Exception e) {}

        BaseClass.driver.findElement(amountField).sendKeys("100");

        Select fromAcc = new Select(BaseClass.driver.findElement(fromAccountDropdown));
        fromAcc.selectByIndex(0);

        Select toAcc = new Select(BaseClass.driver.findElement(toAccountDropdown));
        toAcc.selectByIndex(1);

        BaseClass.driver.findElement(transferButton).click();

        System.out.println("Transfer Initiated");
    }

    // Step 3: Verify
    public void verifyTransfer() {

        try {

            Thread.sleep(2000);

            boolean status = BaseClass.driver.findElement(successMessage).isDisplayed();

            if (status) {
                System.out.println("Transfer Completed Successfully");
            } else {
                System.out.println("Transfer Failed");
            }

        } catch (Exception e) {
            System.out.println("Transfer Failed - Element Not Found");
        }
    }
}