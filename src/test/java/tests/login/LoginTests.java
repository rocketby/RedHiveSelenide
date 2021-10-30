package tests.login;

import allure.JiraIssue;
import allure.Layer;
import allure.Lead;
import allure.Microservice;

import enums.Endpoint;
import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import pages.user.LoginPage;
import pages.user.UserAccountPage;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.open;
import static config.Credentials.credentials;

@Owner("tat")
@Lead("alex")
@Layer("web")
@Microservice("login")
@DisplayName("Verify login")
public class LoginTests extends BaseTest {
    private LoginPage loginPage;
    String email = credentials.loginEmail();
    String password = credentials.loginPassword();

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
    public void checkSuccessfulLogin() {
        loginPage
                .enterEmail(email)
                .enterPassword(password)
                .unsetRememberMeCheckbox()
                .clickLogin();
        // System.out.println(getWebDriver().manage().getCookies());
        UserAccountPage userAccountPage = new UserAccountPage();
        userAccountPage.avatarOfLoggedUserShouldBeVisible();
    }

    @Test
    @AllureId("5685")
    @JiraIssue("HOMEWORK-257")
    @Tags({@Tag("web"), @Tag("negative")})
    @DisplayName("Unsuccessful login (wrong password is entered)")
    public void checkLoginWithWrongPassword() {
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
    public void checkLoginWithNotEnteredEmail() {
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
    public void checkLoginWithNotEnteredPassword() {
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
    public void checkLoginWithNotRegisteredMail() {
        String emailNotRegistered = "ee@ee.ee";
        loginPage
                .enterEmail(emailNotRegistered)
                .enterPassword(password)
                .clickLogin();

        loginPage.alertShouldBeVisible();
        loginPage.loginPageShouldBeDisplayed();

    }

}
