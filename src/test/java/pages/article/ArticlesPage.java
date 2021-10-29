package pages.article;

import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ArticlesPage {

    @Step("Check that page with articles is opened")
    public ArticlesPage shouldDisplayArticlesPage(){
        $(byText("Latest articles")).shouldBe(visible);
        return this;
    }

    @Step("Check that all articles exist on page")
    public ArticlesPage shouldDisplayArticlesOnPage(){
        int numberOfArticlesOnPage=12;
        $$x("//div[@class='row articles-list ']/div").shouldHave(size(numberOfArticlesOnPage));
        return this;
    }
}
