package pages;

import org.openqa.selenium.By;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class LoginPage extends BasePage{

    private final By EMAIL_INPUT = By.id("inputEmail");
    private final By PASSWORD_INPUT = By.id("inputPassword");
    private final By LOGIN_BUTTON = By.id("btnLogin");
    private final By ERROR = By.cssSelector(".form-control-feedback");

    private static final String endpoint = "login";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage getPageIfOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        return this;
    }

    @Override
    public LoginPage openPage() {
        log.info("Login page URL is " + URL + endpoint);
        driver.get(URL + endpoint);
        return this;
    }

    public LoginPage attemptLogin(String username, String password) {
        driver.findElement(EMAIL_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    public String getErrorText() {
        isElementDisplayed(ERROR);
        log.info("The following error appears: " + driver.findElement(ERROR).getText());
        return driver.findElement(ERROR).getText();
    }

}


