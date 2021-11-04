package api.spec;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static config.Credentials.credentials;

public class Specs {
    public static String consumerKey = credentials.consumerKey();
    public static String consumerSecret = credentials.consumerSecret();
    public static String accessToken = credentials.accessToken();
    public static String secretToken = credentials.secretToken();


    public static RequestSpecification requestSpec = with()
            .auth()
            .oauth(consumerKey, consumerSecret, accessToken, secretToken)
            .baseUri("https://api.twitter.com")
//            .basePath("/2/users")
//            .log().uri()
            .contentType(ContentType.JSON);


    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
}
