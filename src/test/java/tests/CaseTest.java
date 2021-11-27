package tests;

import org.testng.annotations.Test;

public class CaseTest extends BaseTest{

    TestCase testСase;

    @Test
    public void testCaseShouldBeCreated() {
        new LoginPage()
                .open()
                .login(user, pass)
                .deleteProject("This project")
                .clickCreate()
                .fillNewProjectForm("This project", "", "Write smth", "Public",
                        "")
                .clickSave()
                .clickCreateCase()
                .fillTestCase(testСase = TestCaseFactory.get())
                .saveTestCase();
    }
}