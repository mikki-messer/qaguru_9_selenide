import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GithubTest {
    @BeforeAll
    public static void setUp(){
        Configuration.browserSize="1280x720";
        Configuration.holdBrowserOpen = true;
    }

    @DisplayName("Тест видимости статьи SoftAssertions в Selenide Github Wiki")
    @Test
    public void testGithub(){
        final String pageToFind = "SoftAssertions";
        final String blockHeader = "Using JUnit5 extend test class";

        Selenide.open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-body").shouldHave(Condition.text("Welcome to the selenide wiki!"));
        $("#wiki-pages-filter").click();
        $("#wiki-pages-filter").setValue(pageToFind).pressEnter();

        $("[data-filterable-for=wiki-pages-filter]").shouldHave(Condition.text(pageToFind));
        $("[data-filterable-for=wiki-pages-filter]").$(By.linkText(pageToFind)).click();
        $(".gh-header").shouldHave(Condition.text(pageToFind));

        $$("h4").findBy(Condition.text(blockHeader)).sibling(0).shouldHave(Condition.cssClass("highlight"));

    }
}
