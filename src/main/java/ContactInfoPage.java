import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactInfoPage extends BasePage{
    public ContactInfoPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "button.btn.btn-primary")
    private WebElement saveButton;
    @FindBy(css = "h5")
    private WebElement contactInformationHeader;
    @FindBy(css = "a.nav-link[routerlink='']")
    private WebElement contactsList;
    @FindBy(css = "input[formcontrolname='searchInput']\"")
    private WebElement searchInputForm;
    @FindBy(css = "b")
    private WebElement foundContact;
    @FindBy(css = "img[src='/assets/icons/trash.svg']")
    private WebElement deleteButton;
}
