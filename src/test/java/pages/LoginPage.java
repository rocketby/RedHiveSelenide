package pages;

import io.qameta.allure.Param;
import io.qameta.allure.Step;
import enums.LoginField;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.model.Parameter.Mode.MASKED;

public class LoginPage {
    private final String idCssPattern = "#%s";

    @Step("Set value in the field '{field}'")
    public LoginPage fillField(LoginField field, @Param(name="value", mode=MASKED) String value) {
        $(String.format(idCssPattern, field.getId())).setValue(value);
        return this;
    }

    @Step("Unset 'RememberMe' checkbox")
    public LoginPage setRememberMeCheckbox() {
        $(byName("_remember_me")).click();
        return this;
    }

    @Step("Click button 'Login' ")
    public LoginPage clickLogin() {
        $("button[type=submit]").click();
        return this;
    }

    @Step("Check, that field {field} in attribute 'required' has expected value: {expectedValue}")
    public LoginPage fieldShouldHaveExpectedAttribute(LoginField field, String expectedValue){
        $(String.format(idCssPattern, field.getId())).shouldHave(attribute("required", expectedValue));
        return this;
    }

    @Step("Check, that login page is displayed")
    public LoginPage loginPageShouldBeDisplayed(){
        $("a[href$='login']").shouldBe(visible);
        return this;
    }

    @Step("Alert is displayed")
    public LoginPage alertShouldBeVisible() {
        $(".alert-danger").shouldBe(visible);
        return this;
    }

}