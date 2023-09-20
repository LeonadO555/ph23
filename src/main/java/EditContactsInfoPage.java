import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditContactsInfoPage extends BasePage {
    public EditContactsInfoPage(WebDriver driver) {super(driver);}

    @FindBy(css = "input[formcontrolname='firstName']")
    private WebElement editFirstNameInput;
    @FindBy(css = "input[formcontrolname='lastName']")
    private WebElement editLastNameInput;
    @FindBy(css = "textarea[formcontrolname='description']")
    private WebElement editDescriptionTextarea;
    @FindBy(xpath = "//button[contains(@class, 'btn-primary') and contains(@class, 'submit-btn-ec')]")
    private WebElement saveButton;

    public void setFirstNameInput(String firstNameValue) {
        editFirstNameInput.clear();
        editFirstNameInput.sendKeys(firstNameValue);}
    public void setLastNameInput(String lastNameValue) {
        editLastNameInput.clear();
        editLastNameInput.sendKeys(lastNameValue);}
    public void setEditDescriptionTextarea(String descriptionValue) {
        editDescriptionTextarea.clear();
        editDescriptionTextarea.sendKeys(descriptionValue);}

    public void clickOnSaveButton() {
        try {
            saveButton.click();
            }
        catch (ElementClickInterceptedException e){
                e.printStackTrace();
        }
        }
    }
