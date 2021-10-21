package pages;

import static com.codeborne.selenide.Condition.visible;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class NewArticlePage {

    @Step("Check that page for creation of new article is opened for logged user")
    public NewArticlePage shouldDisplayNewArticleCreationForm() {
        $(withText("Create article ")).shouldBe(visible);
        return this;
    }

}
