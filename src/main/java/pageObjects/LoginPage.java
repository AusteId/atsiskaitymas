package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name ='username']")
    private WebElement inputUsername;

    @FindBy(xpath = "//input[@name ='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//p[contains(@class, 'oxd-text')]")
    private WebElement username;

    @FindBy(css = "p:last-child")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonLogin;

    public void setInputPassword() {
        inputPassword.sendKeys(getPassword());
    }

    public void setInputUsername() {
        inputUsername.sendKeys(getUsername());
    }

    public String getUsername() {

        String usernameField = username.getText().trim();
        String userName = usernameField.substring(usernameField.lastIndexOf(" ") + 1);

        return userName;
    }

    public String getPassword() {
        String passwordField = password.getText().trim();
        String password = passwordField.substring(passwordField.lastIndexOf(" ") + 1);

        return password;

    }

    public void clickButtonLogin() {
        buttonLogin.click();
    }


}
