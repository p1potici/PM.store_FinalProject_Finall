package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.AccountPage;
import pages.ChangePasswordPage;
import pages.FavoritesPage;

public class E2E_ChangePasswordTest extends BaseTest {

    private LoginPage loginPage;
    private AccountPage accountPage;
    private ChangePasswordPage changePasswordPage;
    private FavoritesPage favoritesPage;

    @BeforeEach
    void testSetup() {
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        changePasswordPage = new ChangePasswordPage(driver);
        favoritesPage = new FavoritesPage(driver);
    }

    @Test
    public void testChangePasswordFlow() {

        loginPage.goTo();
        System.out.println("Navigated to the homepage.");
        loginPage.clickLoginButton();
        System.out.println("Navigated to the login page.");
        loginPage.fillLoginForm("John.Doee@example.com", "Test123!");
        loginPage.clickLogin_Button();
        System.out.println("Successfully logged in with the old password.");

        accountPage.goToChangePassword();
        System.out.println("Navigated to the change password section.");

        changePasswordPage.enterOldPassword("Test123!");
        changePasswordPage.enterNewPassword("Test123!");
        changePasswordPage.enterConfirmPassword("Test123!");
        changePasswordPage.clickChangePasswordButton();
        System.out.println("Password successfully changed.");

        favoritesPage.logOffFromAccount();
        System.out.println("Successfully logged off.");

        loginPage.clickLoginButton();
        System.out.println("Navigated to the login page.");
        loginPage.fillLoginForm("John.Doee@example.com", "Test123!");
        loginPage.clickLogin_Button();
        System.out.println("Successfully logged in with the new password.");
    }
}
