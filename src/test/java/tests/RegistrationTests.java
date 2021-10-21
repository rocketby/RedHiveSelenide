package tests;

import allure.JiraIssue;
import com.codeborne.selenide.Selenide;
import enums.Endpoint;
import enums.RegistrationField;
import org.junit.jupiter.api.*;
import pages.RegistrationPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.parameter;

public class RegistrationTests extends BaseTest {
    private RegistrationPage registrationPage;

    @BeforeEach
    @DisplayName("Open registration page")
    void setUpBeforeEach() {
        registrationPage = Selenide.open(Endpoint.REGISTRATION.getPath(), RegistrationPage.class);
    }

    @Test
    @ParameterizedTest(name = "Unsuccessful registration (fill wrong email: {0})")
    @ValueSource(strings = {"test", "test@", "test.com", "test@.com", "test@tt.11", "@gmail.com"})
    @JiraIssue("HOMEWORK-257")
    @Tags({@Tag("web"), @Tag("negative")})
    @DisplayName("Login attempts with bad format of email")
    void checkUnsuccessfulRegistration(String wrongEmail) {
        String password = "test123456";
        parameter("Wrong user.getEmail()", wrongEmail);
        registrationPage
                .fillField(RegistrationField.EMAIL, wrongEmail)
                .fillField(RegistrationField.PASSWORD, password)
                .markCheckboxAgreeWithTerms()
                .clickRegister()
                .shouldDisplayRegistrationPage();
    }
}
