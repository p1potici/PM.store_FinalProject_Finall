package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FavoritesPage extends BasePage {

    private final By accountMenuSelector = By.cssSelector("#wrapper > header > div.top-head-bg.container-h.full > div > div > div.col-md-5.col-sm-5.acount-section > ul > li.-g-user-icon.-g-user-loggedin-icon > a");
    private final By favoritesSectionSelector = By.cssSelector("#wrapper > div.account-h.container-h.container-bg > div > div.side-menu.col-lg-3.col-md-3.col-sm-12.col-xs-12 > div.row > ul.col-md-12.col-xs-4.-g-customer-account-order > li:nth-child(5) > a");
    private final By logoutButtonSelector = By.cssSelector("#wrapper > div.account-h.container-h.container-bg > div > div.side-menu.col-lg-3.col-md-3.col-sm-12.col-xs-12 > div.row > ul:nth-child(5) > li > a");
    private final By historySectionSelector = By.cssSelector("#wrapper > div.account-h.container-h.container-bg > div > div.side-menu.col-lg-3.col-md-3.col-sm-12.col-xs-12 > div.row > ul.col-md-12.col-xs-4.-g-customer-account-order > li:nth-child(3) > a");
    public FavoritesPage(WebDriver driver) {
        super(driver);
    }

    public void goToAccount() {
        clickElement(accountMenuSelector);
    }

    public void goToFavorites() {
        clickElement(favoritesSectionSelector);
    }

    public void goToHistory() {
        clickElement(accountMenuSelector);
        waitFor(1000); // Short wait for the account menu to load
        clickElement(historySectionSelector);
    }


    public void logOffFromAccount() {
        clickElement(logoutButtonSelector);
    }
}
