package pages;

import enums.LoginField;
import enums.MenuItem;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final String idCssPattern = "a[href$='%s']";

    @Step("Click {} in main menu")
    public MainPage clickMenuOption(MenuItem item) {
        $(String.format(idCssPattern, item.getLink())).click();
        return this;
    }
}
