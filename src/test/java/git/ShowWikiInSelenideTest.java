package git;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;

class ShowWikiInSelenideTest {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void searchJunitExample() {
        // open the page
        open("/selenide/selenide");
        // Кликнуть на вкладку Wiki
        $("#wiki-tab").click();
        // Найти и раскрыть боковую панель
        $("div.Layout-sidebar").$(byText("Show 3 more pages…")).click();
        // Найти и кликнуть на "SoftAssertions"
        $(byTagAndText("a", "SoftAssertions")).shouldBe(visible).click();
        // Проверить наличие заголовка "SoftAssertions" на странице
        $(byTagAndText("h1", "SoftAssertions")).shouldBe(visible);
        // Проверка примера кода для JUnit5
        String junitFiveCodeExample = """
            @ExtendWith({SoftAssertsExtension.class})
            class Tests {
                @Test
                void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");

                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                }
            }""";
        // Проверить наличие примера кода на странице
        $(".markdown-body").shouldHave(text(junitFiveCodeExample));

    }
}
