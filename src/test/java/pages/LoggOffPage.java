package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoggOffPage extends BasePage {

    private final By accountMenuSelector = By.cssSelector("#wrapper > header > div.top-head-bg.container-h.full > div > div > div.col-md-5.col-sm-5.acount-section > ul > li.-g-user-icon > a > span");
    private final By logoutButtonSelector = By.cssSelector("#wrapper > div.account-h.container-h.container-bg > div > div.side-menu.col-lg-3.col-md-3.col-sm-12.col-xs-12 > div.row > ul:nth-child(5) > li > a");
    private final By accountMenuSelector2 = By.cssSelector("#wrapper > header > div > div > div > div.col-sm-6.col-xs-12.cart-menu > ul > li.-g-user-icon.-g-user-loggedin-icon > a > span");
    private final By accountSelector2 = By.cssSelector("#wrapper > header > div > div > div > div.col-sm-6.col-xs-12.cart-menu > ul > li.-g-user-icon.-g-user-loggedin-icon > a > span");
    public LoggOffPage(WebDriver driver) {
        super(driver);
    }

    public void logOff() {
        clickElement(accountMenuSelector);
        clickElement(logoutButtonSelector);
    }

    public void logout() {
        clickElement(accountMenuSelector2);
        clickElement(logoutButtonSelector);
    }

    public void logout2() {
        clickElement(accountSelector2);
        clickElement(logoutButtonSelector);
    }
}
