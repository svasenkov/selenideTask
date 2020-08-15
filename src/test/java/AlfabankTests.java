import org.openqa.selenium.WebElement;
import org.testng.annotations.Test; // todo move to junit5

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class AlfabankTests {
    @Test
    void archiveDepositSizeTest() {
        open("https://alfabank.ru/");
       
        actions().moveToElement($(byTitle("Вклады"))).build().perform();
        $(byTitle("Депозиты").click();
        $(byText("Архивные депозиты")).scrollTo().click();
          
        $$("a[class='product-cell__cell-back']").shouldHaveSize(3);
    }

    @Test
    void insuranceSearchTest() {
        open("https://alfabank.ru/");

        $(".p1Cda9").sibling(0).shouldHave(text("Вклады")).click(); // maybe a better locator?
        
        $("ul.navigation > li:last-child").preceding(0).shouldHave(text("Страхование вкладов"));
    }

    @Test
    void functionTest() { // todo rename to a better name
        open("https://alfabank.ru/");

        $(byTitle("Вклады")).closest("span").click();
        
        $(byTitle("Страхование вкладов").shouldHave(text("Страхование вкладов"));
    }

    @Test
    void verifyTheDifference() {
        open("https://alfabank.ru/");

        $("a[title='Вклады']").closest("span").click();
        $("ul.navigation li.selected").contextClick();
        $("ul.navigation").$("li.selected").contextClick();
        
        // assert?
    }
}


