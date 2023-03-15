package org.wikipedia.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.className;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.tagName;

public class SearchTest extends BaseTest{

    @Test
    @DisplayName("Поиск статей")
    void searchArticlesTest() {
        back();
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia:id/search_src_text")).sendKeys("Android");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));

    }

    @Test
    @DisplayName("Открытие статьи")
    void openArticleTest() {
        back();
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia:id/search_src_text")).sendKeys("Android");
        });
        step("Open article", () ->
                $(id("org.wikipedia:id/page_list_item_title"))).click();
        step("Check article", () ->
                $(className("android.widget.TextView")).shouldHave(text("Android")));
    }
}
