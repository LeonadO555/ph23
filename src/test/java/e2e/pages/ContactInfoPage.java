package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ContactInfoPage extends Header {
    public ContactInfoPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "contact-first-name")
    private WebElement firstNameSaved;
    @FindBy(id = "contact-last-name")
    private WebElement lastNameSaved;
    @FindBy(id = "contact-description")
    private WebElement descriptionSaved;

    @FindBy(id = "btn-edit-contact")
    private WebElement editButton;

    @FindBy(css= "input[name=\"input-ec-firstName\"]")
    private WebElement firstNameInputField;
    @FindBy(css= "input[name=\"input-ec-lastName\"]")
    private WebElement lastNameInputField;
    @FindBy(css= "textarea[name=\"input-ec-description\"]")
    private WebElement contactDescription;
    @FindBy(css= "[class=\"btn btn-primary submit-btn-ec\"]")
    private WebElement saveButton;

    public void waitForLoading(){
        getWait().forVisibility(editButton);
    }

    public boolean isEditButtonDisplayed() {
        return editButton.isDisplayed();
    }
    public void clickOnEditButton(){
        editButton.click();
    }
    public void editName(String expectedText) {
        firstNameInputField.clear();
        firstNameInputField.sendKeys(expectedText);
    }
    public void editLastName(String expectedText) {
        lastNameInputField.clear();
        lastNameInputField.sendKeys(expectedText);
    }
    public void clickOnSaveButton(){
        saveButton.click();
    }
    public List<String> getContactInfo() {
        List<String> list = new ArrayList<>();
        list.add(firstNameSaved.getText());
        list.add(lastNameSaved.getText());
        list.add(descriptionSaved.getText());
        return list;
    }
    public String getFirstNameText(){
        return firstNameSaved.getText();
    }
    public String getLastNameText() {
        return lastNameSaved.getText();
    }
    public String getDescriptionText(){
        return descriptionSaved.getText();
    }
}
