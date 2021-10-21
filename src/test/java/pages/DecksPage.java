package pages;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DecksPage {

    @Step("Check that page with decks is opened")
    public DecksPage shouldDisplayDecksPage(){
        $(byText("Latest builds for 3D moba game overprime")).shouldBe(visible);
        return this;
    }

    @Step("Check that all decks exist on page")
    public DecksPage shouldDisplayDecksOnPage(){
        int numberOfDecksOnPage=10;
        $$(".deck-list-row").shouldHave(size(numberOfDecksOnPage));
        return this;
    }
}
