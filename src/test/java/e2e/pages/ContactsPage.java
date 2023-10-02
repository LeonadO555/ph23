package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ContactsPage extends Header {
    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "langSelect")
    private WebElement contactsPage;

    @FindBy(css = "[class=\"nav-tabs bg-secondary text-white d-flex align-items-center p-2 nav\"]")
    private WebElement contactsListElement;

    @FindBy(id= "input-search-contact")
    private WebElement searchInputField;

    @FindBy(xpath = "(//div[@id=\"contacts-list\"]//b)[1]")
    private WebElement newContatNameFromContactsList;

    @FindBy(xpath = "(//div[@id=\"contacts-list\"]//button)[1]")
    private WebElement confirmationNewContactLink;

    @FindBy(css = "img[src='/assets/icons/trash.svg']")
    private WebElement deleteButton;

    @FindBy(xpath = "//*[@class='alert text-center alert-warning']")
    private WebElement noResultMessage;

    public void waitForLoading(){
        getWait().forVisibility(searchInputField);
        getWait().forVisibility(contactsListElement);
    }


    public String readValueFromNewContact(){
        return newContatNameFromContactsList.getText();
    }


    public void searchContact(String expectedText){
        searchInputField.sendKeys(expectedText);
    }

    public void clickOnNewContactNameLinkFromContactsList(){
        confirmationNewContactLink.click();
    }

    public void deleteContact(){
        deleteButton.click();
    }

    public boolean isNoResultsDisplayed(){
        return noResultMessage.isDisplayed();
    }

}
