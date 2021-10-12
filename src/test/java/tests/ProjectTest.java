package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class ProjectTest extends BaseTest{

    @Test
    public void projectShouldBeCreated() {
        new LoginPage()
                .open()
                .login("vvv.zenkevich@gmail.com", "password03")
                .isOpened()
                .clickCreateProduct()
                .fillNewProjectForm("THIS PROJECT", "", "Write smth", "Public",
                        "");
    }
}