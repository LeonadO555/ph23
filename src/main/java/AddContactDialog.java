import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddContactDialog extends BasePage{

    public AddContactDialog(WebDriver driver) {
        super(driver);
    }



    @FindBy(id = "form-name")
    private WebElement firstNameInputField;
    @FindBy(id = "form-lastName")
    private WebElement lastNameInputField;
    @FindBy(id = "form-about")
    private WebElement contactDescriptionInputField;
    @FindBy(css = "button.btn.btn-primary")
    private WebElement saveButton;



    public void inputInfoForSaving(String expectedFirstName, String expectedLastName, String contactDescription) {
        firstNameInputField.sendKeys(expectedFirstName);
        lastNameInputField.sendKeys(expectedLastName);
        contactDescriptionInputField.sendKeys(contactDescription);
    }

    public void saveContact() {
        saveButton.click();
    }


}
