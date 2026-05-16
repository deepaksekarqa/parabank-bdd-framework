package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {

    public static WebDriver driver;

    // Shared variables — used across Register → Login flow
    public static String username;
    public static String password = "test123";

    public static void openBrowser() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");       // Run without UI in Jenkins
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        System.out.println("Browser launched and ParaBank opened.");
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed.");
        }
    }
}