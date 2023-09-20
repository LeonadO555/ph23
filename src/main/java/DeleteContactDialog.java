import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteContactDialog extends BasePage {
    public DeleteContactDialog(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "img[src='/assets/icons/trash.svg']")
    private WebElement deleteButton;

    @FindBy(id = "check-box-remove-contact")
    private WebElement deleteCheckbox;

    @FindBy(id = "submit-remove")
    private WebElement submitDeleting;

    public void clickOnDeleteCheckbox(){
        deleteCheckbox.click();
    }

    public void clickOnSubmitDeletingBtn(){
        submitDeleting.click();
    }
}
