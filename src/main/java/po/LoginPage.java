package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://foodguru.mk/");
    }

    public boolean isLoaded() throws InterruptedException {
        Thread.sleep(5000);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user_email"))).isDisplayed();

    }

    public void login(String user, String password) throws InterruptedException {
        driver.findElement(By.name("user_email")).clear();
        driver.findElement(By.name("user_email")).sendKeys(user);
        Thread.sleep(5000);
        driver.findElement(By.name("user_password")).sendKeys(password);
        Thread.sleep(5000);
        driver.findElement(By.name("submit_login")).click();
        Thread.sleep(5000);


    }


    public String getErrorMessage() {
        WebElement errorPage = driver.findElement(By.id("error_msg"));
        return errorPage.getText();
    }
}

