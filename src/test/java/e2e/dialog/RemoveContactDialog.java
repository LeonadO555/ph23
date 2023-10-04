package e2e.dialog;

import e2e.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RemoveContactDialog extends BasePage {
    public RemoveContactDialog(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@role='dialog']")
    private WebElement dialog;
    @FindBy(id= "check-box-remove-contact")
    private WebElement confirmCheckbox;

    @FindBy(id= "submit-remove")
    private WebElement removeContactButton;



    public void waitForLoading(){
        getWait().forVisibility(dialog);
        getWait().forVisibility(confirmCheckbox);
        getWait().forVisibility(removeContactButton);
    }
    public void clickCheckbox(){
        confirmCheckbox.click();
    }

    public void clickOnRemoveContactButton(){
        removeContactButton.click();
    }


    public void waitForClose(){
        getWait().forInvisibility(dialog);
    }


}
