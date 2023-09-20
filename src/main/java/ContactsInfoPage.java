import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsInfoPage extends BasePage {
    public ContactsInfoPage(WebDriver driver) {super(driver);}

    @FindBy(id = "langSelect")
    private WebElement contactsPage;
    @FindBy(id = "contact-first-name")
    private WebElement firstNameField;
    @FindBy(id = "contact-last-name")
    private WebElement lastNameField;
    @FindBy(id = "contact-description")
    private WebElement aboutField;
    @FindBy(id = "btn-edit-contact")
    private WebElement editContact;

    public boolean contactsPageIsDisplayed() {
        try {
            contactsPage.isDisplayed();
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }
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
    public void clickOnEditContactButton() {
        editContact.click();
    }

}
