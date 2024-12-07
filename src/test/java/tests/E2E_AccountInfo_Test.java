package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.AccountPage;
import pages.LoginPage;

class E2E_AccountInfo_Test extends BaseTest {
    private LoginPage loginPage;
    private AccountPage accountPage;

    @BeforeEach
    void testSetup() {
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
    }

    @ParameterizedTest
    @MethodSource("data.LoginDataProvider#validLoginData")
    void testEditAccountInformation(String loginEmail, String loginPassword) {
        loginPage.goTo();
        loginPage.clickLoginButton();
        loginPage.fillLoginForm(loginEmail, loginPassword);
        loginPage.clickLogin_Button();

        accountPage.clickEditButton();
        accountPage.updateName("Bratislava");
        accountPage.clickSaveButton();
    }
}
