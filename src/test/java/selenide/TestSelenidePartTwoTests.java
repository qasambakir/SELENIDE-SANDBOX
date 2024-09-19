package selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestSelenidePartTwoTests {

        @BeforeAll
        static void setUp() {
            Configuration.browserSize = "1920x1080";
            Configuration.pageLoadStrategy = "eager";
            Configuration.baseUrl = "https://github.com";
        }

    @Test
    void GitSolutionsEnterprise() {

            // открываем страницу
        open("https://github.com");
            // Навести мышку на элемент Solutions
        $("header").$(byText("Solutions")).hover();
            // Проверить, что подменю "Enterprise" появилось и нажать на него
        $(byText("Enterprise")).shouldBe(visible).click();
            // Убедиться, что на загруженной странице присутствует заголовок с нужным текстом
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));

    }
}
