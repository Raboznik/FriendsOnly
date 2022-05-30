package me.friendsonly.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class FriendsOnlyRegistrationTests extends TestBase{

    /**
     * Список тестов на регистрацию :
     * 1) Проверить, что при не принятых Terms of Service и Privacy policy продолжить регистрацию нельзя
     * 2) Проверить, что при не принятых Terms of Service продолжить регистрацию нельзя
     * 3) Проверить, что при не принятых Privacy policy продолжить регистрацию нельзя
     * 4) Проверить, что кнопка Log in ведет обратно на форму логина
     * 5) Проверить, что At 1 click регистрация работает. *Проверить, что письмо приходит на почту
     * 6) Проверить, что вход через Google работает
     * 7) Проверить, что регистрация через тикток работает
     * 8) Проверить, что регистрация через почту работает
     * 9) проверить, что Terms of Service открывается
     * 10) проверить, что Privacy policy открывается
     */

    @DisplayName("Test that without the accepted Terms of Service and Privacy policy" +
            " it is impossible to continue registration")
    @Test
    void testForTosAndPp() {
        step("Open main page", () ->
                open(baseUrl));

        step("Close I'm under 18 window", () -> {
            $(".accept-adults-modal__inner").shouldBe(visible);
//            $(".accept-adults-modal__button accept-adults-modal__button--accept").click();
            $x("//*[@id=\"__layout\"]/div/div[2]/div[3]/div/div[4]/div[1]").click();
        });
        //.accept-adults-modal__inner
        //.accept-adults-modal__button accept-adults-modal__button--accept
        step("Click on Log in button", () -> {
            $(".menuItem.login").click();
            $(".auth.mobile").shouldBe(visible);
        });
        step("Click on Registration button", () ->
            $x("//*[@id=\"__layout\"]/div/div[2]/div[3]/div/div/div/div/span[2]").click());
        step("Registration form should be visible", () ->
                $(".modalWrap.active").shouldBe(visible));
        step("Click on At 1 click button", () ->
            $(".login__button--one").click());
        step("Click on Google button", () ->
                $(".login__button--google").click());
        step("Click on TikTok button", () ->
                $(".login__button--tik-tok").click());
        step("Click on Telegram button", () ->
                $(".login__button--tg").click());
        step("Click on Email button", () ->
                $(".login__button--email").click());
        step("Click on Phone button", () ->
                $(".login__button--phone").click());
        step("Registration form should be visible", () ->
                $(".modalWrap.active").shouldBe(visible));


    }


}
