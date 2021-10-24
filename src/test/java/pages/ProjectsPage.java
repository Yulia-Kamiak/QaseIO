package pages;

import com.codeborne.selenide.Condition;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProjectsPage {

    public static final String CREATE_PROJECT_CSS = "#createButton";
    public static final String TITLE_CSS = "#inputTitle";
    public static final String CODE_CSS = "#inputCode";
    public static final String DESCRIPTION_CSS = "#inputDescription";
    public static final String PROJECT_TITLES_CSS = "a.defect-title";
    public static final String PROJECTS_OPTIONS_XPATH = "//a[contains(text(), '%s')]//ancestor::*[@class='project-row']" +
            "//*[contains(@class, 'btn-dropdown')]";
    public static final String DELETE_PROJECT_XPATH = "//a[contains(text(), '%s')]//ancestor::*[@class=" +
            "'project-row']//*[contains(@class, 'text-danger')]";
    public static final String SUBMIT_DELETE_CSS = ".btn-cancel";

    public ProjectsPage isOpened() {
        $(CREATE_PROJECT_CSS).shouldBe(Condition.visible);
        return this;
    }

    public ProjectsPage clickCreate() {
        $(CREATE_PROJECT_CSS).click();
        $(TITLE_CSS).shouldBe(Condition.visible);
        return this;
    }

    public ProjectsPage fillNewProjectForm(String projectName, String codeName, String description, String accessType,
                                           String memberAccess) {
        $(TITLE_CSS).sendKeys(projectName);
        if(StringUtils.isEmpty(codeName)) {
            $(CODE_CSS).sendKeys(codeName);
        }
        $(DESCRIPTION_CSS).sendKeys(description);
        switch (accessType) {
            case "Public": {
                $("#public-access-type").click();
                break;
            }
            case "Private": {
                $("#private-access-type").click();
                switch (memberAccess) {
                    case "Add all members to this project": {
                        $("#accessAll").click();
                    }
                    case "Add members from specific group": {
                        $("#accessGroup").click();
                    }
                    case "Don't add members": {
                        $("#accessNone").click();
                    }
                }
                break;
            }
        }
        return this;
    }

    public ProjectsPage clickSave() {
        $(DESCRIPTION_CSS).submit();
        $(DESCRIPTION_CSS).shouldBe(Condition.disappear);
        return this;
    }

    public ProjectDetailsPage openProject(String name) {
        $$(PROJECT_TITLES_CSS).findBy(Condition.text(name)).click();
        $(By.xpath("//div(contains(@id, 'react-select'))"));
        return new ProjectDetailsPage();
    }

    public ProjectsPage deleteProject(String name) {
        try {
            $(By.xpath(String.format(PROJECTS_OPTIONS_XPATH, name))).click();
            $(By.xpath(String.format(DELETE_PROJECT_XPATH, name))).click();
            $(SUBMIT_DELETE_CSS).click();
        } catch (Exception ex) {
            System.out.println("Cannot delete project");
            ex.printStackTrace();
        }
        return this;
    }
}
