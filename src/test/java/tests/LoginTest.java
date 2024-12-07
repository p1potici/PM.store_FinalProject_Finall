package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.*;
import pages.LoginPage;

/**
 * Tests for validating login functionality.
 */
class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeEach
    void testSetup() {
        loginPage = new LoginPage(driver);
    }

    @ParameterizedTest
    @MethodSource("data.LoginDataProvider#validLoginData")
    void testValidLogin(String loginEmail, String loginPassword) {

        loginPage.goTo();
        System.out.println("Navigated to homepage.");
        loginPage.clickLoginButton();
        System.out.println("Clicked login button.");
        loginPage.fillLoginForm(loginEmail, loginPassword);
        System.out.println("Filled login form with valid credentials.");
        loginPage.clickLogin_Button();
        System.out.println("Submitted login form.");
        System.out.println("Test completed: Valid login.");
    }

    @ParameterizedTest
    @MethodSource("data.LoginDataProvider#invalidLoginData")
    void testInvalidLogin(String loginEmail, String loginPassword) {

        loginPage.goTo();
        System.out.println("Navigated to homepage.");
        loginPage.clickLoginButton();
        System.out.println("Clicked login button.");
        loginPage.fillLoginForm(loginEmail, loginPassword);
        System.out.println("Filled login form with invalid credentials.");
        loginPage.clickLogin_Button();
        System.out.println("Submitted login form.");
        boolean isErrorMessageDisplayed = loginPage.isErrorMessageDisplayed();
        Assertions.assertTrue(isErrorMessageDisplayed, "");
        System.out.println("Verified error message for invalid login.");
        System.out.println("Test completed: Invalid login.");
    }
}

