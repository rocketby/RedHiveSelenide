package api.tests;

import helpers.DriverSettings;
import org.junit.jupiter.api.BeforeAll;

public class BaseApiTest {
    @BeforeAll
    static void setup() {
        DriverSettings.configure();
    }

}
