package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public static final String EMAIL_CSS = "#inputEmail";
    public static final String PASSWORD_CSS = "#inputPassword";
    public static final String LOGIN_BUTTON_CSS = "#btnLogin";

    public LoginPage open () {
        Selenide.open("https://app.qase.io");
        $(PASSWORD_CSS).shouldBe(Condition.visible);
        return this;
    }

    public ProjectsPage login (String user, String password) {
        $(EMAIL_CSS).sendKeys(user);
        $(PASSWORD_CSS).sendKeys(password);
        $(LOGIN_BUTTON_CSS).click();
        return new ProjectsPage().isOpened();
    }
}