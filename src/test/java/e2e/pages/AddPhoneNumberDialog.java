package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AddPhoneNumberDialog extends Header{

    public AddPhoneNumberDialog(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@role='dialog']")
    private WebElement dialog;

    @FindBy(id = "cc-select")
    private WebElement countryCodeSelect;

    @FindBy(css = "[ng-reflect-value='+49']")
    private WebElement germanyCode;

    @FindBy(id= "selected-cc")
    private WebElement phoneNumberInput;

    @FindBy(css = "[class='btn btn-primary']")
    private WebElement phoneSaveButton;


    public void waitForLoading(){
        getWait().forVisibility(dialog);
        getWait().forVisibility(phoneSaveButton);
    }

    public void waitForClose(){
        getWait().forInvisibility(dialog);
    }


    public void selectCountryCode(){
        germanyCode.click();
    }

    public void enterPhoneNumber(String phoneNumber){
        phoneNumberInput.sendKeys(phoneNumber);
    }

    public void savePhoneNumber(){
        phoneSaveButton.click();
    }



}
