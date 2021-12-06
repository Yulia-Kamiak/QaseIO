package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;

@Log4j2
public abstract class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public final static String URL = System.getenv().getOrDefault("QASE_URL", PropertyReader.getProperty("qase.url"));

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    public abstract BasePage getPageIfOpened();

    public abstract BasePage openPage();

    public boolean isElementDisplayed(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
