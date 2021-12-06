package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
public class Dropdown {

    WebDriver driver;
    String label;

    String dropdownLocator = "//div[@class='form-group']/label[contains(text(),'%s')]/ancestor::div[@class='form-group']/div[contains(@class, 'container')]";
    String optionLocator = "//div[contains(@id,'react-select') and contains(text(),'%s')]";

    public Dropdown (WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void selectOption(String option) {
        log.info(String.format("Writing text '%s' into input with label '%s'", option, label));
        waiter(dropdownLocator,label);
        driver.findElement(By.xpath(String.format(dropdownLocator, label))).click();
        waiter(optionLocator, option);
        driver.findElement(By.xpath(String.format(optionLocator, option))).click();
    }

    public void selectWithSearch(String text) {
        log.info(String.format("Writing text '%s' into input with label '%s'", text, label));
        waiter(dropdownLocator,label);
        driver.findElement(By.xpath(String.format(dropdownLocator, label))).sendKeys(text);
        waiter(optionLocator, text);
        driver.findElement(By.xpath(String.format(optionLocator, text))).click();
    }

    public void waiter (String dropdownLocator, String option) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(dropdownLocator, option))));
    }

}
