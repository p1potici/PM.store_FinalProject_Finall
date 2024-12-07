package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {

    private final By editButtonSelector = By.cssSelector("#wrapper > div.account-h.container-h.container-bg > div > div.side-menu.col-lg-3.col-md-3.col-sm-12.col-xs-12 > div.row > ul:nth-child(4) > li:nth-child(2) > a");
    private final By nameFieldSelector = By.cssSelector("#wrapper > div.account-h.container-h.container-bg > div > div.account-section.clearfix.col-sm-12.col-xs-12.col-lg-9.col-md-9 > form > div:nth-child(2) > input");
    private final By saveButtonSelector = By.cssSelector("#doSave");
    private final By changePasswordSectionSelector = By.cssSelector("#wrapper > div.account-h.container-h.container-bg > div > div.side-menu.col-lg-3.col-md-3.col-sm-12.col-xs-12 > div.row > ul:nth-child(4) > li:nth-child(3) > a");


    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void clickEditButton() {
        clickElement(editButtonSelector);
    }

    public void updateName(String newName) {
        enterText(nameFieldSelector, newName);
    }

    public void clickSaveButton() {
        clickElement(saveButtonSelector);
    }

    public void goToChangePassword() {
        clickElement(changePasswordSectionSelector);
    }
}
