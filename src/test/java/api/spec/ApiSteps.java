package api.spec;

import api.models.TweetData;
import api.models.TweetsMeta;
import api.models.UserAccountData;
import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class ApiSteps {

    @Step("Get Tweet Data by Tweet Id")
    public TweetData getTweetById(String TweetId) {
        return given(Specs.requestSpec)
                .when()
                .queryParam("tweet.fields", "created_at")
                .get(format("/2/tweets/%s",TweetId))
                .then()
                .spec(Specs.responseSpec)
                .extract().as(TweetData.class);


    }
    @Step("Get Tweets List")
    public TweetsMeta getTweetsList(String accountId) {
        return given(Specs.requestSpec)
                .when()
                .queryParam("max_results", 50)
                .get(format("/2/users/%s/tweets",accountId))
                .then()
                .spec(Specs.responseSpec)
                .extract().as(TweetsMeta.class);
    }

    @Step("Get Tweets List that are liked by specified user")
    public TweetsMeta getLikedTweetsList(String accountId) {
        return given(Specs.requestSpec)
                .when()
                .get(format("/2/users/%s/liked_tweets",accountId))
                .then()
                .spec(Specs.responseSpec)
                .extract().as(TweetsMeta.class);
    }

    @Step("Get User account's data")
    public UserAccountData getUserAccountData(String accountId) {
        return given(Specs.requestSpec)
                .when()
                .get(format("/2/users/%s",accountId))
                .then()
                .spec(Specs.responseSpec)
             //   .log().body()
                .extract().as(UserAccountData.class);
    }

}
