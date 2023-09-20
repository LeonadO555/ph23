import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddContactDialog extends BasePage {
    public AddContactDialog(WebDriver driver) {super(driver);}

    @FindBy(id = "form-name")
    private WebElement firstNameInputField;
    @FindBy(id = "form-lastName")
    private WebElement lastNameInputField;
    @FindBy(id = "form-about")
    private WebElement aboutInputField;
    @FindBy(css = "button.btn.btn-primary")
    private WebElement saveButton;


    public void setFirstNameInputField(String firstNameValue) {firstNameInputField.sendKeys(firstNameValue);
    }
    public void setLastNameInputField(String lastNameValue) {lastNameInputField.sendKeys(lastNameValue);
    }
    public void setAboutInputField(String aboutValue) {aboutInputField.sendKeys(aboutValue);
    }
    public void clickSaveButton() {saveButton.click();
    }

}
