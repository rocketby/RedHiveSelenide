package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${runMode}.properties"
})
public interface ProjectConfig extends Config {
    @Key("baseURL")
    String baseURL();

    @Key("faviconURL")
    String faviconURL();

    @Key("loginEmail")
    String loginEmail();

    @Key("loginPassword")
    String loginPassword();

    @Key("urlSelenoid")
    String urlSelenoid();

    @Key("loginSelenoid")
    String loginSelenoid();

    @Key("passwordSelenoid")
    String passwordSelenoid();

    @Key("runMode")
    String runMode();

    @Key("browser")
    String browser();

    @Key("browserVersion")
    String browserVersion();

    @Key("browserSize")
    String browserSize();

    @Key("idAccount")
    String idAccount();

    @Key("consumerKey")
    String consumerKey();

    @Key("consumerSecret")
    String consumerSecret();

    @Key("accessToken")
    String accessToken();

    @Key("secretToken")
    String secretToken();

}
