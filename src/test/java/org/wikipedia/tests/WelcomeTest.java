package org.wikipedia.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.className;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.id;

public class WelcomeTest extends BaseTest{
    
    @Test
    @DisplayName("Прохождение welcome страниц")
    void welcomeTest() {
        step("check display of 'selecting language' page", () -> {
                $(id("org.wikipedia:id/primaryTextView")).shouldHave(text("The Free Encyclopedia …in over 300 languages"));
        });
        step("open second page 'New ways to explore'", () ->
                $(id("org.wikipedia:id/fragment_onboarding_forward_button"))).click();
                $(id("org.wikipedia:id/primaryTextView")).shouldHave(text("New ways to explore"));

        step("open page 'Reading lists with sync'", () ->
                $(id("org.wikipedia:id/fragment_onboarding_forward_button"))).click();
                $(id("org.wikipedia:id/primaryTextView")).shouldHave(text("Reading lists with sync"));
        step("open page 'Send anonymous data'", () ->
                $(id("org.wikipedia:id/fragment_onboarding_forward_button"))).click();
                $(id("org.wikipedia:id/primaryTextView")).shouldHave(text("Send anonymous data"));

        step("finish welcoming", () ->
                $(id("org.wikipedia:id/fragment_onboarding_done_button"))).click();
                $(className("android.widget.TextView")).shouldBe(visible);
    }

}
