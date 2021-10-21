package tests.user;

import allure.JiraIssue;
import allure.Layer;
import allure.Microservice;
import enums.Endpoint;
import enums.LoginField;
import enums.MenuItem;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import pages.*;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static config.Credentials.credentials;

@Owner("tat")
@Layer("web")
@Microservice("main menu")
@DisplayName("Verify opening main menu sections by logged user")
public class LoggedUserTests extends BaseTest {
    private static LoginPage loginPage;

    @BeforeEach
    @DisplayName("Login in Red Hive")
    public void setUpBeforeEach() {
        open(credentials.faviconURL());
        getWebDriver().manage().deleteAllCookies();
        loginPage = open(Endpoint.LOGIN.getPath(), LoginPage.class);
        String email = credentials.loginEmail();
        String password = credentials.loginPassword();
        loginPage
                .fillField(LoginField.EMAIL, email)
                .fillField(LoginField.PASSWORD, password)
                .setRememberMeCheckbox()
                .clickLogin();
    }

    @Test
    @JiraIssue("HOMEWORK-257")
    @Tags({@Tag("web"), @Tag("decks")})
    @DisplayName("Open page with decks by logged user")
    public void openDecksPageByLoggedUserTest(){
        new MainPage().clickMenuOption(MenuItem.OPEN_DECKS);
        new DecksPage()
                .shouldDisplayDecksPage()
                .shouldDisplayDecksOnPage();
    }

    @Test
    @JiraIssue("HOMEWORK-257")
    @Tags({@Tag("web"), @Tag("article")})
    @DisplayName("Open page with articles by logged user")
    public void openArticlesPageByLoggedUserTest(){
        new MainPage().clickMenuOption(MenuItem.OPEN_ARTICLES);
        new ArticlesPage()
                .shouldDisplayArticlesPage()
                .shouldDisplayArticlesOnPage();
    }

    @Test
    @JiraIssue("HOMEWORK-257")
    @Tags({@Tag("web"), @Tag("article")})
    @DisplayName("Open page to create a new article by logged user")
    public void openCreateArticlePageByLoggedUserTest() {
        new MainPage().clickMenuOption(MenuItem.CREATE_ARTICLE);
        new NewArticlePage().shouldDisplayNewArticleCreationForm();
    }

    @Test
    @JiraIssue("HOMEWORK-257")
    @Tags({@Tag("web"), @Tag("decks")})
    @DisplayName("Open page to create a new deck by logged user")
    public void openCreateDeckPageByLoggedUserTest() {
        new MainPage().clickMenuOption(MenuItem.CREATE_DECK);
        new NewDeckPage().shouldDisplayNewDeckCreationForm();
    }

}
