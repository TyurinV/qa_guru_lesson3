import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
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
        $(".repo-list li a").click();
        // Перейти в Wiki
        $(byText("Wiki")).click();
        //Проверка что в списке страниц (Pages) есть страница SoftAssertions + Откройте страницу SoftAssertions
        $("#wiki-pages-box").find(byText("SoftAssertions")).shouldHave(text("SoftAssertions")).click();
        // Проверить что внутри есть пример кода для JUnit5
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}
