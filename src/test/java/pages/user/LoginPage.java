package pages.user;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    @Step("Set value in field Email")
    public LoginPage enterEmail(String value) {
        $("#inputEmail").setValue(value);
        return this;
    }

    @Step("Set value in field Password")
    public LoginPage enterPassword(String value) {
        $("#inputPassword").setValue(value);
        return this;
    }

    @Step("Unset 'RememberMe' checkbox")
    public LoginPage unsetRememberMeCheckbox() {
        $(byName("_remember_me")).click();
        return this;
    }

    @Step("Click button 'Login' ")
    public LoginPage clickLogin() {
        $("button[type=submit]").click();
        return this;
    }

    @Step("Check, that Email field is mandatory")
    public LoginPage fieldEmailShouldBeMandatory() {
        $("#inputEmail").shouldHave(attribute("required", "true"));
        return this;
    }

    @Step("Check, that Password field is mandatory")
    public LoginPage fieldPasswordShouldBeMandatory() {
        $("#inputPassword").shouldHave(attribute("required", "true"));
        return this;
    }
    @Step("Check, that login page is displayed")
    public LoginPage loginPageShouldBeDisplayed() {
        $("a[href$='login']").shouldBe(visible);
        return this;
    }

    @Step("Check, that Alert is displayed")
    public LoginPage alertShouldBeVisible() {
        $(".alert-danger").shouldBe(visible);
        return this;
    }

}