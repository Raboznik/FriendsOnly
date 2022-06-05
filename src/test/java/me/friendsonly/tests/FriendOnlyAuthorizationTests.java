package me.friendsonly.tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class FriendOnlyAuthorizationTests extends TestBase {
    /**
     * 1) Проверить, что авторазация работает
     * 2) Проверить, что авторазация с неверным паролем невозможна
     * 3) Проверить, что авторизация с неверным логином невозможна
     * 4) Проверить форму восстановления пароля (не  реализовано)
     * 5) Проверить, что нажатие на иконку глаза показывает пароль
     * 6) Проверить, что авторазация невозможна без принятия условий использования
     * 7) ПРоверить, что авторизация невозможна без принятия политики конфиденциальности
     */
    SelenideElement passwordField = $("input[placeholder=\"Пароль\"]"),
                    emailField =  $("input[placeholder=\"Почта или телефон \"]");
    String wrongEmail = cfgs.login().replace("me", "com");
    String invalidEmail = cfgs.login().replace("@", "");

    @DisplayName("Positive authorization test")
    @Test
    void authorizationTest() {
        step("Open main page", () ->
                open(baseUrl));
        closeAdultWindow.closeAdultWindow();
        step("Click on Log in button", () -> {
            $(".menuItem.login").click();
            $(".auth.mobile").shouldBe(visible);
        });
        step("Accept Privacy Policy", () ->
                $(".acceptBox .icon", 0).click());
        step("Accept Term of Service", () ->
                $(".acceptBox .icon", 1).click());
        step("Enter valid email", () ->
                emailField.setValue(cfgs.login()));
        step("Enter valid password", () ->
                passwordField.setValue(cfgs.password()));
        step("Press enter button", () ->
                $(".second.active .reg-list__item").click());
        checkLogin
                .goToProfileSettings()
                .compareLoginAndId(cfgs.login());
    }

    @DisplayName("Test for authorization with wrong password")
    @Test
    void testAuthorizationWithWrongPassword() {
        step("Open main page", () ->
                open(baseUrl));
        closeAdultWindow.closeAdultWindow();
        step("Click on Log in button", () -> {
            $(".menuItem.login").click();
            $(".auth.mobile").shouldBe(visible);
        });
        step("Accept Privacy Policy", () ->
                $(".acceptBox .icon", 0).click());
        step("Accept Term of Service", () ->
                $(".acceptBox .icon", 1).click());
        step("Enter valid email", () ->
                emailField.setValue(cfgs.login()));
        step("Enter invalid password", () ->
                passwordField.setValue(cfgs.password() + " "));
        step("Press enter button", () ->
                $(".second.active .reg-list__item").click());
        step("Error popup should be visible", () ->
                $(".notification p").shouldBe(visible).shouldHave(text("Email или пароль введен неверно")));
        step("Authorization window should be visible", () ->
                $(".content h2").shouldHave(text("Войти в аккаунт")).shouldBe(visible));
    }

    @DisplayName("Test for authorization with wrong password")
    @ValueSource(strings = {"wrongEmail", "", "invalidEmail", " ", "null"})
    @ParameterizedTest(name = "Test authorization with invalid login ({index} : {0})")
    void testAuthorizationWithWrongLogin(String testData) {
        step("Open main page", () ->
                open(baseUrl));
        closeAdultWindow.closeAdultWindow();
        step("Click on Log in button", () -> {
            $(".menuItem.login").click();
            $(".auth.mobile").shouldBe(visible);
        });
        step("Accept Privacy Policy", () ->
                $(".acceptBox .icon", 0).click());
        step("Accept Term of Service", () ->
                $(".acceptBox .icon", 1).click());
        step("Enter invalid email", () ->
                emailField.setValue(cfgs.login().replace("me", "com")));
        step("Enter valid password", () ->
                passwordField.setValue(cfgs.password()));
        step("Press enter button", () ->
                $(".second.active .reg-list__item").click());
        step("Error popup should be visible", () ->
                $(".notification p").shouldBe(visible).shouldHave(text("Email или пароль введен неверно")));
        step("Authorization window should be visible", () ->
                $(".content h2").shouldHave(text("Войти в аккаунт")).shouldBe(visible));
    }

//    @DisplayName("Test for authorization with wrong password")
//    @Test
//    void testAuthorizationWithWrongLogin() {
//        step("Open main page", () ->
//                open(baseUrl));
//        closeAdultWindow.closeAdultWindow();
//        step("Click on Log in button", () -> {
//            $(".menuItem.login").click();
//            $(".auth.mobile").shouldBe(visible);
//        });
//        step("Accept Privacy Policy", () ->
//                $(".acceptBox .icon", 0).click());
//        step("Accept Term of Service", () ->
//                $(".acceptBox .icon", 1).click());
//        step("Enter invalid email", () ->
//               emailField.setValue(cfgs.login().replace("me", "com")));
//        step("Enter valid password", () ->
//               passwordField.setValue(cfgs.password()));
//        step("Press enter button", () ->
//                $(".second.active .reg-list__item").click());
//        step("Error popup should be visible", () ->
//                $(".notification p").shouldBe(visible).shouldHave(text("Email или пароль введен неверно")));
//        step("Authorization window should be visible", () ->
//                $(".content h2").shouldHave(text("Войти в аккаунт")).shouldBe(visible));
//    }

    @DisplayName("Test for authorization without accepted terms of service")
    @Test
    void authorizationWithoutAcceptedTermsOfServiceTest() {
        step("Open main page", () ->
                open(baseUrl));
        closeAdultWindow.closeAdultWindow();
        step("Click on Log in button", () -> {
            $(".menuItem.login").click();
            $(".auth.mobile").shouldBe(visible);
        });
        step("Accept Terms of service", () ->
                $(".acceptBox .icon", 0).click());
        step("Enter valid email", () ->
                emailField.setValue(cfgs.login()));
        step("Password field should not be visible", () ->
                passwordField.shouldNotBe(visible));
    }

    @DisplayName("Test for authorization without accepted privacy policy")
    @Test
    void authorizationWithoutAcceptedPrivacyPolicy() {
        step("Open main page", () ->
                open(baseUrl));
        closeAdultWindow.closeAdultWindow();
        step("Click on Log in button", () -> {
            $(".menuItem.login").click();
            $(".auth.mobile").shouldBe(visible);
        });
        step("Accept Privacy Policy", () ->
                $(".acceptBox .icon", 1).click());
        step("Enter valid email", () ->
               emailField.setValue(cfgs.login()));
        step("Password field should not be visible", () ->
                passwordField.shouldNotBe(visible));
    }

    @DisplayName("Test for show password button")
    @Test
    void testForShowPasswordButton() {
        step("Open main page", () ->
                open(baseUrl));
        closeAdultWindow.closeAdultWindow();
        step("Click on Log in button", () -> {
            $(".menuItem.login").click();
            $(".auth.mobile").shouldBe(visible);
        });
        step("Accept Privacy Policy", () ->
                $(".acceptBox .icon", 0).click());
        step("Accept Term of Service", () ->
                $(".acceptBox .icon", 1).click());
        step("Enter valid email", () ->
                emailField.setValue(cfgs.login()));
        step("Enter valid password", () ->
                passwordField.setValue(cfgs.password()));
        step("Press show password icon", () -> {
            passwordField.shouldHave(type("password"));
            $(".showPass").click();
            passwordField.shouldHave(type("text"));
        });
    }
}
