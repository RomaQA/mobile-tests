package org.wikipedia.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.appium.SelenideAppium;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.wikipedia.drivers.LocalAndroidDriver;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.wikipedia.utils.AllureAttachmentHelper.*;


/*
Базовый класс с преднастройками для тестовых сценариев
 */
public class BaseTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = LocalAndroidDriver.class.getName();
        Configuration.timeout = 15000;
        Configuration.pageLoadTimeout = 15000;
        Configuration.browserSize = null;

    }

    @BeforeEach
    void openBrowser() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = Selenide.sessionId().toString();
        screenshotAs("Last screenshot");
        pageSource();
        closeWebDriver();
    }
}
