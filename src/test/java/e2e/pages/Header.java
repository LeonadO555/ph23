package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends BasePage {
    public Header(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[ng-reflect-router-link='.']:first-child")
    private WebElement header;
    @FindBy(css = "a.nav-link[routerlink='']")
    private WebElement contactsLink;
    @FindBy(css = "a.nav-link[href='/contacts']")
    private WebElement addNewContactLink;

    public void waitForLoading(){
        getWait().forVisibility(header);
        getWait().forVisibility(addNewContactLink);
    }

    public boolean isHeaderPresent() {
        return header.isDisplayed();
    }
    public void clickOnAddNewContactLink(){
        addNewContactLink.click();
    }
    public void goToContactsPage(){
        contactsLink.click();
    }
}
