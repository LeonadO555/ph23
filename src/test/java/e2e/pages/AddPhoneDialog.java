package e2e.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddPhoneDialog {
    @FindBy(id = "ngb-nav-9")
    private WebElement editButton;

    @FindBy(id = "btn-add-phone")
    private WebElement addNumberPhone;

    @FindBy(id = "cc-select")
    private WebElement listOfCountries;

    @FindBy(css = "[value=\"+49\"]")
    private WebElement chooseCountryCodeGermany;

    @FindBy(id = "selected-cc")
    private WebElement inputNumberField;

    @FindBy(tagName = "button")
    private WebElement savePhoneButton;

  /*  public void waitForLoading() {
        getWait().forVisibility(dialog);
        getWait().forVisibility(saveButton);

    }
    public void waitForClosing() {
        getWait().forInvisibility(dialog);
  */
}

