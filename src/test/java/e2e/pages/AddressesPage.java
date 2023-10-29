package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class AddressesPage extends Header{

    public AddressesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "ngb-nav-5")
    private WebElement addressTab;

    @FindBy(css = "[class=\"tab-pane active\"]")
    private WebElement addressTabPanel;

    @FindBy(id = "btn-add-phone")
    private WebElement addNewAddressButton;

    @FindBy(css = "[class=\"dropdown-toggle btn btn-outline-light btn-block\"]")
    private WebElement editRemoveButton;

    @FindBy(css = "[class=\"dropdown-item btn-address-edit\"]")
    private WebElement editAddress;
    @FindBy(css = "[class=\"dropdown-item btn-address-remove\"]")
    private WebElement removeAddress;

    @FindBy(css = "[class=\"col-street\"]")
    private WebElement streetElement;
    @FindBy(css = "[class=\"col-zip\"]")
    private WebElement zipElement;
    @FindBy(css = "[class=\"col-city\"]")
    private WebElement cityElement;

    @FindBy(css = "[role=\"alert\"]")
    private WebElement message;

    public void goToAddressTab(){
        addressTab.click();
    }

    public void clickAddNewAddressButton(){
        addNewAddressButton.click();
    }

    public void clickEditRemoveButton (){
        editRemoveButton.click();
    }

    public void editAddress(){
        editAddress.click();
    }

    public void removeAddress (){
        removeAddress.click();
    }

    public void waitForLoading(){
        getWait().forVisibility(addressTabPanel);
        getWait().forVisibility(addNewAddressButton);
    }

    public void waitForLoadingRemoveAddressLink(){
        getWait().forVisibility(removeAddress);
    }

    public void checkAddress(String city, String zip, String street){
        Assert.assertEquals(cityElement.getText(), city);
        Assert.assertEquals(zipElement.getText(), zip);
        Assert.assertEquals(streetElement.getText(), street);
    }


    public void alertMessageIsDisplayed(String alert){
       Assert.assertEquals(message.getText(), alert);
    }
}
