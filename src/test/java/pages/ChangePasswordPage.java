package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePasswordPage extends BasePage {

    private final By oldPasswordInput = By.cssSelector("#wrapper > div.account-h.container-h.container-bg > div > div.account-section.clearfix.col-sm-12.col-xs-12.col-lg-9.col-md-9 > form > div:nth-child(1) > input");
    private final By newPasswordInput = By.cssSelector("#__newPassword");
    private final By confirmPasswordInput = By.cssSelector("#wrapper > div.account-h.container-h.container-bg > div > div.account-section.clearfix.col-sm-12.col-xs-12.col-lg-9.col-md-9 > form > div:nth-child(3) > input");
    private final By changePasswordButton = By.cssSelector("#doSave");

    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    public void enterOldPassword(String oldPassword) {
        enterText(oldPasswordInput, oldPassword);
        System.out.println("Entered old password.");
    }

    public void enterNewPassword(String newPassword) {
        enterText(newPasswordInput, newPassword);
        System.out.println("Entered new password.");
    }

    public void enterConfirmPassword(String newPassword) {
        enterText(confirmPasswordInput, newPassword);
        System.out.println("Confirmed new password.");
    }

    public void clickChangePasswordButton() {
        clickElement(changePasswordButton);
        System.out.println("Clicked the change password button.");
    }
}
