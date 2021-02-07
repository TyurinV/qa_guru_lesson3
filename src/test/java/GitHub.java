import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.conditions.Text;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;

public class GitHub {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }


    @Test
    void shouldHaveCodeInGithub() {
        //Открыть страницу Github
    open("https://github.com/");
        // Открыть Selenide
    $("[name=q]").setValue("selenide").pressEnter();
    $$("ul.repo-list li a").get(0).click();
        // Перейти в Wiki
    $$("ul.UnderlineNav-body li").get(4).$("a").click();
        //Проверка что в списке страниц (Pages) есть страница SoftAssertions
    $$("div.js-wiki-sidebar-toggle-display li a").shouldHave(CollectionCondition.itemWithText("SoftAssertions"));
        // Откройте страницу SoftAssertions
    $$("div.js-wiki-sidebar-toggle-display li a").findBy(text("SoftAssertions")).click();
        // Проверить что внутри есть пример кода для JUnit5
    $("#wiki-body").shouldHave(Condition.text("Using JUnit5 extend test class"));
        Selenide.sleep(6000);
    }
}
