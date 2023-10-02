package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddContactDialog extends BasePage {

    public AddContactDialog(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@role='dialog']")
    private WebElement dialog;
    @FindBy(id = "form-name")
    private WebElement firstNameInputField;
    @FindBy(id = "form-lastName")
    private WebElement lastNameInputField;
    @FindBy(id = "form-about")
    private WebElement contactDescriptionInputField;
    @FindBy(css = "button.btn.btn-primary")
    private WebElement saveButton;

    public void waitForLoading(){
        getWait().forVisibility(dialog);
        getWait().forVisibility(saveButton);
    }


    public void inputInfoForSaving(String expectedFirstName, String expectedLastName, String contactDescription) {
        firstNameInputField.sendKeys(expectedFirstName);
        lastNameInputField.sendKeys(expectedLastName);
        contactDescriptionInputField.sendKeys(contactDescription);
    }

    public void saveContact() {
        saveButton.click();
    }

    public void waitForClosed(){
        getWait().forInvisibility(dialog);
    }
}
