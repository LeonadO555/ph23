package e2e.pages;

import org.openqa.selenium.ElementClickInterceptedException;
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


    public boolean contactsPageIsDisplayed() {
        try {
            this.contactsPage.isDisplayed();
            return true;
        } catch (NoSuchElementException var2) {
            return false;
        }
    }

    public void waitForLoading() {
        getWait().forVisibility(searchInputForm);
        getWait().forVisibility(contactsList);
    }

    public void clickButtonAddNewContact() {
        try {
            this.addNewContact.click();
        } catch (ElementClickInterceptedException var2) {
            var2.getStackTrace();
        }

    }

    public boolean modalWindowIsDisplayed() {

        return this.modalWindowAddContact.isDisplayed();
    }

    public void enterFirstName(String firstNameValue) {
        this.firstNameInputField.sendKeys(new CharSequence[]{firstNameValue});
    }

    public void enterLastName(String lastNameValue) {
        this.lastNameInputField.sendKeys(new CharSequence[]{lastNameValue});
    }

    public void clickSearchInputField() {
        this.searchInputForm.click();
    }

    public void enterNameInputSearchField(String expectedText) {
        this.searchInputForm.sendKeys(new CharSequence[]{expectedText});
    }

    public String contactIsCorrect() {

        return this.fromContactsList.getText();
    }

    public void clickToButtonDelete() {

        this.deleteButton.click();
    }
}
