package pages;

import org.openqa.selenium.By;
import base.BaseClass;

public class LoginPage {

    // Locators
    By usernameField = By.name("username");
    By passwordField = By.name("password");
    By loginButton = By.xpath("//input[@value='Log In']");

    // Action Method
    public void login() {

        BaseClass.driver.findElement(usernameField).sendKeys(BaseClass.username);
        BaseClass.driver.findElement(passwordField).sendKeys(BaseClass.password);
        BaseClass.driver.findElement(loginButton).click();

        System.out.println("Logged in successfully");
    }
}