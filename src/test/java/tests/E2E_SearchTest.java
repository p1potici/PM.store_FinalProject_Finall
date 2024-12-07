package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.LoginPage;
import pages.SearchPage;
import pages.LoggOffPage;

public class E2E_SearchTest extends BaseTest {

    private LoginPage loginPage;
    private SearchPage searchPage;
    private LoggOffPage loggOffPage;

    @BeforeEach
    void testSetup() {
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);
        loggOffPage = new LoggOffPage(driver);
    }

    @ParameterizedTest
    @MethodSource("data.LoginDataProvider#validLoginData")
    public void testSearchFunctionality(String loginEmail, String loginPassword) {
        logIn(loginEmail, loginPassword);
        searchPage.performSearchAndValidateResults(); // Encapsulated logic
        logOut();
    }

    private void logIn(String email, String password) {
        loginPage.goTo();
        System.out.println("Navigated to the homepage.");
        loginPage.clickLoginButton();
        System.out.println("Navigated to the login page.");
        loginPage.fillLoginForm(email, password);
        loginPage.clickLogin_Button();
        System.out.println("Successfully logged in.");
    }

    private void logOut() {
        loggOffPage.logOff();
        System.out.println("Successfully logged off.");
    }
}
