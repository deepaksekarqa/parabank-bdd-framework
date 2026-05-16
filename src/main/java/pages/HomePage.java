package pages;

import org.openqa.selenium.By;
import base.BaseClass;

public class HomePage {

    // Locator
    By registerLink = By.linkText("Register");

    // Action Method
    public void clickRegister() {

        BaseClass.driver.findElement(registerLink).click();

        System.out.println("Clicked on Register Link");
    }
}
