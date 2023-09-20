import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends BasePage {
    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "langSelect")
    private WebElement contactsPage;

    @FindBy(id = "btn-edit-contact")
    private WebElement editContactButton;

    @FindBy(name = "input-ec-description")
    private WebElement editContactDescription;

    @FindBy(xpath = "//*[@class='btn btn-primary submit-btn-ec']")
    private WebElement editContactSaveButton;

    @FindBy(css = "a.nav-link[routerlink='']")
    private WebElement contactsList;

    @FindBy(id = "input-search-contact")
    private WebElement searchInputForm;

    @FindBy(css = "img[src='/assets/icons/trash.svg']")
    private WebElement deleteButton;

    @FindBy(id = "check-box-remove-contact")
    private WebElement deleteCheckbox;

    @FindBy(id = "submit-remove")
    private WebElement submitDeleting;

    public void clickOnEditContact() {editContactButton.click();}

    public void clickOnEditContactDescriptionField() {editContactDescription.click();}

    public void updateAboutField(String aboutFieldNewValue) {
        editContactDescription.sendKeys(aboutFieldNewValue);
    }

    public void clickOnSaveButtonInEditContact() {editContactSaveButton.click();}

    public void clickOnContactsBtn(){
         contactsList.click();
    }

    public void clickOnSearchForm(){
        searchInputForm.click();
    }

    public void clickOnDeleteCheckbox(){
        deleteCheckbox.click();
    }

    public void clickOnSubmitDeletingBtn(){
        submitDeleting.click();
    }

    public void enterInSearchField(String searchValue) {searchInputForm.sendKeys(searchValue);}

    public boolean contactsPageIsDisplayed() {
        try {
            contactsPage.isDisplayed();
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }
    }

    public WebElement makeRowLocator(String nameCell){
        return driver.findElement(By.xpath("//*[contains(text(),'"+nameCell+"')]//ancestor::*[@id='contacts-list']"));
    }

    public void deleteContact(String nameCell){
        makeRowLocator(nameCell).findElement(By.xpath("//img[@src='/assets/icons/trash.svg']")).click();
    }

}
