package pages;

import static com.codeborne.selenide.Condition.visible;
import enums.RegistrationField;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPage {
    private final String idCssPattern = "#%s";

    @Step("Set value in the field '{field}'")
    public RegistrationPage fillField(RegistrationField field, String value) {
        $(String.format(idCssPattern, field.getId()))
                .setValue(value);
        return this;
    }

    @Step("Mark checkbox 'Agree with terms'")
    public RegistrationPage markCheckboxAgreeWithTerms() {
        $("#registration_form_agreeTerms").click();
        return this;
    }

    @Step("Click button 'Register'")
    public RegistrationPage clickRegister() {
        $x("//form[@name='registration_form']/button").click();
        return this;
    }

    @Step("Check that registration page is displayed")
    public RegistrationPage shouldDisplayRegistrationPage() {
        $x("//h1[text() = 'Registration']").shouldBe(visible);
        return this;
    }
}

