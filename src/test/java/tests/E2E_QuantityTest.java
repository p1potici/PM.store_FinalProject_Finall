package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.LoginPage;
import pages.ProductPage;
import pages.LoggOffPage;

class E2E_QuantityTest extends BaseTest {
    private LoginPage loginPage;
    private ProductPage productPage;
    private LoggOffPage logOffPage;

    @BeforeEach
    void testSetup() {
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        logOffPage = new LoggOffPage(driver);
    }

    @ParameterizedTest
    @MethodSource("data.LoginDataProvider#validLoginData")
    void adjustQuantityAndCheckoutTest(String loginEmail, String loginPassword) {
        loginPage.goTo();
        loginPage.clickLoginButton();
        loginPage.fillLoginForm(loginEmail, loginPassword);
        loginPage.clickLogin_Button();

        productPage.navigateToGamingCategory();
        productPage.addToBasket();
        productPage.openCart();
        productPage.adjustQuantityInBasket();

        logOffPage.logout();
    }
}
