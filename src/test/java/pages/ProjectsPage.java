package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class ProjectsPage extends BasePage{

    private final By CREATE_BUTTON = By.id("createButton");
    private static final String endpoint = "/projects";
    private static final String projectLocator = "//*[@class='project-row']//*[contains(text(),'%s')]";

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Projects List page was opened")
    public ProjectsPage getPageIfOpened() {
        log.info("Get project page if opened");
        wait.until(ExpectedConditions.visibilityOfElementLocated(CREATE_BUTTON));
        return this;
    }

    @Override
    public ProjectsPage openPage() {
        log.info("Open page");
        driver.get(URL + endpoint);
        return this;
    }

    public ProjectsPage clickCreateNewProject() {
        log.info("Click create new project button");
        driver.findElement(CREATE_BUTTON).click();
        return this;
    }

    public String getProjectNameText(String name) {
        log.info("Get project name {}", name);
        isElementDisplayed(By.xpath(String.format(projectLocator, name)));
        return driver.findElement(By.xpath(String.format(projectLocator, name))).getText();
    }

}
