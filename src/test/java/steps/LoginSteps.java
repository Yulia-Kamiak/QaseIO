package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

@Log4j2
public class LoginSteps {
    private LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    @Step("Checking error message with invalid credentials '{username}'/ '{password}'")
    public String checkInvalidCredentialsMessage() {
        log.info("Checking error message");

        return loginPage.getErrorText();
    }

    @Step("Login with credentials")
    public LoginSteps performLogin(String username, String password) {
        log.info("Set credentials to login form");
        loginPage
                .openPage()
                .getPageIfOpened()
                .attemptLogin(username, password);
        return this;
    }
}
