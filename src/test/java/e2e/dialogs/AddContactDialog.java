package e2e.dialogs;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import e2e.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddContactDialog extends BasePage {

    @FindBy(xpath = "//*[@role='dialog']")
    private WebElement dialog;
    @FindBy(
            id = "form-name"
    )
    private WebElement firstNameInputField;
    @FindBy(
            id = "form-lastName"
    )
    private WebElement lastNameInputField;
    @FindBy(
            id = "form-about"
    )
    private WebElement aboutInputField;
    @FindBy(
            css = "button.btn.btn-primary"
    )
    private WebElement saveButton;

    public void waitForLoading(){
        getWait().forVisibility(dialog);
        getWait().forVisibility(saveButton);
    }

    public AddContactDialog(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName(String firstNameValue) {
        this.firstNameInputField.sendKeys(new CharSequence[]{firstNameValue});
    }

    public void enterLastName(String lastNameValue) {
        this.lastNameInputField.sendKeys(new CharSequence[]{lastNameValue});
    }

    public void enterAbout(String aboutValue) {
        this.aboutInputField.sendKeys(new CharSequence[]{aboutValue});
    }

    public void clickButtonSave() {
        this.saveButton.click();
    }

    public void waitForClosed(){
        getWait().forVisibility(dialog);
    }
}
