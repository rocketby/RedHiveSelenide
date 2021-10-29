package tests.menu;

import allure.JiraIssue;
import allure.Layer;
import allure.Microservice;
import enums.MenuItem;
import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import pages.MainPage;
import pages.article.ArticlesPage;
import pages.article.NewArticlePage;
import pages.calculator.PriceCalculatorPage;
import pages.deck.DecksPage;
import pages.deck.NewDeckPage;
import tests.BaseTest;

@Owner("tat")
@Layer("web")
@Microservice("main menu")
@DisplayName("Verify opening main menu sections by logged user")
public class LoggedUserTests extends BaseTest {

    @BeforeAll
    @DisplayName("Login in Red Hive")
    public static void setUpBeforeEach() {
        cleanCookies();
        login();
    }

    @Test
    @AllureId("5681")
    @JiraIssue("HOMEWORK-257")
    @Tags({@Tag("web"), @Tag("decks")})
    @DisplayName("Open page with decks by logged user")
    public void openDecksPageByLoggedUserTest() {
        new MainPage().clickMenuOption(MenuItem.OPEN_DECKS);
        new DecksPage()
                .shouldDisplayDecksPage()
                .shouldDisplayDecksOnPage();
    }

    @Test
    @AllureId("5691")
    @JiraIssue("HOMEWORK-257")
    @Tags({@Tag("web"), @Tag("article")})
    @DisplayName("Open page with articles by logged user")
    public void openArticlesPageByLoggedUserTest() {
        new MainPage().clickMenuOption(MenuItem.OPEN_ARTICLES);
        new ArticlesPage()
                .shouldDisplayArticlesPage()
                .shouldDisplayArticlesOnPage();
    }

    @Test
    @AllureId("5693")
    @JiraIssue("HOMEWORK-257")
    @Tags({@Tag("web"), @Tag("article")})
    @DisplayName("Open page to create a new article by logged user")
    public void openCreateArticlePageByLoggedUserTest() {
        new MainPage().clickMenuOption(MenuItem.CREATE_ARTICLE);
        new NewArticlePage().shouldDisplayNewArticleCreationForm();
    }

    @Test
    @AllureId("5688")
    @JiraIssue("HOMEWORK-257")
    @Tags({@Tag("web"), @Tag("decks")})
    @DisplayName("Open page to create a new deck by logged user")
    public void openCreateDeckPageByLoggedUserTest() {
        new MainPage().clickMenuOption(MenuItem.CREATE_DECK);
        new NewDeckPage().shouldDisplayNewDeckCreationForm();
    }

    @Test
    @AllureId("5686")
    @JiraIssue("HOMEWORK-257")
    @Tags({@Tag("web"), @Tag("priceCalculator")})
    @DisplayName("Open price calculator by logged user")
    public void openPriceCalculatorLoggedUserTest() {
        new MainPage().clickMenuOption(MenuItem.PRICE_CALCULATOR);
        new PriceCalculatorPage()
                .shouldOpenPriceCalculatorPage()
                .shouldNotDisplayLoginAlert();
    }
}
