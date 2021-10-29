package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:redhive-config.properties"
})
public interface RedHiveConfig extends Config {
    @Key("loginURL")
    String loginURL();

    @Key("faviconURL")
    String faviconURL();

    @Key("loginEmail")
    String loginEmail();

    @Key("loginPassword")
    String loginPassword();

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


}
