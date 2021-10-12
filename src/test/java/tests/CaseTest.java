package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class CaseTest {

    @Test
    public void testCaseShouldBeCreated() {
        //create project using API
        new LoginPage()
                .open()
                .login("vvv.zenkevich@gmail.com", "password03")
                .openProject("This project");
        //open project by name
        //create case
        //validate case info
    }
}