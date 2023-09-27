package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RemoveContactDialog extends BasePage {
    public RemoveContactDialog(WebDriver driver) {
        super(driver);
    }

    @FindBy(id= "check-box-remove-contact")
    private WebElement checkboxDelitionConfirm;

    @FindBy(id= "submit-remove")
    private WebElement removeContactButton;


    public void clickCheckbox(){
        checkboxDelitionConfirm.click();
    }

    public void clickOnRemoveContactButton(){
        removeContactButton.click();
    }

    public boolean isCheckBoxIsDisplayed(){
       return checkboxDelitionConfirm.isDisplayed();
    }
}
