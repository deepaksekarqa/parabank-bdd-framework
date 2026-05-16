package pages;

import org.openqa.selenium.By;
import base.BaseClass;

public class AccountOverviewPage {

    // Locator
    By accountOverviewText = By.xpath("//h1[contains(text(),'Accounts Overview')]");

    // Validation Method
    public void verifyLoginSuccess() {

        try {

            boolean status = BaseClass.driver.findElement(accountOverviewText).isDisplayed();

            if (status) {
                System.out.println("Login Successful - Account Overview Page Displayed");
            } else {
                System.out.println("Login Failed");
            }

        } catch (Exception e) {
            System.out.println("Login Failed - Element Not Found");
        }
    }
}