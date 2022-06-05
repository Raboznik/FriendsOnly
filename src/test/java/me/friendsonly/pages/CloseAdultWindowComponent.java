package me.friendsonly.pages;

import io.qameta.allure.Step;
import me.friendsonly.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class CloseAdultWindowComponent extends TestBase {
    @Step ( "Close I'm under 18 window")
    public CloseAdultWindowComponent closeAdultWindow() {
            $(".accept-adults-modal__inner").shouldBe(visible);
            $(".accept-adults-modal__button--accept").click();
        return this;
    }

}
