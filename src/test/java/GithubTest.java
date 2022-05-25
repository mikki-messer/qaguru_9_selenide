import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GithubTest {
    @BeforeAll
    public static void setUp(){
        Configuration.browserSize="1280x720";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void testGithub(){
        final String pageToFind = "SoftAssertions";
        Selenide.open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-body").shouldHave(Condition.text("Welcome to the selenide wiki!"));
        $("#wiki-pages-filter").click();
        $("#wiki-pages-filter").setValue(pageToFind).pressEnter();
        //TODO: переделать на проверку видимости элемента li
        $("[data-filterable-for=wiki-pages-filter]").shouldHave(Condition.text(pageToFind));
        $("[data-filterable-for=wiki-pages-filter]").$(By.linkText(pageToFind)).click();
        $(".gh-header").shouldHave(Condition.text(pageToFind));

        $$("h4").findBy(Condition.text("Using JUnit5 extend test class")).sibling(0).shouldHave(Condition.cssClass("highlight"));

    }
}
