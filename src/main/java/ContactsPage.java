import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends BasePage {
    public ContactsPage(WebDriver driver) {super(driver);}

    @FindBy(id = "langSelect")
    private WebElement contactsPage;
    @FindBy(xpath = "//*[@class='collapse navbar-collapse']//*[@href='/contacts']")
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
    @FindBy(css = "a.nav-link[routerlink='']")
    private WebElement contactsList;
    @FindBy(xpath = "//*[@id=\"input-search-contact\"]")
    private WebElement searchInputForm;
    @FindBy(css = "b")
    private WebElement foundContact;
    @FindBy(css = "img[src='/assets/icons/trash.svg']")
    private WebElement deleteButton;

    @FindBy(id = "add-contact-modal")
    private WebElement modalWindowAddContact;

    @FindBy(xpath = "//*[@id=\"contacts-list\"]/div/app-contact-item/div/button[1]")
    private WebElement fromContactsList;

   // @FindBy(xpath = "//*[@id=\"contacts-list\"]/div[32]/app-contact-item/div/button[2]")
   // private WebElement deleteButton;

    public boolean contactsPageIsDisplayed() {
        try {
            contactsPage.isDisplayed();
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }
    }


    public void clickButtonAddNewContact(){
        try{
            addNewContact.click();
        } catch (ElementClickInterceptedException e){
            e.getStackTrace();
        }

    }

    public boolean modalWindowIsDisplayed(){
        return modalWindowAddContact.isDisplayed();
    }

    public void enterFirstName(String firstNameValue){

        firstNameInputField.sendKeys(firstNameValue);
    }

    public void enterLastName(String lastNameValue){
        lastNameInputField.sendKeys(lastNameValue);
    }

    public void clickSearchInputField(){
        searchInputForm.click();
    }

    public void enterNameInputSearchField(String expectedText){
        searchInputForm.sendKeys(expectedText);
    }

    public String contactIsCorrect(){
         return fromContactsList.getText();
    }

    public void clickToButtonDelete(){
        deleteButton.click();
    }
}
