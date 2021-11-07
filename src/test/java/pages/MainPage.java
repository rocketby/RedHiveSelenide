package pages;

import enums.MenuItem;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final String menuOptionLink = "a[href$='%s']";

    @Step("Click {item} in main menu")
    public MainPage clickMenuOption(MenuItem item) {
        $(String.format(menuOptionLink, item.getLink())).click();
        return this;
    }
}
