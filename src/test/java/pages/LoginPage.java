package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By loginButtonSelector = By.cssSelector("li.-g-user-icon > a > span");
    private final By emailFieldSelector = By.cssSelector("#_loginEmail");
    private final By passwordFieldSelector = By.cssSelector("#_loginPassword");
    private final By submitLoginButtonSelector = By.cssSelector("#doLogin");
    private final By errorMessageSelector = By.cssSelector("#register-page > div > div.old-client-section.col-sm-5.pull-right > div > div.register-form > form > div.errorMsg");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void goTo(String url) {
        this.goTo(url);
    }

    public void clickLoginButton() {
        clickElement(loginButtonSelector);
    }

    public void fillLoginForm(String email, String password) {
        enterText(emailFieldSelector, email);
        enterText(passwordFieldSelector, password);
    }

    public void clickLogin_Button() {
        clickElement(submitLoginButtonSelector);
    }

    public boolean isErrorMessageDisplayed() {
        return !driver.findElements(errorMessageSelector).isEmpty();
    }
}
