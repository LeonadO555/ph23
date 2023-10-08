package e2e.pages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactInfoPage extends BasePage {
    public ContactInfoPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "btn-edit-contact")
    private WebElement editButton;
    @FindBy(id = "contact-first-name")
    private WebElement firstNameInputField;
    @FindBy(id = "contact-last-name")
    private WebElement lastNameInputField;
    @FindBy(id = "contact-description")
    private WebElement contactDescription;
    @FindBy(css = "[class=\"btn btn-primary submit-btn-ec\"]")
    private WebElement saveButton;
    @FindBy(xpath = "//*[@id=\"edit-contact-form\"]/div[1]/div[2]/input")
    private WebElement firstNameEdit;
    @FindBy(xpath = "//*[@id=\"edit-contact-form\"]/div[2]/div[2]/input")
    private WebElement lastNameEdit;
    @FindBy(xpath = "//*[@id=\"edit-contact-form\"]/div[3]/div[2]/textarea")
    private WebElement descriptionEdit;
    @FindBy(xpath = "/html/body/app-root/app-home-page/app-header/nav/div/ul/li[1]/a")
    private WebElement contactButton;

    @FindBy(id = "ngb-nav-23")
    private WebElement buttonPhone;

    public void waitForLoading(){
        getWait().forVisibility(contactButton);
        getWait().forVisibility(firstNameInputField);
        getWait().forVisibility(lastNameInputField);
        getWait().forVisibility(contactDescription);
        getWait().forVisibility(editButton);
        getWait().forVisibility(saveButton);
        getWait().forVisibility(buttonPhone);
    }



    public String firstNameIsCorrect() {

        return this.firstNameInputField.getText();
    }

    public String lastNameIsCorrect() {

        return this.lastNameInputField.getText();
    }

    public String descriptionIsCorrect() {

        return this.contactDescription.getText();
    }




    public void clickButtonEdit() {
        try {
            this.editButton.click();
        } catch (ElementClickInterceptedException var2) {
            var2.getStackTrace();
        }

    }

    public void enterFirstNameEdit(String firstNameEditValue) {
        this.firstNameEdit.sendKeys(new CharSequence[]{firstNameEditValue});
    }

    public void enterLastNameEdit(String lastNameEditValue) {
        this.lastNameEdit.sendKeys(new CharSequence[]{lastNameEditValue});
    }

    public void enterDescriptionEdit(String descriptionEditValue) {
        this.descriptionEdit.sendKeys(new CharSequence[]{descriptionEditValue});
    }

    public void editAllInputFields(String firstNameEditValue, String lastNameEditValue, String descriptionEditValue) {
        this.enterFirstNameEdit(firstNameEditValue);
        this.enterLastNameEdit(lastNameEditValue);
        this.enterDescriptionEdit(descriptionEditValue);
    }

    public void clickButtonSave() {
        this.saveButton.click();
    }

    public void clickButtonContact() {
        this.contactButton.click();
    }

    public void clickButtonPhone(){
        buttonPhone.click();
    }

}
