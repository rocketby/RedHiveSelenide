package api.tests;

import allure.*;
import api.models.UserAccountData;
import api.spec.ApiSteps;
import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static api.config.ApiCredentials.apiCredentials;

@Layer("rest")
@Owner("tat")
@Lead("alex")
@Microservice("twitter api")
@DisplayName("Check RedHiveGames Twitter account")
public class TwitterUserAccountTests {
    private final ApiSteps steps = new ApiSteps();

    @Test
    @AllureId("5674")
    @JiraIssues({@JiraIssue("HOMEWORK-257")})
    @Tags({@Tag("api"), @Tag("positive"), @Tag("twitter")})
    @DisplayName("Verify User Account Data")
    public void checkTweetDataByID() {
        String idAccount = apiCredentials.idAccount();
        String userAccountName = "RedHiveGames";
        UserAccountData userAccount = steps.getUserAccountData(idAccount);

        step("Check,that Red Hive Twitter Account's data is as expected", () -> {
            assertThat(userAccount.getData().getUsername().equals(userAccountName));
            assertThat(userAccount.getData().getName().equals(userAccountName));
        });
    }
}
