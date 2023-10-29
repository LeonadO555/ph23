package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class EmailsPage extends Header{
    public EmailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css ="[ng-reflect-_id=\"3\"]")
    private WebElement emailTab;

    @FindBy(css = "[class=\"tab-pane active\"]")
    private WebElement emailTabPanel;

    @FindBy(id = "btn-add-phone")
    private WebElement addEmailButton;

    @FindBy(css = "[class=\"row-table w-95\"]")
    private WebElement savedEmail;

    @FindBy(css = "[class=\"dropdown-toggle btn btn-outline-light btn-block\"]")
    private WebElement editRemoveButton;
    @FindBy(css = "[class=\"dropdown-item btn-email-edit\"]")
    private WebElement editEmail;
    @FindBy(css = "[class=\"dropdown-item btn-email-remove\"]")
    private WebElement removeEmail;
    @FindBy(css = "[role=\"alert\"]")
    private WebElement message;





    public void goToEmailsTab(){
        emailTab.click();
    }

    public String checkEmail(){
        return savedEmail.getText();
    }

    public void clickAddEmailButton(){
        addEmailButton.click();
    }

    public void waitForLoadingEditEmailLink(){
        getWait().forVisibility(editEmail);
    }
    public void clickEditEmail(){
        editEmail.click();
    }

    public void clickEditRemoveButton (){
        editRemoveButton.click();
    }

    public void waitForLoadingRemoveEmailLink(){
        getWait().forVisibility(removeEmail);
    }
    public void clickRemoveEmail(){
        removeEmail.click();
    }

    public void waitForLoading(){
        getWait().forVisibility(emailTabPanel);
        getWait().forVisibility(addEmailButton);
    }

    public void alertMessageIsDisplayed(String alert){
        Assert.assertEquals(message.getText(), alert);
    }


}
