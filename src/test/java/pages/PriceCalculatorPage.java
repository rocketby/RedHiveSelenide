package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class PriceCalculatorPage {


    @Step("Check that page real price calculator is opened")
    public PriceCalculatorPage shouldOpenPriceCalculatorPage() {
        $(byText("Card real price calculator.")).shouldBe(visible);
        return this;
    }

    @Step("Check that alert to login is displayed")
    public PriceCalculatorPage shouldDisplayLoginAlert() {
        $(withText("log in")).shouldBe(visible);
        return this;
    }

    @Step("Check that alert to login is not displayed")
    public PriceCalculatorPage shouldNotDisplayLoginAlert() {
        $(withText("log in")).shouldNotBe(visible);
        return this;
    }
}