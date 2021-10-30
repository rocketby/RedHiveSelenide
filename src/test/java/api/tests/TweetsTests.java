package api.tests;

import allure.*;
import api.models.TweetData;
import api.models.TweetsMeta;
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
@DisplayName("Check data in RedHiveGames Twitter account")
public class TweetsTests {
    private final ApiSteps steps = new ApiSteps();

    @Test
    @AllureId("5676")
    @JiraIssues({@JiraIssue("HOMEWORK-257")})
    @Tags({@Tag("api"), @Tag("positive"), @Tag("twitter")})
    @DisplayName("Verify that Tweet in RedHiveGames account contains expected data")
    public void checkTweetDataByID() {
        String idTweet = "1410531776938790917";
        String tweetText = "Following the Successful Presentation of the Xbox Summer Game Fest Last Year";
        String tweetCreatedDate = "2021-07-01T09:32:36.000Z";
        TweetData tweet = steps.getTweetById(idTweet);

        step("Check,that Tweet text is as expected", () -> {
            assertThat(tweet.getData().getText().contains(tweetText));
            assertThat(tweet.getData().getId().equals(idTweet));
            assertThat(tweet.getData().getCreatedAt().equals(tweetCreatedDate));

        });
    }

    @Test
    @AllureId("5673")
    @JiraIssues({@JiraIssue("HOMEWORK-257")})
    @Tags({@Tag("api"), @Tag("positive"), @Tag("twitter")})
    @DisplayName("Verify that in RedHiveGames Twitter account expected number of tweets is displayed")
    public void checkNumberOfTweetsOnRedHiveAccount() {
        String accountId = apiCredentials.idAccount();
        int countTweetsExpected = 13;
        TweetsMeta tweetsList = steps.getTweetsList(accountId);

        step("Check,that count of tweets equals to expected count", () -> {
            assertThat(tweetsList.getData().size()).isEqualTo(countTweetsExpected);
        });

        step("Check,that count of tweets from meta data equals to expected count", () -> {
            assertThat(tweetsList.getMeta().getResultCount()).isEqualTo(countTweetsExpected);
        });
    }

    @Test
    @AllureId("5675")
    @JiraIssues({@JiraIssue("HOMEWORK-257")})
    @Tags({@Tag("api"), @Tag("positive"), @Tag("twitter")})
    @DisplayName("Verify data in oldest Tweet in RedHive Twitter account")
    public void checkOldestTweetData() {
        String accountId = apiCredentials.idAccount();
        String tweetIdExpected = "1288123051410784257";
        String creationDateExpected = "2020-07-28T14:44:02.000Z";
        String textExpected = "Visit https://t.co/P8k7pih3rO to check detailed Tutorial about overprime roles.";

        TweetsMeta tweetsList = steps.getTweetsList(accountId);
        String oldestTweetId = tweetsList.getOldestId();
        TweetData tweet = steps.getTweetById(oldestTweetId);

        step("Check,that data in oldest Tweet in RedHive account is as expected", () -> {
            assertThat(tweet.getData().getText().contains(textExpected));
            assertThat(tweet.getData().getId().equals(tweetIdExpected));
            assertThat(tweet.getData().getCreatedAt().equals(creationDateExpected));

        });

    }

    @Test
    @AllureId("5677")
    @JiraIssues({@JiraIssue("HOMEWORK-257")})
    @Tags({@Tag("api"), @Tag("positive"), @Tag("twitter")})
    @DisplayName("Verify number of  tweets that are liked by RedHive user account")
    public void checkTweetsLikedByUser() {
        String accountId = apiCredentials.idAccount();
        int countTweetsExpected = 3;

        TweetsMeta tweetsList = steps.getLikedTweetsList(accountId);

        step("Check,that count of tweets equals to expected count", () -> {
            assertThat(tweetsList.getData().size()).isEqualTo(countTweetsExpected);
        });

        step("Check,that count of tweets from meta data equals to expected count", () -> {
            assertThat(tweetsList.getMeta().getResultCount()).isEqualTo(countTweetsExpected);
        });
    }

}