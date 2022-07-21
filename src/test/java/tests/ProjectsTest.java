package tests;

import adapters.ProjectsAdapter;
import io.qameta.allure.Feature;
import io.restassured.response.ValidatableResponse;
import models.Project;
import models.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RandomString;

@Feature("Projects")
public class ProjectsTest extends BaseTest {

    RandomString randomString = new RandomString();
    ProjectsAdapter projectsAdapter = new ProjectsAdapter();

    @Test(description = "Verify that New project was created")
    public void checkNewProjectCreated() {
        Project model = Project.builder()
                .title(randomString.StringRandom(4))
                .code(randomString.StringRandom(4))
                .description(randomString.StringRandom(4))
                .build();

        loginSteps.performLogin(USERNAME, PASSWORD);
        projectsSteps.clickCreateNewProject();
        createProjectSteps.populateNewProjectForm(model);
        ValidatableResponse getProjectResponse = projectsAdapter.getSingle(model.getCode());
        Response response = getProjectResponse.extract().body().as(Response.class);
        Assert.assertEquals(response.getResult().getTitle(), model.getTitle(), "Project name does not match to expected");
    }

    @Test(description = "Verify that Code value cant be shorter than 2 characters")
    public void checkErrorWithShortCode() {
        Project model = Project.builder()
                .title(randomString.StringRandom(4))
                .code("e")
                .description(randomString.StringRandom(4))
                .build();

        loginSteps.performLogin(USERNAME, PASSWORD);
        projectsSteps.clickCreateNewProject();
        String errorMessage = createProjectSteps.populateNewProjectForm(model).checkErrorMessage(model);
        Assert.assertEquals(errorMessage, "The code must be at least 2 characters.", "Error message is not correct");
    }

    @Test(description = "Verify that a project with the Code used in another project cant be created")
    public void checkErrorWithTheSameCode() {
        String code = randomString.StringRandom(4);
        Project project1 = Project.builder()
                .title(randomString.StringRandom(4))
                .code(code)
                .description(randomString.StringRandom(4))
                .build();

        Project project2 = Project.builder()
                .title(randomString.StringRandom(4))
                .code(code)
                .description(randomString.StringRandom(4))
                .build();

        loginSteps.performLogin(USERNAME, PASSWORD);
        projectsSteps.clickCreateNewProject();
        createProjectSteps.populateNewProjectForm(project1);
        projectsSteps.openProjectsPage().clickCreateNewProject();
        String alertMessage = createProjectSteps.populateNewProjectForm(project2).checkAlertText(project2);
        Assert.assertEquals(alertMessage, "Project with the same code already exists.", "Alert message is not correct");
    }
}
