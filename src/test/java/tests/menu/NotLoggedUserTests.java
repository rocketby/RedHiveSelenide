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
import pages.calculator.PriceCalculatorPage;
import pages.deck.DecksPage;
import pages.user.LoginPage;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.open;
import static config.Credentials.credentials;

@Owner("tat")
@Layer("web")
@Microservice("main menu")
@DisplayName("Verify opening of pages by not logged user")
public class NotLoggedUserTests extends BaseTest {
    private MainPage mainPage;

    @BeforeEach
    void setUpBeforeEach()  {
        cleanCookies();
        mainPage = open(credentials.baseURL(), MainPage.class);
    }

    @Test
    @AllureId("5680")
    @JiraIssue("HOMEWORK-257")
    @Tags({@Tag("web"), @Tag("decks")})
    @DisplayName("Open page with decks by not logged user")
    public void openDecksPageByNotLoggedUserTest() {
        new MainPage().clickMenuOption(MenuItem.OPEN_DECKS);
        new DecksPage()
                .shouldDisplayDecksPage()
                .shouldDisplayDecksOnPage();
    }


    @Test
    @AllureId("5682")
    @JiraIssue("HOMEWORK-257")
    @Tags({@Tag("web"), @Tag("article")})
    @DisplayName("Open page with articles by not logged user")
    public void openArticlesPageByNotLoggedUserTest() {
        new MainPage().clickMenuOption(MenuItem.OPEN_ARTICLES);
        new ArticlesPage()
                .shouldDisplayArticlesPage()
                .shouldDisplayArticlesOnPage();
    }

    @Test
    @AllureId("5684")
    @JiraIssue("HOMEWORK-257")
    @Tags({@Tag("web"), @Tag("article")})
    @DisplayName("Open page to create a new article by not logged user")
    public void openCreateArticlePageByNotLoggedUserTest() {
        mainPage.clickMenuOption(MenuItem.CREATE_ARTICLE);
        new LoginPage().loginPageShouldBeDisplayed();
    }

    @Test
    @AllureId("5687")
    @JiraIssue("HOMEWORK-257")
    @Tags({@Tag("web"), @Tag("decks")})
    @DisplayName("Open page to create a new deck by not logged user")
    public void openCreateDeckPageByNotLoggedUserTest() {
        mainPage.clickMenuOption(MenuItem.CREATE_DECK);
        new LoginPage().loginPageShouldBeDisplayed();
    }

    @Test
    @AllureId("5692")
    @JiraIssue("HOMEWORK-257")
    @Tags({@Tag("web"), @Tag("priceCalculator")})
    @DisplayName("Open price calculator by not logged user")
    public void openPriceCalculatorNotLoggedUserTest() {
        mainPage.clickMenuOption(MenuItem.PRICE_CALCULATOR);
        new PriceCalculatorPage()
                .shouldOpenPriceCalculatorPage()
                .shouldDisplayLoginAlert();
    }
}
