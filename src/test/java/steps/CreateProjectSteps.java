package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Project;
import org.openqa.selenium.WebDriver;
import pages.CreateProjectPage;

@Log4j2
public class CreateProjectSteps {
    private CreateProjectPage createProjectPage;

    public CreateProjectSteps(WebDriver driver) {
        createProjectPage = new CreateProjectPage(driver);
    }

    @Step("Populating Create New Project form with name, code and description")
    public CreateProjectSteps populateNewProjectForm(Project model) {
        createProjectPage.getPageIfOpened().populateForm(model);
        return this;
    }

    @Step("Checking error message with short code value")
    public String checkErrorMessage(Project model) {
        log.info("Checking error message for project with code {}", model.getCode());
        return createProjectPage.getErrorText();
    }

    @Step("Checking alert message with short code value")
    public String checkAlertText(Project model) {
        log.info("Checking alert message for project with code {}", model.getCode());
        return createProjectPage.getAlertText();
    }
}
