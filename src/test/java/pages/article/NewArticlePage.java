package pages.article;

import static com.codeborne.selenide.Condition.visible;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$x;

public class NewArticlePage {

    @Step("Check that page for creation of new article is opened for logged user")
    public NewArticlePage shouldDisplayNewArticleCreationForm() {
        $x("//div[contains(text(), 'Create article')]").shouldBe(visible);
        return this;
    }

}
