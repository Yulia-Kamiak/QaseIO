package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class ProjectPage extends BasePage{

    private static final By PROJECT_LABEL = By.xpath("//*[starts-with(@class, 'style_title')]");
    private static final By CODE_LABEL = By.cssSelector(".subheader");
    private static final By CREATE_SUITE_BUTTON = By.xpath("//*[contains(text(), 'Create new suite')]");
    private static final By CREATE_CASE_BUTTON = By.xpath("//*[contains(text(), 'Create new case')]");
    private static final String caseLocator = "//*[starts-with(@class, 'style_caseTitle')][text()='%s']";
    private static final String suiteLocator = "//*[starts-with(@class,'style_titleText')][text()='%s']";

    private static final String endpointPattern = "/project/%s";
    public static String endpoint;

    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProjectPage getPageIfOpened() {
        log.info("Get page if opened");
        wait.until(ExpectedConditions.visibilityOfElementLocated(CREATE_SUITE_BUTTON));
        return this;
    }

    public ProjectPage setUrl(String code) {
        log.info("Build url with code {}", code);
        endpoint = String.format(endpointPattern, code);
        return this;
    }

    @Override
    public ProjectPage openPage() {
        log.info("Open page");
        driver.get(URL + endpoint);
        return this;
    }

    public String getProjectNameText() {
        log.info("Get project name");
        return driver.findElement(PROJECT_LABEL).getText();
    }

    public String getProjectCodeText() {
        log.info("Get project code");
        return driver.findElement(CODE_LABEL).getText();
    }

    public ProjectPage clickCreateNewSuite() {
        isElementDisplayed(CREATE_SUITE_BUTTON);
        log.info("Click create suite button");
        driver.findElement(CREATE_SUITE_BUTTON).click();
        return this;
    }

    public ProjectPage clickCreateNewCase() {
        isElementDisplayed(CREATE_CASE_BUTTON);
        log.info("Click create case button");
        driver.findElement(CREATE_CASE_BUTTON).click();
        return this;
    }

    public String getCaseNameText(String name) {
        log.info("Get case name {}", name);
        isElementDisplayed(By.xpath(String.format(caseLocator, name)));
        return driver.findElement(By.xpath(String.format(caseLocator, name))).getText();
    }

    public String getSuiteNameText(String name) {
        log.info("Get suite name {}", name);
        isElementDisplayed(By.xpath(String.format(suiteLocator, name)));
        return driver.findElement(By.xpath(String.format(suiteLocator, name))).getText();
    }

}
