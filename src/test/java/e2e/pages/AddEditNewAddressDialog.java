package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEditNewAddressDialog extends BasePage{
    public AddEditNewAddressDialog(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[role=\"dialog\"]")
    private WebElement addEditDialog;

    @FindBy(id = "cc-select")
    private WebElement selectCountry;

    @FindBy(css = "[ng-reflect-value=\"Germany\"]")
    private WebElement countryGermany;

    @FindBy(css = "[ng-reflect-value=\"Denmark\"]")
    private WebElement countryDenmark;

    @FindBy(id = "input-city")
    private WebElement inputCity;

    @FindBy(id = "input-zip")
    private WebElement inputPostcode;

    @FindBy(id = "input-street")
    private WebElement inputStreet;

    @FindBy(css = "[class=\"btn btn-primary btn-block\"]")
    private WebElement saveButton;


    public void waitForLoading(){
        getWait().forVisibility(selectCountry);
        getWait().forVisibility(inputCity);
        getWait().forVisibility(inputPostcode);
        getWait().forVisibility(inputStreet);
        getWait().forVisibility(saveButton);
    }

    public void selectCountry(){
        selectCountry.click();
    }

    public void selectGermany(){
        countryGermany.click();
    }
    public void selectDenmark(){
        countryDenmark.click();
    }

    public void fillInAddress(String city, String postcode, String street){
        inputCity.sendKeys(city);
        inputPostcode.isDisplayed();
        inputPostcode.sendKeys(postcode);
        inputStreet.isDisplayed();
        inputStreet.sendKeys(street);
    }

    public void editFillInAddress(String city, String postcode, String street){
        inputCity.clear();
        inputCity.sendKeys(city);
        inputPostcode.clear();
        inputPostcode.sendKeys(postcode);
        inputStreet.clear();
        inputStreet.sendKeys(street);
    }
    public void clickSaveButton (){
        saveButton.click();
    }

   public void waitForClosing(){
        getWait().forInvisibility(addEditDialog);
   }
}
