package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setup () {
        Configuration.timeout = 1500000;
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://app.qase.io/";
        Configuration.startMaximized = true;
        Configuration.headless = false;
        Configuration.clickViaJs = false;
    }
}