package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
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
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
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