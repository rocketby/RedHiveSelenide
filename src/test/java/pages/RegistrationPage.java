package pages;

import static com.codeborne.selenide.Condition.visible;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPage {

    @Step("Set value in field Email")
    public RegistrationPage enterEmail(String value) {
        $("#registration_form_email").setValue(value);
        return this;
    }

    @Step("Set value in field Password")
    public RegistrationPage enterPassword(String value) {
        $("#registration_form_plainPassword").setValue(value);
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

