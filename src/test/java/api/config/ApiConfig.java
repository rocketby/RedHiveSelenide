package api.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:api-config.properties"
})
public interface ApiConfig extends Config {
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
