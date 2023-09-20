import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends BasePage {
    public ContactsPage(WebDriver driver) {super(driver);}

    @FindBy(id = "langSelect")
    private WebElement contactsPage;
    @FindBy(css = "a.nav-link[href='/contacts']")
    private WebElement addNewContact;
    @FindBy(id = "contact-first-name")
    private WebElement firstNameField;
    @FindBy(id = "contact-last-name")
    private WebElement lastNameField;
    @FindBy(id = "contact-description")
    private WebElement aboutField;
    @FindBy(css = "a.nav-link[routerlink='']")
    private WebElement contactsList;
    @FindBy(css = "input[formcontrolname='searchInput']")
    private WebElement searchInputForm;
    @FindBy(css = "b")
    private WebElement foundContact;
    @FindBy(css = "img[src='/assets/icons/trash.svg']")
    private WebElement deleteButton;
    @FindBy(xpath = "//b")
    private WebElement alertMessage;


    public boolean contactsPageIsDisplayed() {
        try {
            contactsPage.isDisplayed();
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }
    }

    public void addNewContact() {
        addNewContact.click();
    }

    public String getFirstName() {
        return firstNameField.getText();
    }
    public String getLastName() {
        return lastNameField.getText();
    }
    public String getAbout() {
        return aboutField.getText();
    }
    public void clickContactList(){
        contactsList.click();
    }

    public void searchContact(String name) {
        searchInputForm.sendKeys(name);
    }

    public boolean alertMessageIsDisplayed() {
        try {
            alertMessage.isDisplayed();
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }
    }
}
