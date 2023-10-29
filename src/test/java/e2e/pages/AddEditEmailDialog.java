package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEditEmailDialog extends BasePage{
    public AddEditEmailDialog(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "input-email")
    private WebElement inputEmail;

    @FindBy(css = "[class=\"btn btn-primary\"]")
    private WebElement saveButton;

    @FindBy(id = "add-email-modal")
    private WebElement addEmailModalHeader;



    public void inputEmail(String email){
        inputEmail.sendKeys(email);
    }

    public void inputEditEmail(String email){
       inputEmail.clear();
       inputEmail.sendKeys(email);
    }
    public void saveEmail(){
        saveButton.click();
    }

    public void waitForLoading(){
        getWait().forVisibility(inputEmail);
        getWait().forVisibility(saveButton);
    }

    public void waitForClosing(){
        getWait().forInvisibility(addEmailModalHeader);
        getWait().forInvisibility(saveButton);
    }
}
