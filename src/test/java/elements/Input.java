package elements;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class Input {

    private static final String INPUT = "//label[contains(text(),'%s')]/ancestor::div[@class='form-group']//p";

    WebDriver driver;
    String label;
    By locator;

    public Input(WebDriver driver, String label, String name) {
        this(driver, label, By.xpath(String.format(INPUT, name)));
    }

    public Input(WebDriver driver, String label, By locator) {
        this.driver = driver;
        this.label = label;
        this.locator = locator;
    }

    public void write(String text) {
        log.info(String.format("Writing text '%s' into input with label '%s'", text, label));
        WebElement element = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }
}

