package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.LoginPage;
import pages.ProductPage;
import pages.LoggOffPage;

public class E2E_BasketTest extends BaseTest {
    private LoginPage loginPage;
    private ProductPage productPage;
    private LoggOffPage loggOffPage;

    @BeforeEach
    void testSetup() {
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        loggOffPage = new LoggOffPage(driver);
    }

    @ParameterizedTest
    @MethodSource("data.LoginDataProvider#validLoginData")
    void endToEndFlowTest1(String loginEmail, String loginPassword) {
        loginPage.goTo();
        loginPage.clickLoginButton();
        loginPage.fillLoginForm(loginEmail, loginPassword);
        loginPage.clickLogin_Button();

        productPage.openDropdownMenu();
        productPage.navigateToGamingCategory();
        productPage.addToBasket();
        productPage.openCart();

        loggOffPage.logout();
    }
}
