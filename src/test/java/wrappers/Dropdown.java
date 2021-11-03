package wrappers;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Dropdown {

    public static final String DROP_DOWN_LOCATOR = "//*[@id='%s']//descendant::*[@class=' css-1hwfws3']";
    public static final String DROP_DOWN_IS_OPENED_LOCATOR = ".css-1gg2qke-menu";
    String fieldName;

    public Dropdown(String fieldName) {
        this.fieldName = fieldName;
    }

    public void select(String option) {
        $(By.xpath(String.format(DROP_DOWN_LOCATOR, fieldName))).click();
        $$(DROP_DOWN_IS_OPENED_LOCATOR).findBy(Condition.text(option)).click();
    }
}
