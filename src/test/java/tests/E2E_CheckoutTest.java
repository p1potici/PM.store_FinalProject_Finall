package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;
import pages.LoggOffPage;

/**
 * End-to-end test for filling out the checkout form and logging off.
 */
class E2E_CheckoutTest extends BaseTest {
    private LoginPage loginPage;
    private ProductPage productPage;
    private CheckoutPage checkoutPage;
    private LoggOffPage loggOffPage;

    @BeforeEach
    public void testSetup() {
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        checkoutPage = new CheckoutPage(driver);
        loggOffPage = new LoggOffPage(driver);
    }

    @ParameterizedTest
    @MethodSource("data.CheckoutDataProvider#validCheckoutData")
    void testCheckoutFormAndLogOff(String email, String lastName, String firstName, String phone, String county, String city, String address) {

        loginPage.goTo();
        loginPage.clickLoginButton();
        loginPage.fillLoginForm(email, "Test123!");
        loginPage.clickLogin_Button();
        System.out.println("Logged in successfully.");

        productPage.openDropdownMenu();
        productPage.navigateToGamingCategory();
        productPage.addToBasket();
        System.out.println("Added product to basket.");
        productPage.openCart();
        productPage.waitFor(2000); // Wait between adding to cart and proceeding to checkout
        productPage.proceedToCheckout();
        System.out.println("Proceeded to checkout.");

        checkoutPage.fillContactInformation(email, lastName, firstName, phone);
        checkoutPage.fillDeliveryInformation(county, city, address);
        checkoutPage.agreeToPolicy();
        System.out.println("Filled out the checkout form.");

        loggOffPage.logout2();
        System.out.println("User logged off via LogOffPage.");
    }



}
