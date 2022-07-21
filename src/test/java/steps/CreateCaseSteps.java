package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.TestCase;
import org.openqa.selenium.WebDriver;
import pages.CreateCasePage;

@Log4j2
public class CreateCaseSteps {

    private CreateCasePage createCasePage;

    public CreateCaseSteps(WebDriver driver) {
        createCasePage = new CreateCasePage(driver);
    }

    @Step("Populating Create New Case form")
    public CreateCaseSteps populateNewSuiteForm(TestCase model) {
        log.info("Populate new suite form with data {}", model);
        createCasePage
                .getPageIfOpened()
                .populateForm(model)
                .clickSaveButton();
        return this;
    }
}
