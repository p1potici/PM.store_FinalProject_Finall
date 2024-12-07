package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {

    private final By loginButtonSelector = By.cssSelector("li.-g-user-icon > a > span");
    private final By registerButtonSelector = By.cssSelector("#_submitRegistration > div");
    private final By emailFieldSelector = By.cssSelector("#__emailRegister");
    private final By lastNameFieldSelector = By.cssSelector("#__lastnameRegister");
    private final By firstNameFieldSelector = By.cssSelector("#__firstnameRegister");
    private final By passwordFieldSelector = By.cssSelector("#__passwordRegister");
    private final By confirmPasswordFieldSelector = By.cssSelector("#__confirmPasswordRegister");
    private final By agreementCheckboxSelector = By.cssSelector("#_submitRegistration > div > div > p:nth-child(7) > label > div > input");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void goTo(String url) {
        this.goTo(url);
    }

    public void clickLoginButton() {
        clickElement(loginButtonSelector);
    }

    public void clickRegisterButton() {
        clickElement(registerButtonSelector);
    }

    public void fillRegistrationForm(String email, String lastName, String firstName, String password, String confirmPassword) {
        enterText(emailFieldSelector, email);
        enterText(lastNameFieldSelector, lastName);
        enterText(firstNameFieldSelector, firstName);
        enterText(passwordFieldSelector, password);
        enterText(confirmPasswordFieldSelector, confirmPassword);
    }

    public void acceptTermsAndConditions() {
        clickElement(agreementCheckboxSelector);
    }

    public void submitRegistration() {
        clickElement(registerButtonSelector);
    }
}
