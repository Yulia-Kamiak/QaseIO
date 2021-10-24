package tests;

import models.TestCase;
import models.TestCaseFactory;
import org.testng.annotations.Test;
import pages.LoginPage;

public class CaseTest extends BaseTest{

    TestCase testСase;

    @Test
    public void testCaseShouldBeCreated() {
        new LoginPage()
                .open()
                .login(user, pass)
                .openProject("This project")
                .clickCreateCase()
                .fillTestCase(testСase = TestCaseFactory.get())
                .saveTestCase();
    }
}