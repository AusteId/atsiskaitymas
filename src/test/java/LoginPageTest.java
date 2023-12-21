
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import pageObjects.AccountPage;
import pageObjects.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;


import java.time.Duration;

public class LoginPageTest extends BaseTest {

    LoginPage loginPage;
    AccountPage accountPage;
    Wait<WebDriver> wait;

    @Test
    void userCanLoginWithGivenDate() {

        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);

        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofMillis(300)).ignoring(Exception.class);

        wait.until(a -> driver.findElement(By.xpath("//input[@name='username']")).isDisplayed());

        loginPage.setInputUsername();
        loginPage.setInputPassword();

        loginPage.clickButtonLogin();

        String expectedLoginIsSuccessful = "My Info";

        wait.until(a -> driver.findElement(By.xpath("//span[text()='My Info']")).isDisplayed());
        String actualLoginIsSuccessful = accountPage.getMyInfo();

        assertThat(actualLoginIsSuccessful).isEqualTo(expectedLoginIsSuccessful);


    }
}
