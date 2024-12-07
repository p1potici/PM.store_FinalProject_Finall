package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.LoginPage;
import pages.FavoritesPage;

public class E2E_HistoryTest extends BaseTest {

    private LoginPage loginPage;
    private FavoritesPage favoritesPage;

    @BeforeEach
    void testSetup() {
        loginPage = new LoginPage(driver);
        favoritesPage = new FavoritesPage(driver);
    }

    @ParameterizedTest
    @MethodSource("data.LoginDataProvider#validLoginData")
    public void testHistoryFlow(String loginEmail, String loginPassword) {
        loginPage.goTo();
        System.out.println("Navigated to the homepage.");
        loginPage.clickLoginButton();
        System.out.println("Navigated to the login page.");
        loginPage.fillLoginForm(loginEmail, loginPassword);
        loginPage.clickLogin_Button();
        System.out.println("Successfully logged in.");

        favoritesPage.goToHistory();
        System.out.println("Navigated to the history section.");
        favoritesPage.logOffFromAccount();
        System.out.println("Successfully logged off.");
    }
}
