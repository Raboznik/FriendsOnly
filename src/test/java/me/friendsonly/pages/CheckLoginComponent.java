package me.friendsonly.pages;

import io.qameta.allure.Step;
import me.friendsonly.tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckLoginComponent extends TestBase {
    @Step("Go to profile settings")
    public CheckLoginComponent goToProfileSettings() {
        $(".avatar-none").hover();
        $(".menuBlockItem").click();
        return this;
    }

    @Step("Compare login and id in settings")
    public CheckLoginComponent compareLoginAndId(String loginId) {
        $(".title_wzrNJ").shouldHave(text(loginId.split("@")[0]));
        return this;
    }

    @Step("Go to settings")
    public CheckLoginComponent goToSettings() {
        $(".avatar-none").hover();
        $(byText("Настройки")).click();
        return this;
    }

    @Step("Compare email in settings and email from registration form")
    public CheckLoginComponent compareEmailInSettings(String email) {
        $("input[placeholder=\"Почта\"]").
                shouldHave(value(email));
        return this;
    }
}
