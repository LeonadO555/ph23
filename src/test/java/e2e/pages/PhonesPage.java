package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PhonesPage extends Header {

    public PhonesPage(WebDriver driver) {
        super(driver);
    }



    @FindBy(css = "[ng-reflect-_id=\"2\"]")
    private WebElement phonesTab;

    @FindBy(css = "[class=\"mt-1 tab-content\"]")
    private WebElement tabContent;

    @FindBy(id = "btn-add-phone")
    private WebElement addPhoneNumberButton;

    @FindBy(className = "row-table-cc")
    private WebElement savedPhoneCode;

    @FindBy(className = "row-table-pn")
    private WebElement savedPhoneNumber;


    public void waitForLoading(){
        getWait().forVisibility(addPhoneNumberButton);
        getWait().forVisibility(tabContent);
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
