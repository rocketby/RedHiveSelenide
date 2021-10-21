package config;

import org.aeonbits.owner.ConfigFactory;

public class Credentials {
    public static RedHiveConfig credentials = ConfigFactory.create(RedHiveConfig.class);
}
