package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.TestCase;
import models.TestSuite;
import org.openqa.selenium.WebDriver;
import pages.ProjectPage;

@Log4j2
public class ProjectSteps {
    private ProjectPage projectPage;

    public ProjectSteps(WebDriver driver) {
        projectPage = new ProjectPage(driver);
    }

    @Step("Verify that project's page was opened")
    public String getProjectName(String code) {
        log.info("Get name of project with code {}", code);
        return projectPage.setUrl(code).openPage().getPageIfOpened().getProjectNameText();
    }

    @Step("Verify that project's page contains code")
    public String getProjectCode() {
        log.info("Get project code");
        return projectPage.getPageIfOpened().getProjectCodeText();
    }

    @Step("Click Create New Suite")
    public ProjectSteps clickCreateNewSuite() {
        log.info("Click create new suite button");
        projectPage.getPageIfOpened().clickCreateNewSuite();
        return this;
    }

    @Step("Click Create New Case")
    public ProjectSteps clickCreateNewCase() {
        log.info("Click create new case button");
        projectPage.getPageIfOpened().clickCreateNewCase();
        return this;
    }

    @Step("Verify that new case exists on Project page")
    public String getCaseName(TestCase model) {
        log.info("Get case name {}", model);
        return projectPage.getCaseNameText(model.getTitle());
    }

    @Step("Verify that new suite exists on Project page")
    public String getSuiteName(TestSuite model) {
        log.info("Get suite name {}", model);
        return projectPage.getSuiteNameText(model.getTitle());
    }

}
