package tests.login;

import allure.JiraIssue;
import allure.Layer;
import allure.Lead;
import allure.Microservice;

import enums.Endpoint;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import pages.user.LoginPage;
import pages.user.UserAccountPage;
import tests.BaseTest;
import static com.codeborne.selenide.Selenide.open;
import static config.Credentials.credentials;
import static helpers.CookieHelper.cleanCookies;

@Owner("tat")
@Lead("alex")
@Layer("web")
@Microservice("login")
@Feature("login")
@DisplayName("Verify login")
public class LoginTests extends BaseTest {
    private LoginPage loginPage;
    private String email = credentials.loginEmail();
    private String password = credentials.loginPassword();

    @BeforeEach
    @DisplayName("Open login page")
    void setUpBeforeEach() {
        cleanCookies();
        loginPage = open(Endpoint.LOGIN.getPath(), LoginPage.class);
    }

    @Test
    @AllureId("5690")
    @JiraIssue("HOMEWORK-257")
    @Tags({@Tag("web"), @Tag("positive")})
    @DisplayName("Successful login")
    public void successfulLoginTest() {
        loginPage
                .enterEmail(email)
                .enterPassword(password)
                .unsetRememberMeCheckbox()
                .clickLogin();
        UserAccountPage userAccountPage = new UserAccountPage();
        userAccountPage.avatarOfLoggedUserShouldBeVisible();
    }

    @Test
    @AllureId("5685")
    @JiraIssue("HOMEWORK-257")
    @Tags({@Tag("web"), @Tag("negative")})
    @DisplayName("Unsuccessful login (wrong password is entered)")
    public void loginWithWrongPasswordTest() {
        String wrongPassword = "badPassword";

        loginPage
                .enterEmail(email)
                .enterPassword(wrongPassword)
                .unsetRememberMeCheckbox()
                .clickLogin();
        loginPage.alertShouldBeVisible();
        loginPage.loginPageShouldBeDisplayed();
    }

    @Test
    @AllureId("5683")
    @JiraIssue("HOMEWORK-257")
    @Tags({@Tag("web"), @Tag("negative")})
    @DisplayName("Unsuccessful login (email is not entered)")
    public void loginWithNotEnteredEmailTest() {
        loginPage
                .enterPassword(password)
                .clickLogin();

        loginPage.fieldEmailShouldBeMandatory();
        loginPage.loginPageShouldBeDisplayed();
    }

    @Test
    @AllureId("5689")
    @JiraIssue("HOMEWORK-257")
    @Tags({@Tag("web"), @Tag("negative")})
    @DisplayName("Unsuccessful login (password is not entered)")
    public void loginWithNotEnteredPasswordTest() {
        loginPage
                .enterEmail(email)
                .clickLogin();

        loginPage.fieldPasswordShouldBeMandatory();
        loginPage.loginPageShouldBeDisplayed();
    }

    @Test
    @AllureId("5679")
    @JiraIssue("HOMEWORK-257")
    @Tags({@Tag("web"), @Tag("negative")})
    @DisplayName("Unsuccessful login (password is not entered)")
    public void loginWithNotRegisteredMailTest() {
        String emailNotRegistered = "ee@ee.ee";
        loginPage
                .enterEmail(emailNotRegistered)
                .enterPassword(password)
                .clickLogin();

        loginPage.alertShouldBeVisible();
        loginPage.loginPageShouldBeDisplayed();

    }
}
