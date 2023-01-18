package tests;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {

    @Test
    @Feature("Поиск")
    @DisplayName("Успешный поиск")
    void successSearchTest() {
        step("Перейти в поисковую строку", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
        });

        step("Ввести текст, выполнить поиск", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        });

        step("Проверить, что количество новостей больше 0", () -> {
            $$(byClassName("android.widget.TextView")).shouldBe(sizeGreaterThan(0));
        });
    }
    @Test
    @Feature("Поиск")
    @DisplayName("Неуспешный поиск - пустая строка")
    void unsuccessfulSearchTestNullFields() {
        step("Перейти в поисковую строку", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
        });

        step("Ввести текст, выполнить поиск", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("");
        });

        step("Проверить, что количество новостей = 0", () -> {
            $$(byClassName("android.widget.TextView")).shouldBe(sizeGreaterThan(0));
        });
    }

    @Test
    @Feature("Поиск")
    @DisplayName("Неуспешный поиск - некорректный текст поиска")
    void unsuccessfulSearchTestNotCorrectTextSearch() {
        step("Перейти в поисковую строку", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
        });

        step("Ввести текст, выполнить поиск", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("sadsadsafdsafdsa0908908988080");
        });

        step("Проверить, что количество новостей больше 0", () -> {
            $$(byClassName("android.widget.TextView")).shouldBe(sizeGreaterThan(0));
        });
    }
}