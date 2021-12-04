package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import steps.*;
import utils.PropertyReader;
import utils.TestListener;

@Log4j
@Listeners(TestListener.class)
public class BaseTest {

    private  WebDriver driver;

    public ProjectsSteps projectsSteps;
    public LoginSteps loginSteps;
    public CreateProjectSteps createProjectSteps;
    public CreateSuiteSteps createSuiteSteps;
    public CreateCaseSteps createCaseSteps;
    public ProjectSteps projectSteps;

    public static final String USERNAME = System.getenv().getOrDefault("QASE_USER",
           PropertyReader.getProperty("qase.user"));
    public static final String PASSWORD = System.getenv().getOrDefault("QASE_PASS",
            PropertyReader.getProperty("qase.pass"));

    @BeforeMethod(description = "Opening Firefox Driver")
    public void setup () {
        //Configuration.baseUrl = System.getenv().getOrDefault("QASE_URL",
        //        PropertyReader.getProperty("qase.url"));
        Configuration.timeout = 20000;
        Configuration.pageLoadTimeout = 60000;
        Configuration.browser = "firefox";
        Configuration.browserVersion = "93.0";
        Configuration.startMaximized = true;
        Configuration.headless = false;
        Configuration.clickViaJs = false;
        loginSteps = new LoginSteps(driver);
        projectsSteps = new ProjectsSteps(driver);
        createProjectSteps = new CreateProjectSteps(driver);
        createSuiteSteps = new CreateSuiteSteps(driver);
        createCaseSteps = new CreateCaseSteps(driver);
        projectSteps = new ProjectSteps(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void exit() {
        if (driver != null) {
            driver.quit();
        }
    }
}