package helpers;

import static config.Credentials.credentials;
import static java.lang.String.format;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverSettings {
    public static void configure() {

        String runModeProperty = System.getProperty("runMode", "local");

        //if need to execute tests in selenoid, then use command:
        //gradle clean test -DrunMode=remote

        //if need to execute tests locally, use command:
        //gradle clean test

        if (runModeProperty.equals("remote")) {
            String loginSelenoid = credentials.loginSelenoid();
            String passwordSelenoid = credentials.passwordSelenoid();

            Configuration.remote = format("https://%s:%s@" + credentials.urlSelenoid(), loginSelenoid, passwordSelenoid);

        } else {
            System.setProperty("runMode", "local");
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browser = credentials.browser();
        Configuration.browserVersion = credentials.browserVersion();
        Configuration.browserSize = credentials.browserSize();
        Configuration.browserCapabilities = capabilities;
        Configuration.startMaximized = true;
        Configuration.baseUrl = credentials.baseURL();

    }
}
