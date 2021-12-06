package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class TextArea {
    WebDriver driver;
    String label;
    String locator = "//label[text()='%s']/ancestor::div[contains(@class,'form-group')]//p";

    public TextArea(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        log.info(String.format("Writing text '%s' into input with label '%s'", text, label));
        WebElement element = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(locator, label))));
//        element.clear();
        element.sendKeys(text);
    }
}