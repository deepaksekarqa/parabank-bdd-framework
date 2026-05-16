package pages;

import org.openqa.selenium.By;
import base.BaseClass;

public class LogoutPage {

    // Locators
    By logoutLink = By.linkText("Log Out");
    By loginButton = By.xpath("//input[@value='Log In']");

    // Step 1: Logout
    public void logout() {

        BaseClass.driver.findElement(logoutLink).click();

        System.out.println("Clicked Logout");
    }

    // Step 2: Verify
    public void verifyLogout() {

        try {

            Thread.sleep(2000);

            boolean status = BaseClass.driver.findElement(loginButton).isDisplayed();

            if (status) {
                System.out.println("Logout Successful - Returned to Login Page");
            } else {
                System.out.println("Logout Failed");
            }

        } catch (Exception e) {
            System.out.println("Logout Failed - Element Not Found");
        }
    }
}