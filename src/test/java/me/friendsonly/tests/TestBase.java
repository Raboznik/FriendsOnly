package me.friendsonly.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import me.friendsonly.config.CredentialsConfig;
import me.friendsonly.helper.Attach;
import me.friendsonly.pages.CheckLoginComponent;
import me.friendsonly.pages.CloseAdultWindowComponent;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.sleep;

public class TestBase {

    String baseUrl = "https://friendsonly.me/ru";
    static CredentialsConfig cfgs = ConfigFactory.create(CredentialsConfig.class);
    String faker = new Faker().internet().emailAddress();
    public static CheckLoginComponent checkLogin = new CheckLoginComponent();
    public static CloseAdultWindowComponent closeAdultWindow = new CloseAdultWindowComponent();


    @BeforeAll
    static void setUp() {
        String browser = System.getProperty("browser", "chrome");
        String size = System.getProperty("size", "1920x1080");

        String remoteUrl = System.getProperty("remoteUrl", cfgs.remoteUrl());
        String login = System.getProperty("login", cfgs.remoteLogin());
        String pass = System.getProperty("pass", cfgs.remotePassword());

        Configuration.remote = "https://" + login + ":" + pass + "@" + remoteUrl;
        Configuration.browser = browser;
        Configuration.browserSize = size;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("allure", new AllureSelenide());

        Attach.attachAsText("Browser: ", browser);
        Attach.attachAsText("Remote Url: ", cfgs.remoteUrl());

    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        sleep(5000);
        closeWebDriver();
    }

}

