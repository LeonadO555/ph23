package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import util.Wait;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Wait getWait(){

        return new Wait(driver);
    }
}
