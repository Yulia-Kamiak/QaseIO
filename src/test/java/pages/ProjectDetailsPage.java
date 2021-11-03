package pages;

import com.codeborne.selenide.Condition;
import models.TestCase;
import org.openqa.selenium.By;
import wrappers.Dropdown;
import static com.codeborne.selenide.Selenide.$;

public class ProjectDetailsPage {

    public static final String CREATE_NEW_CASE_LOCATOR_XPATH = "//a[contains(@class, 'ms-3')][contains(text(), " +
            "'Create new case')]";
    public static final String TITLE_LOCATOR_CSS = "#title";
    public static final String SAVE_TEST_CASE_CSS = "#save-case";

    public ProjectDetailsPage clickCreateCase() {
        $(By.xpath(CREATE_NEW_CASE_LOCATOR_XPATH)).click();
        $(By.xpath(CREATE_NEW_CASE_LOCATOR_XPATH)).shouldBe(Condition.disappear);
        return this;
    }

    public ProjectDetailsPage fillTestCase(TestCase testCase) {
        $(TITLE_LOCATOR_CSS).sendKeys(testCase.getTitle());
        new Dropdown("statusGroup").select(testCase.getStatus());
        new Dropdown("suiteGroup").select(testCase.getSuite());
        new Dropdown("severityGroup").select(testCase.getSeverity());
        new Dropdown("priorityGroup").select(testCase.getPriority());
        new Dropdown("typeGroup").select(testCase.getType());
        new Dropdown("layerGroup").select(testCase.getLayer());
        new Dropdown("is_flakyGroup").select(testCase.getIsFlaky());
        new Dropdown("milestoneGroup").select(testCase.getMilestone());
        new Dropdown("behaviorGroup").select(testCase.getBehavior());
        new Dropdown("automationStatusGroup").select(testCase.getAutomationStatus());
        return this;
    }

    public ProjectDetailsPage saveTestCase () {
        $(SAVE_TEST_CASE_CSS).click();
        return this;
    }
}