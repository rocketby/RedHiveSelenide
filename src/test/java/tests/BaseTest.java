package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import enums.Endpoint;
import helpers.DriverSettings;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import helpers.Attach;
import pages.user.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static config.Credentials.credentials;


public class BaseTest {
    @BeforeAll
    static void setup() {
        DriverSettings.configure();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    }

    public static void cleanCookies(){
        open(credentials.faviconURL());
        getWebDriver().manage().deleteAllCookies();
    }

    public static void login() {
        LoginPage loginPage;
        String email = credentials.loginEmail();
        String password = credentials.loginPassword();
        loginPage = open(Endpoint.LOGIN.getPath(), LoginPage.class);
        loginPage
                .enterEmail(email)
                .enterPassword(password)
                .unsetRememberMeCheckbox()
                .clickLogin();
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }
}