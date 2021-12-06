package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.TestSuite;
import org.openqa.selenium.WebDriver;
import pages.CreateSuitePage;

@Log4j2
public class CreateSuiteSteps {
    private CreateSuitePage createSuitePage;

    public CreateSuiteSteps(WebDriver driver) {
        createSuitePage = new CreateSuitePage(driver);
    }

    @Step("Populating Create New Suite form with name, description and preconditions, and submit")
    public CreateSuiteSteps populateNewSuiteForm(TestSuite model) {
        log.info("Populate new suite form {}", model);
        createSuitePage
                .getPageIfOpened()
                .populateForm(model)
                .clickSubmitButton();
        return this;
    }
}
