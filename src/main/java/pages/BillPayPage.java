package pages;

import org.openqa.selenium.By;
import base.BaseClass;

public class BillPayPage {

    // Locators
    By billPayLink = By.linkText("Bill Pay");

    By payeeName = By.name("payee.name");
    By address = By.name("payee.address.street");
    By city = By.name("payee.address.city");
    By state = By.name("payee.address.state");
    By zipCode = By.name("payee.address.zipCode");
    By phone = By.name("payee.phoneNumber");

    By accountNumber = By.name("payee.accountNumber");
    By verifyAccount = By.name("verifyAccount");

    By amount = By.name("amount");

    By sendPaymentButton = By.xpath("//input[@value='Send Payment']");

    By successMessage = By.xpath("//h1[contains(text(),'Bill Payment Complete')]");

    // Step 1: Navigate
    public void navigateToBillPay() {

        BaseClass.driver.findElement(billPayLink).click();

        System.out.println("Navigated to Bill Pay Page");
    }

    // Step 2: Enter Details
    public void enterBillDetails() {

        BaseClass.driver.findElement(payeeName).sendKeys("EB Bill");
        BaseClass.driver.findElement(address).sendKeys("Chennai");
        BaseClass.driver.findElement(city).sendKeys("Chennai");
        BaseClass.driver.findElement(state).sendKeys("Tamil Nadu");
        BaseClass.driver.findElement(zipCode).sendKeys("600001");
        BaseClass.driver.findElement(phone).sendKeys("9876543210");

        BaseClass.driver.findElement(accountNumber).sendKeys("12345");
        BaseClass.driver.findElement(verifyAccount).sendKeys("12345");

        BaseClass.driver.findElement(amount).sendKeys("500");

        System.out.println("Entered Bill Details");
    }

    // Step 3: Submit
    public void submitPayment() {

        BaseClass.driver.findElement(sendPaymentButton).click();

        System.out.println("Payment Submitted");
    }

    // Step 4: Verify
    public void verifyPayment() {

        try {

            Thread.sleep(3000);

            boolean status = BaseClass.driver.findElement(successMessage).isDisplayed();

            if (status) {
                System.out.println("Bill Payment Successful");
            } else {
                System.out.println("Bill Payment Failed");
            }

        } catch (Exception e) {
            System.out.println("Bill Payment Failed - Element Not Found");
        }
    }
}