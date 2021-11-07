package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.CookieHelper;
import helpers.DriverSettings;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import helpers.Attach;

public class BaseTest {

    @BeforeAll
    static void setup() {
        DriverSettings.configure();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        CookieHelper.getAuthCookie();
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }
}