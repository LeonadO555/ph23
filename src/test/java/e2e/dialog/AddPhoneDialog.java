package e2e.dialog;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddPhoneDialog {
    public AddPhoneDialog(WebDriver driver) {
        super();
    }

    @FindBy(id = "ngb-nav-9")
    private WebElement editButton;

    @FindBy(id = "btn-add-phone")
    private WebElement addPhoneNumber;

    @FindBy(id = "cc-select")
    private WebElement listOfCountries;

    @FindBy(css = "[value=\"+49\"]")
    private WebElement chooseCountryCodeGermany;

    @FindBy(id = "selected-cc")
    private WebElement inputPhoneNumberField;

    @FindBy(tagName = "button")
    private WebElement savePhoneNumberButton;

    @FindBy(xpath = "//*[@role='dialog']")
    private WebElement dialog;
    @FindBy(css = "a.nav-link[href='/contacts']")
    private WebElement addNewContact;

    @FindBy(id = "form-name")
    private WebElement firstNameInputField;

    @FindBy(id = "form-lastName")
    private WebElement lastNameInputField;

    @FindBy(id = "form-about")
    private WebElement aboutInputField;

    @FindBy(css = "button.btn.btn-primary")
    private WebElement saveButton;
}
