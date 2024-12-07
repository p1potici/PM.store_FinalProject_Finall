package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.LoginPage;
import pages.SearchPage;
import pages.FavoritesPage;

public class E2E_FavoritesTest extends BaseTest {

    private LoginPage loginPage;
    private SearchPage searchPage;
    private FavoritesPage favoritesPage;

    @BeforeEach
    void testSetup() {
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);
        favoritesPage = new FavoritesPage(driver);
    }

    @ParameterizedTest
    @MethodSource("data.LoginDataProvider#validLoginData")
    public void testFavoriteProductFlow(String loginEmail, String loginPassword) {
        loginPage.goTo();
        System.out.println("Navigated to the homepage.");
        loginPage.clickLoginButton();
        System.out.println("Navigated to the login page.");
        loginPage.fillLoginForm(loginEmail, loginPassword);
        loginPage.clickLogin_Button();
        System.out.println("Successfully logged in.");

        searchPage.searchForItem("Razer");
        System.out.println("Searched for 'Razer'.");
        searchPage.addFirstProductToFavorites();
        System.out.println("Added the first product from search results to favorites.");

        favoritesPage.goToAccount();
        System.out.println("Navigated to the account section.");
        favoritesPage.goToFavorites();
        System.out.println("Navigated to the favorites section.");
        favoritesPage.logOffFromAccount();
        System.out.println("Successfully logged off.");
    }
}
