import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AlfabankTest {
    @Test
    void verifyTheBlocks() {
        WebElement invest = $("a[title='Вклады']");
        open("https://alfabank.ru/");

        actions().moveToElement(invest).build().perform();
        $("a[title='Депозиты']").click();
        $(byText("Архивные депозиты")).scrollTo().click();
        $$("a[class='product-cell__cell-back']").shouldHaveSize(3);
    }

    @Test
    void insuranceSearch() {
        open("https://alfabank.ru/");

        $("span[class='p1Cda9']").sibling(0).shouldHave(text("Вклады")).click();
        $("ul.navigation > li:last-child").preceding(0).shouldHave(text("Страхование вкладов")).click();
    }

    @Test
    void functionTest() {
        open("https://alfabank.ru/");

        $("a[title='Вклады']").closest("span").click();
        $("a[title='Страхование вкладов']").shouldHave(text("Страхование вкладов")).click();

    }

    @Test
    void verifyTheDifference() throws InterruptedException {
        open("https://alfabank.ru/");

        $("a[title='Вклады']").closest("span").click();
        $("ul.navigation li.selected").contextClick();
        $("ul.navigation").$("li.selected").contextClick();

    }
}


