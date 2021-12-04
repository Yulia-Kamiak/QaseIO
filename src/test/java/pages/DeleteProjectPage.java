package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class DeleteProjectPage extends BasePage{

    public static final String DELETE_PROJECT_BUTTON = "//*[contains(@class, 'btn') and contains(text(),' Delete project')]";

    public DeleteProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public DeleteProjectPage getPageIfOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath((DELETE_PROJECT_BUTTON))));
        return this;
    }

    @Override
    public BasePage openPage() {
        return null;
    }

    public ProjectsPage confirmDeleting() {
        driver.findElement(By.xpath(DELETE_PROJECT_BUTTON)).click();
        return new ProjectsPage(driver);
    }

}
