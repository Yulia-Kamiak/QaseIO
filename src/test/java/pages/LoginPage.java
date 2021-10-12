package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public static final String EMAIL_LOCATOR = "#inputEmail";
    public static final String PASSWORD_LOCATOR = "#inputPassword";
    public static final String LOGIN_BUTTON_LOCATOR = "#btnLogin";

    public LoginPage open () {
        Selenide.open("login");
        $(PASSWORD_LOCATOR).shouldBe(Condition.visible);
        return this;
    }

    public ProjectsPage login (String user, String password) {
        $(EMAIL_LOCATOR).sendKeys(user);
        $(PASSWORD_LOCATOR).sendKeys(password);
        $(LOGIN_BUTTON_LOCATOR).click();
        return new ProjectsPage();
    }
}