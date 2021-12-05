package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Project;
import org.openqa.selenium.WebDriver;
import pages.ProjectsPage;

@Log4j2
public class ProjectsSteps {
    private ProjectsPage projectsListPage;

    public ProjectsSteps(WebDriver driver) {
        projectsListPage = new ProjectsPage(driver);
    }

    @Step("Click Create New Project")
    public ProjectsSteps clickCreateNewProject() {
        projectsListPage.getPageIfOpened().clickCreateNewProject();
        return this;
    }

    @Step("Open Projects page")
    public ProjectsSteps openProjectsPage() {
        projectsListPage.openPage().getPageIfOpened();
        return this;
    }

    @Step("Verify that new project exists on Projects page")
    public String getProjectName(Project model) {
        return projectsListPage.getProjectNameText(model.getTitle());
    }

}