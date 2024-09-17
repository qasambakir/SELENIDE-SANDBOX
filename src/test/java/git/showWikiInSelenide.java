package git;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

class showWikiInSelenide {

    @Test
    void  searchJunitExample() {
        // open page
        open("https://github.com/selenide/selenide");
        $$("ul.UnderlineNav-body li a").findBy(text("Wiki")).click();
        $("div.Layout-main").$(byText("Soft assertions")).click();
        $(".markdown-body").shouldHave(text("JUnit5"));

        sleep(5000);

    }
}
