package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PhonesPage extends Header {

    public PhonesPage(WebDriver driver) {
        super(driver);
    }



    @FindBy(xpath = "(//*[@role=\"tab\"])[2]")
    private WebElement phonesTab;

    @FindBy(id = "btn-add-phone")
    private WebElement addPhoneNumberButton;

    @FindBy(className = "row-table-cc")
    private WebElement savedPhoneCode;

    @FindBy(className = "row-table-pn")
    private WebElement savedPhoneNumber;


    public void waitForLoading(){
        getWait().forVisibility(addPhoneNumberButton);
    }


    public void clickPhoneTab(){
        phonesTab.click();
    }

    public void clickAddPhoneNumberButton(){
        addPhoneNumberButton.click();
    }

    public boolean isPhoneCode(String expectedCode){
        return  savedPhoneCode.getText().contains(expectedCode);
    }
    public boolean isPhoneNumber(String expectedPhoneNumber){
        return  savedPhoneNumber.getText().contains(expectedPhoneNumber);
    }


}
