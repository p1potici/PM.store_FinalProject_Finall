package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProductPage extends BasePage {

    private final By dropdownMenuSelector = By.cssSelector("#main-menu > div > ul > li.all-product-button.menu-drop > a");
    private final By gamingCategorySelector = By.cssSelector("#main-menu > div > ul > li.all-product-button.menu-drop > div > ul > li:nth-child(8) > a > span");
    private final By addToBasketButtonSelector = By.cssSelector("#category-page > div > div:nth-child(3) > div.product-listing.clearfix > div.row.product > div.product-box.center.col-md-4.col-xs-6.dataProductId.__GomagListingProductBox.-g-product-box-2380.-g-product-box-ajax-complete > div > div.figcaption.list-f > div.bottom-side-box > div.add-list.clearfix > a.btn.btn-cmd.btn-cart.custom.add2cartList.__retargetingAddToCartSelector._addToCartListProduct_2380.-g-product-list-add-cart-2380.-g-product-add-to-cart.-g-no-url > span");
    private final By cartButtonSelector = By.cssSelector("#wrapper > header > div.top-head-bg.container-h.full > div > div > div.col-md-5.col-sm-5.acount-section > ul > li.cart-header-btn.cart > a");
    private final By proceedToCheckoutButtonSelector = By.cssSelector("#shoppingcart > a.btn.btn-cmd.full.fr.-g-order-checkout-button");
    private final By plusButtonSelector = By.cssSelector("#updateCart > div.-g-checkout-summary > div.cart-box.col-sm.clearfix > ul.cart-items.clearfix.order > li > div.qty-h.col-sm-3.col-xs-6 > div.qty-regulator.clearfix.-g-product-qty-regulator-2380 > a.number-up.plus.updateCart.-g-no-url");
    private final By minusButtonSelector = By.cssSelector("#updateCart > div.-g-checkout-summary > div.cart-box.col-sm.clearfix > ul.cart-items.clearfix.order > li > div.qty-h.col-sm-3.col-xs-6 > div.qty-regulator.clearfix.-g-product-qty-regulator-2380 > a.minus.number-down.updateCart.-g-no-url");
    private final By dropdownContentSelector = By.cssSelector("#main-menu > div > ul > li.all-product-button.menu-drop > div");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToGamingCategory() {
        openDropdownMenu(); // Ensures the dropdown is open before navigating
        clickElement(gamingCategorySelector);
        System.out.println("Navigated to Gaming category.");
    }

    public void addToBasket() {
        clickElement(addToBasketButtonSelector);
        System.out.println("Product added to basket.");
        waitFor(2000); // Wait for 2 seconds after adding the product to the basket, allowing the UI to update
    }

    public void openCart() {
        clickElement(cartButtonSelector);
        System.out.println("Cart opened.");
    }

    public void proceedToCheckout() {
        clickElement(proceedToCheckoutButtonSelector);
        System.out.println("Proceeded to checkout.");
    }

    public void adjustQuantityInBasket() {
        clickElement(plusButtonSelector);
        System.out.println("Increased quantity by 1.");
        waitFor(1000); // Wait for 1 second after increasing quantity
        clickElement(minusButtonSelector);
        System.out.println("Decreased quantity by 1.");
        waitFor(1000); // Wait for 1 second after decreasing quantity
    }

    // Hover over the dropdown menu
    public void openDropdownMenu() {
        WebElement menuButton = driver.findElement(dropdownMenuSelector);
        Actions actions = new Actions(driver);
        actions.moveToElement(menuButton).perform();
        System.out.println("Hovered over the dropdown menu.");
    }

    // Move the mouse away from the dropdown menu
    public void moveMouseAway() {
        Actions actions = new Actions(driver);
        actions.moveByOffset(0, 0).perform();
        System.out.println("Moved the mouse away from the dropdown menu.");
    }

    // Check if the dropdown menu is visible
    public boolean isDropdownVisible() {
        WebElement dropdownContent = driver.findElement(dropdownContentSelector);
        return dropdownContent.isDisplayed();
    }
}
