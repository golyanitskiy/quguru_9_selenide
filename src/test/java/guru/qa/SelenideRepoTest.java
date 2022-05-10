package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepoTest {
    @BeforeAll
    private static void setUp() {
        Configuration.headless = true;
    }

    @Test
    public void findARepo() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $(By.linkText("SoftAssertions")).shouldBe(visible).click();
        $$(".markdown-body > h4")
                .findBy(text("Using JUnit5 extend test class"))
                .sibling(0)
                .shouldBe(visible);
    }
}
