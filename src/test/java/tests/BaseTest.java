package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import enums.Endpoint;
import helpers.DriverSettings;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import helpers.Attach;
import org.openqa.selenium.Cookie;
import pages.user.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static config.Credentials.credentials;

public class BaseTest {
    private static Cookie cookie;

    @BeforeAll
    static void setup() {
        DriverSettings.configure();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        cookie = getAuthCookie();
    }

    public static Cookie getAuthCookie() {
        LoginPage loginPage;
        String email = credentials.loginEmail();
        String password = credentials.loginPassword();
        loginPage = open(Endpoint.LOGIN.getPath(), LoginPage.class);
        loginPage
                .enterEmail(email)
                .enterPassword(password)
                .unsetRememberMeCheckbox()
                .clickLogin();
        return (getWebDriver().manage().getCookieNamed("PHPSESSID"));
    }

    public static void cleanCookies() {
        open(credentials.faviconURL());
        getWebDriver().manage().deleteAllCookies();
    }

    public static void setCookie() {
        getWebDriver().manage().addCookie(cookie);
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }
}