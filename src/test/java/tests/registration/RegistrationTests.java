package tests.registration;

import allure.JiraIssue;
import allure.Layer;
import allure.Lead;
import allure.Microservice;
import com.codeborne.selenide.Selenide;
import enums.Endpoint;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import pages.user.RegistrationPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tests.BaseTest;

import static helpers.CookieHelper.cleanCookies;

@Owner("tat")
@Layer("web")
@Lead("alex")
@Microservice("registration")
@Feature("registration")
@DisplayName("Verify registration with wrong format of email")
public class RegistrationTests extends BaseTest {
    private RegistrationPage registrationPage;

    @BeforeEach
    @DisplayName("Open registration page")
    void setUpBeforeEach() {
        cleanCookies();
        registrationPage = Selenide.open(Endpoint.REGISTRATION.getPath(), RegistrationPage.class);
    }

    @ParameterizedTest(name = "Unsuccessful registration (fill wrong email: {0})")
    @AllureId("5678")
    @ValueSource(strings = {"test", "test@", "test.com", "test@.com", "test@tt.11", "@gmail.com"})
    @JiraIssue("HOMEWORK-257")
    @Tags({@Tag("web"), @Tag("negative")})
    @DisplayName("Login attempts with bad format of email")
    void unsuccessfulRegistrationTest(String wrongEmail) {
        String password = "test123456";
        registrationPage
                .enterEmail(wrongEmail)
                .enterPassword(password)
                .markCheckboxAgreeWithTerms()
                .clickRegister()
                .shouldDisplayRegistrationPage();
    }
}
