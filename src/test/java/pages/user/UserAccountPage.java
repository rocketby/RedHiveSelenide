package pages.user;

import static com.codeborne.selenide.Condition.visible;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class UserAccountPage {

    @Step("Check display of user's avatar after login")
    public UserAccountPage avatarOfLoggedUserShouldBeVisible() {
        $(".navbar-user-avatar").shouldBe(visible);
        return this;
    }

    @Step("User logout")
    public UserAccountPage userLogOut() {
        $(".navbar-user-avatar").click();
        $("a[href$='logout']").click();
        return this;
    }


}
