import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactInfoPage extends BasePage{
    public ContactInfoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="btn-edit-contact")
    private WebElement editButton;

    @FindBy(id="contact-first-name")
    private WebElement firstNameInputField;

    @FindBy(id="contact-last-name")
    private WebElement lastNameInputField;

    @FindBy(id="contact-description")
    private WebElement contactDescription;

    @FindBy(css= "[class=\"btn btn-primary submit-btn-ec\"]")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"edit-contact-form\"]/div[1]/div[2]/input")
    private WebElement firstNameEdit;

    @FindBy(xpath = "//*[@id=\"edit-contact-form\"]/div[2]/div[2]/input")
    private WebElement lastNameEdit;

    @FindBy(xpath = "//*[@id=\"edit-contact-form\"]/div[3]/div[2]/textarea")
    private WebElement descriptionEdit;

    @FindBy(xpath = "/html/body/app-root/app-home-page/app-header/nav/div/ul/li[1]/a")
    private WebElement contactButton;




    public String firstNameIsCorrect(){
        return firstNameInputField.getText();
    }

    public String lastNameIsCorrect(){
        return lastNameInputField.getText();
    }

    public String descriptionIsCorrect(){
        return contactDescription.getText();
    }


    public void clickButtonEdit(){
        try{
            editButton.click();
        } catch (ElementClickInterceptedException e){
            e.getStackTrace();
        }

    }

    public void enterFirstNameEdit(String firstNameEditValue){
        firstNameEdit.sendKeys(firstNameEditValue);
    }

    public void enterLastNameEdit(String lastNameEditValue){
        lastNameEdit.sendKeys(lastNameEditValue);
    }

    public void enterDescriptionEdit(String descriptionEditValue){
        descriptionEdit.sendKeys(descriptionEditValue);
    }
    public void editAllInputFields(String firstNameEditValue, String lastNameEditValue, String descriptionEditValue){
        enterFirstNameEdit(firstNameEditValue);
        enterLastNameEdit(lastNameEditValue);
        enterDescriptionEdit(descriptionEditValue);
    }

    public void clickButtonSave(){
        saveButton.click();
    }

    public void clickButtonContact(){
        contactButton.click();
    }
}


