package helpers;

import enums.Endpoint;
import org.openqa.selenium.Cookie;
import pages.user.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static config.Credentials.credentials;

public class CookieHelper {
    private static Cookie cookie;

    public static void getAuthCookie() {
        LoginPage loginPage;
        String email = credentials.loginEmail();
        String password = credentials.loginPassword();
        loginPage = open(Endpoint.LOGIN.getPath(), LoginPage.class);
        loginPage
                .enterEmail(email)
                .enterPassword(password)
                .unsetRememberMeCheckbox()
                .clickLogin();
        cookie =  getWebDriver().manage().getCookieNamed("PHPSESSID");
    }

    public static void cleanCookies() {
        open(credentials.faviconURL());
        getWebDriver().manage().deleteAllCookies();
    }

    public static void setCookie() {
        getWebDriver().manage().addCookie(cookie);
    }
}

