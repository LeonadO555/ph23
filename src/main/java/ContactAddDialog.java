import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactAddDialog extends BasePage{

    public ContactAddDialog(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a.nav-link[href='/contacts']")
    private WebElement addNewContact;

    @FindBy(id = "form-name")
    private WebElement firstNameInputField;

    @FindBy(id = "form-lastName")
    private WebElement lastNameInputField;

    @FindBy(id = "form-about")
    private WebElement aboutInputField;

    @FindBy(css = "button.btn.btn-primary")
    private WebElement saveButton;

    @FindBy(css = "h5")
    private WebElement contactInformationHeader;

    @FindBy(id = "contact-first-name")
    private WebElement contactFirstName;

    @FindBy(id = "contact-last-name")
    private WebElement contactLastName;

    @FindBy(id = "contact-description")
    private WebElement aboutField;

    public void clickOnAddNewContactButton(){
        addNewContact.click();
    }
    public void setEnterFirstName(String firstNameValue) {
        firstNameInputField.sendKeys(firstNameValue);
    }
    public void setEnterLastName(String lastNameValue) {
        lastNameInputField.sendKeys(lastNameValue);
    }
    public void setAboutField(String aboutFieldValue) {
        aboutInputField.sendKeys(aboutFieldValue);
    }
    public void clickOnSaveButton(){
        saveButton.click();
    }
    public boolean contactInformationHeaderIsDisplayed(){
        return contactInformationHeader.isDisplayed();
    }
    public boolean firstNameHasText(String expectedText){
        return contactFirstName.getText().contains(expectedText);
    }
    public boolean lastNameHasText(String expectedText){
        return contactLastName.getText().contains(expectedText);
    }
    public boolean aboutFieldHasText(String expectedText){
        return aboutField.getText().contains(expectedText);
    }
}
