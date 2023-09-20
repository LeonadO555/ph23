import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteContactPage extends BasePage{
    public DeleteContactPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "check-box-remove-contact")
    private WebElement checkBox;

    @FindBy(id = "submit-remove")
    private WebElement buttonDeleteElem;

    @FindBy(xpath = "//*[@class='alert text-center alert-warning']")
    private WebElement alertText;

    public void clickToCheckBox(){
        checkBox.click();
    }

    public void clickButtonDeleteElement(){
        buttonDeleteElem.click();
    }

    public boolean alertTextIsDisplayed(){
        return alertText.isDisplayed();
    }
}
