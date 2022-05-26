import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class DragNDropTest {
    @BeforeAll
    public static void setUp(){
        Configuration.browserSize="1280x800";
        Configuration.holdBrowserOpen = true;
    }

    @DisplayName("Тест функции drag-and-drop")
    @Test
    public void dragNDropActionsTest(){
        Selenide.open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldHave(Condition.text("A"));
        $("#column-b").shouldHave(Condition.text("B"));
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").shouldHave(Condition.text("B"));
        $("#column-b").shouldHave(Condition.text("A"));
    }
}
