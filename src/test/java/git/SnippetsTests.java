package git;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SnippetsTests {

    @Test
    void ShouldFindSeleindeTest1() {
        // отркыть страницу
        open("https://github.com/");
        // кликнуть на поиск
        $("[placeholder='Search or jump to...']").click();
        // ввести значение
        $("#query-builder-test").setValue("selenide").pressEnter();
        // выбрать репозиторий
        $(".search-title a").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));


        sleep(5000);

    }
}
