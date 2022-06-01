package me.friendsonly.tests;

import org.assertj.core.error.ShouldNotBeNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class FriendsOnlyRegistrationTests extends TestBase {

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

//    @DisplayName("Test that without the accepted Terms of Service and Privacy policy" +
//            " it is impossible to continue registration")
//    @Test
//    void testForRegistrationWithoutAcceptedTermsAndPolicy() {
//        step("Open main page", () ->
//                open(baseUrl));
//        step("Close I'm under 18 window", () -> {
//            $(".accept-adults-modal__inner").shouldBe(visible);
//            $(".accept-adults-modal__button--accept").click();
//        });
//        step("Click on Log in button", () -> {
//            $(".menuItem.login").click();
//            $(".auth.mobile").shouldBe(visible);
//        });
//        step("Click on Registration button", () ->
//                $(".lineRow span", 1).click());
//        step("Registration form should be visible", () ->
//                $(".modalWrap.active").shouldBe(visible));
//        step("Click on At 1 click button", () ->
//                $(".login__button--one").click());
//        step("Click on Google button", () ->
//                $(".login__button--google").click());
//        step("Click on TikTok button", () ->
//                $(".login__button--tik-tok").click());
//        step("Click on Telegram button", () ->
//                $(".login__button--tg").click());
//        step("Click on Email button", () ->
//                $(".login__button--email").click());
//        step("Click on Phone button", () ->
//                $(".login__button--phone").click());
//        step("Registration form should be visible", () ->
//                $(".modalWrap.active").shouldBe(visible));
//    }
//
//    @DisplayName("Test that without the accepted Terms of Service it is impossible to continue registration")
//    @Test
//    void testForRegistrationWithoutAcceptedTermsOfService() {
//        step("Open main page", () ->
//                open(baseUrl));
//        step("Close I'm under 18 window", () -> {
//            $(".accept-adults-modal__inner").shouldBe(visible);
//            $(".accept-adults-modal__button--accept").click();
//        });
//        step("Click on Log in button", () -> {
//            $(".menuItem.login").click();
//            $(".auth.mobile").shouldBe(visible);
//        });
//        step("Click on Registration button", () ->
//                $(".lineRow span", 1).click());
//        step("Registration form should be visible", () ->
//                $(".modalWrap.active").shouldBe(visible));
//        step("Accept Privacy Policy only", () ->
//                $(".acceptBox", 1).click());
//        step("Click on At 1 click button", () ->
//                $(".login__button--one").click());
//        step("Click on Google button", () ->
//                $(".login__button--google").click());
//        step("Click on TikTok button", () ->
//                $(".login__button--tik-tok").click());
//        step("Click on Telegram button", () ->
//                $(".login__button--tg").click());
//        step("Click on Email button", () ->
//                $(".login__button--email").click());
//        step("Click on Phone button", () ->
//                $(".login__button--phone").click());
//        step("Registration form should be visible", () ->
//                $(".modalWrap.active").shouldBe(visible));
//    }
//
//    @DisplayName("Test that without the accepted Privacy Policy it is impossible to continue registration")
//    @Test
//    void testForRegistrationWithoutAcceptedPrivacyPolicy() {
//        step("Open main page", () ->
//                open(baseUrl));
//        step("Close I'm under 18 window", () -> {
//            $(".accept-adults-modal__inner").shouldBe(visible);
//            $(".accept-adults-modal__button--accept").click();
//        });
//        step("Click on Log in button", () -> {
//            $(".menuItem.login").click();
//            $(".auth.mobile").shouldBe(visible);
//        });
//        step("Click on Registration button", () ->
//                $(".lineRow span", 1).click());
//        step("Registration form should be visible", () ->
//                $(".modalWrap.active").shouldBe(visible));
//        step("Accept Term of Service only", () ->
//                $(".acceptBox", 0).click());
//        step("Click on At 1 click button", () ->
//                $(".login__button--one").click());
//        step("Click on Google button", () ->
//                $(".login__button--google").click());
//        step("Click on TikTok button", () ->
//                $(".login__button--tik-tok").click());
//        step("Click on Telegram button", () ->
//                $(".login__button--tg").click());
//        step("Click on Email button", () ->
//                $(".login__button--email").click());
//        step("Click on Phone button", () ->
//                $(".login__button--phone").click());
//        step("Registration form should be visible", () ->
//                $(".modalWrap.active").shouldBe(visible));
//    }
//
//    @DisplayName("Test for click on login button. It's should go back to login page")
//    @Test
//    void testForButtonLogIn() {
//        step("Open main page", () ->
//                open(baseUrl));
//        step("Close I'm under 18 window", () -> {
//            $(".accept-adults-modal__inner").shouldBe(visible);
//            $(".accept-adults-modal__button--accept").click();
//        });
//        step("Click on Log in button", () -> {
//            $(".menuItem.login").click();
//            $(".content h2").shouldBe(visible).shouldHave(text("Войти в аккаунт"));
//        });
//        step("Click on Registration button", () -> {
//            $(".lineRow span", 1).click();
//            $(".content h2").shouldBe(visible).shouldHave(text("Регистрация"));
//        });
//        step("Click on Log in button again", () -> {
//            $(".lineRow span", 1).click();
//            $(".content h2").shouldBe(visible).shouldHave(text("Войти в аккаунт"));
//        });
//    }

    @DisplayName("Test for At 1 click registration")
    @Test
    void testForAtOneClickRegistration() {
        step("Open main page", () ->
                open(baseUrl));
        step("Close I'm under 18 window", () -> {
            $(".accept-adults-modal__inner").shouldBe(visible);
            $(".accept-adults-modal__button--accept").click();
        });
        step("Click on Log in button", () -> {
            $(".menuItem.login").click();
            $(".auth.mobile").shouldBe(visible);
        });
        step("Click on Registration button", () ->
                $(".lineRow span", 1).click());
        step("Registration form should be visible", () ->
                $(".modalWrap.active").shouldBe(visible));
        step("Accept Privacy Policy", () ->
                $(".acceptBox .icon", 0).click());
        step("Accept Term of Service", () ->
                $(".acceptBox .icon", 1).click());
        step("Click on At 1 click button", () ->
                $(".login__button--one").click());
        step("Enter birthday", () -> {
            $(".title_I9NeD span").shouldBe(visible).shouldHave(text("Когда у вас день рождения?"));
            $(".button_BI4gf").scrollTo().click();
            $(".title_I9NeD span").should(disappear);
        });
        step("Сheck registration window", () -> {
            $(".popupText").shouldBe(visible).shouldHave(text("Сохраните логин и пароль"));
            String login = $("#registered_email").attr(".value");
            System.out.println(login);
            $("#registered_password").shouldNotBe(empty);
        });
        step("Sign in to account", () ->
            $(".bnt-continue").click());
        step("Go to profile settings", () -> {
            $(".avatar-none").hover();
            $(".menuBlockItem").click();
        });






    }


}



