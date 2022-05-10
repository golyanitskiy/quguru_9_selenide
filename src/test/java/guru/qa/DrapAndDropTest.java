package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DrapAndDropTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.headless = true;
    }

    @Test
    void dragDrpoTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        SelenideElement firstElement = $("#column-a");
        SelenideElement secondElement = $("#column-b");

        firstElement.$("header").shouldBe(text("A"));
        secondElement.$("header").shouldBe(text("B"));

        firstElement.dragAndDropTo(secondElement);

        firstElement.$("header").shouldBe(text("B"));
        secondElement.$("header").shouldBe(text("A"));
    }
}
