package pages;

import org.openqa.selenium.By;
import base.BaseClass;

public class RegisterPage {

    // Locators
    By firstName = By.id("customer.firstName");
    By lastName = By.id("customer.lastName");
    By address = By.id("customer.address.street");
    By city = By.id("customer.address.city");
    By state = By.id("customer.address.state");
    By zipCode = By.id("customer.address.zipCode");
    By phone = By.id("customer.phoneNumber");
    By ssn = By.id("customer.ssn");

    By username = By.id("customer.username");
    By password = By.id("customer.password");
    By confirmPassword = By.id("repeatedPassword");

    By registerButton = By.xpath("//input[@value='Register']");

    // Action - Enter Details
    public void enterUserDetails() {

        BaseClass.driver.findElement(firstName).sendKeys("Deepak");
        BaseClass.driver.findElement(lastName).sendKeys("Sekar");
        BaseClass.driver.findElement(address).sendKeys("Chennai");
        BaseClass.driver.findElement(city).sendKeys("Chennai");
        BaseClass.driver.findElement(state).sendKeys("Tamil Nadu");
        BaseClass.driver.findElement(zipCode).sendKeys("600001");
        BaseClass.driver.findElement(phone).sendKeys("9876543210");
        BaseClass.driver.findElement(ssn).sendKeys("1234");

        // Dynamic Username
        BaseClass.username = "deepak" + System.currentTimeMillis();

        BaseClass.driver.findElement(username).sendKeys(BaseClass.username);
        BaseClass.driver.findElement(password).sendKeys(BaseClass.password);
        BaseClass.driver.findElement(confirmPassword).sendKeys(BaseClass.password);

        System.out.println("Entered Registration Details");
        System.out.println("Generated Username: " + BaseClass.username);
    }

    // Action - Click Register
    public void clickRegister() {

        BaseClass.driver.findElement(registerButton).click();

        System.out.println("Clicked Register Button");
    }
}