import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteContactDialog extends BasePage {
    public DeleteContactDialog(WebDriver driver) {super(driver);}


    @FindBy(css = "img[src='/assets/icons/trash.svg']")
    private WebElement deleteButton;
    @FindBy(id = "check-box-remove-contact")
    private WebElement deleteContactCheckbox;
    @FindBy(id = "submit-remove")
    private WebElement deleteContactButton;

    public void deleteContact() {
        deleteButton.click();
    }
    public void setDeleteContactCheckbox() {
        deleteContactCheckbox.click();
    }
    public void clickDeleteContactButton() {
        deleteContactCheckbox.click();
    }
}
