import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactInfoPage extends BasePage{
    public ContactInfoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "")
    private WebElement contactsPage;
    @FindBy(css = "")
    private WebElement addNewContact;
    @FindBy(id = "")
    private WebElement firstNameInputField;
    @FindBy(id = "")
    private WebElement lastNameInputField;
    @FindBy(id = "")
    private WebElement aboutInputField;
    @FindBy(css = "")
    private WebElement saveButton;
    @FindBy(css = "")
    private WebElement contactInformationHeader;
    @FindBy(css = "")
    private WebElement contactsList;
    @FindBy(css = "")
    private WebElement searchInputForm;
    @FindBy(css = "")
    private WebElement foundContact;
    @FindBy(css = "")
    private WebElement deleteButton;
}
