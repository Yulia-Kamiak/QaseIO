package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class Dropdown {

    String label;
    String dropdownLocator = "//*[text()='%s']/parent::div//div[contains(@class, 'container')]";
    String optionLocator = "//*[contains(@id, 'react-select') and contains(text(),'%s')]";

    public Dropdown(String label) {
        this.label = label;
    }

    public void selectOption(String option) {
        $(By.xpath(String.format(dropdownLocator, label))).click();
        $(By.xpath(String.format(optionLocator, option))).click();
    }
}
