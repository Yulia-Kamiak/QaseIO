package pages;

import elements.Dropdown;
import elements.Input;
import models.TestCase;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class CreateCasePage extends BasePage {

    private static final By SAVE_BUTTON = By.xpath("//*[text()='Save']");
    private final By CASE_TITLE_INPUT = By.id("title");
    private static final String endpointPattern = "/case/%s/create";
    public static String endpoint;

    public CreateCasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CreateCasePage getPageIfOpened() {
        log.info("Get page if opened");
        wait.until(ExpectedConditions.visibilityOfElementLocated(SAVE_BUTTON));
        return this;
    }

    public void setUrl(String code) {
        log.info("Build url with code {}", code);
        endpoint = String.format(endpointPattern, code);
    }

    @Override
    public CreateCasePage openPage() {
        log.info("Open page ");
        driver.get(URL + endpoint);
        return this;
    }

    public CreateCasePage setSuiteTitle(String title) {
        log.info("Set suite title {}", title);
        new Input(driver, "Case Title", CASE_TITLE_INPUT).write(title);
        return this;
    }

    public CreateCasePage clickSaveButton() {
        log.info("Click save button");
        driver.findElement(SAVE_BUTTON).click();
        return this;
    }

    public CreateCasePage populateForm(TestCase model) {
        log.info("Populate form {}", model);
        setSuiteTitle(model.getTitle());
        new Dropdown(driver, "Status").selectOption(model.getStatus());
        new Dropdown(driver, "Severity").selectOption(model.getSeverity());
        new Dropdown(driver, "Priority").selectOption(model.getPriority());
        new Dropdown(driver, "Type").selectOption(model.getType());
        new Dropdown(driver, "Behavior").selectOption(model.getBehavior());
        new Dropdown(driver, "Automation status").selectOption(model.getAutomation());
        return this;
    }
}

