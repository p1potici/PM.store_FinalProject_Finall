package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {

    private final By contactEmailSelector = By.cssSelector("#checkoutform > div:nth-child(4) > input");
    private final By contactLastNameSelector = By.cssSelector("#checkoutform > div:nth-child(5) > input");
    private final By contactFirstNameSelector = By.cssSelector("#checkoutform > div:nth-child(6) > input");
    private final By contactPhoneSelector = By.cssSelector("#checkoutform > div:nth-child(7) > input");
    private final By countyDropdownSelector = By.cssSelector("#_shippingRegion");
    private final By cityDropdownSelector = By.cssSelector("#_shippingCity");
    private final By deliveryAddressSelector = By.cssSelector("#_shippingAddressHolder > input.input-s.col-sm-5.col-xs-8.-g-storage");
    private final By agreePolicyCheckboxSelector = By.cssSelector("#checkoutform > div.label-s.col-xs-12.custom-chk > label > div > input");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void fillContactInformation(String email, String lastName, String firstName, String phone) {
        enterText(contactEmailSelector, email);
        enterText(contactLastNameSelector, lastName);
        enterText(contactFirstNameSelector, firstName);
        enterText(contactPhoneSelector, phone);
    }

    public void fillDeliveryInformation(String county, String city, String address) {
        selectDropdownByVisibleText(countyDropdownSelector, county);
        selectDropdownByVisibleText(cityDropdownSelector, city);
        enterText(deliveryAddressSelector, address);
    }

    public void agreeToPolicy() {
        clickElement(agreePolicyCheckboxSelector);
    }
}
