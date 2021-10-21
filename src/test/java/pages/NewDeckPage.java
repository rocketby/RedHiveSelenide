package pages;

import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class NewDeckPage {

    @Step("Check that page for creation of new deck is opened for logged user")
    public NewDeckPage shouldDisplayNewDeckCreationForm() {
        $("input[placeholder='Enter deck name']").shouldBe(visible);
        return this;
    }
}
