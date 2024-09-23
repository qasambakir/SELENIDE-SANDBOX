package selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;
import static org.openqa.selenium.By.id;

public class DragAndDropTest {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }
    @Test
    void dragAndDropUsingActionsTest () {
        // Открываем страницу с Drag & Drop
        open("/drag_and_drop");

        // Проверить, что в начале теста блок A содержит текст "A", а блок B — "B"
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));

        // Перетаскиваем прямоугольник A на место B с использованием Selenide.actions()
        actions().dragAndDrop($(id("column-a")), $(id("column-b"))).perform();

        // Проверяем, что заголовки действительно поменялись
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    void dragAndDropUsingSelenideMethodTest () {
        // Открываем страницу с Drag & Drop
        open("/drag_and_drop");

        // Проверить, что в начале теста блок A содержит текст "A", а блок B — "B"
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));

        // Используем встроенную команду dragAndDrop
        actions().dragAndDrop($("#column-a"),
                $("#column-b")).perform();

        // Проверяем, что заголовки действительно поменялись
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}