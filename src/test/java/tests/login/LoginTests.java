package tests.login;

import allure.JiraIssue;
import allure.Layer;
import allure.Microservice;

import enums.Endpoint;
import enums.LoginField;
import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import pages.LoginPage;
import pages.UserAccountPage;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static config.Credentials.credentials;

@Owner("tat")
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
        open(credentials.faviconURL());
        getWebDriver().manage().deleteAllCookies();
        loginPage = open(Endpoint.LOGIN.getPath(), LoginPage.class);
    }


    @Test
    @AllureId("5690")
    @JiraIssue("HOMEWORK-257")
    @Tags({@Tag("web"), @Tag("positive")})
    @DisplayName("Successful login")
    public void checkSuccessfulLogin() {
        loginPage
                .fillField(LoginField.EMAIL, email)
                .fillField(LoginField.PASSWORD, password)
                .setRememberMeCheckbox()
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
                .fillField(LoginField.EMAIL, email)
                .fillField(LoginField.PASSWORD, wrongPassword)
                .setRememberMeCheckbox()
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
        String fieldAttributeRequired = "true";
        loginPage
                .fillField(LoginField.PASSWORD, password)
                .clickLogin();

        loginPage.fieldShouldHaveExpectedAttribute(LoginField.EMAIL, fieldAttributeRequired);
        loginPage.loginPageShouldBeDisplayed();
    }

    @Test
    @AllureId("5689")
    @JiraIssue("HOMEWORK-257")
    @Tags({@Tag("web"), @Tag("negative")})
    @DisplayName("Unsuccessful login (password is not entered)")
    public void checkLoginWithNotEnteredPassword() {
        String fieldAttributeRequired = "true";
        loginPage
                .fillField(LoginField.EMAIL, email)
                .clickLogin();

        loginPage.fieldShouldHaveExpectedAttribute(LoginField.PASSWORD, fieldAttributeRequired);
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
                .fillField(LoginField.EMAIL, emailNotRegistered)
                .fillField(LoginField.PASSWORD, password)
                .clickLogin();

        loginPage.alertShouldBeVisible();
        loginPage.loginPageShouldBeDisplayed();

    }

}
