package helpers;

import static config.Credentials.credentials;
import static java.lang.String.format;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;


public class DriverSettings {

    public static void configure() {
        String loginSelenoid = credentials.loginSelenoid();
        String passwordSelenoid = credentials.passwordSelenoid();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);


        Configuration.browser = credentials.browser();
        Configuration.browserVersion = credentials.browserVersion();
        Configuration.browserSize = credentials.browserSize();
        Configuration.browserCapabilities = capabilities;
        Configuration.startMaximized = true;
        Configuration.baseUrl = credentials.loginURL();

        //if need to execute tests in selenoid, then use command:
        //gradle clean test -Durl=selenoid.autotests.cloud/wd/hub/ -DrunMode=remote

        //if need to execute tests locally, use command:
        //gradle clean test

        if (System.getProperty("runMode", "local").equals("remote")) {
            Configuration.remote = format("https://%s:%s@" + System.getProperty("url"), loginSelenoid, passwordSelenoid);
        }

    }
}
