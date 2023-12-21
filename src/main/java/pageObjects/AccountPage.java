package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

    @FindBy(xpath = "//span[text()='My Info']")
    private WebElement myInfoInMenu;


    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getMyInfo() {

        return myInfoInMenu.getText();

    }
}
