package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void loginPageIsOpened() {
        Assert.assertTrue(
                loginPage
                        .open()
                        .isOpened()
        );
    }

    @Test
    public void authorizationIsSuccessful() {
        Assert.assertTrue(
                loginPage.
                        open()
                        .authorization(EMAIL, PASS)
                        .isOpened()
        );
    }
}
