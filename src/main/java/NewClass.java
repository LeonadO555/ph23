import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewClass extends BasePage{
    public NewClass(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h5")
    private WebElement contactInformationHeader;
    @FindBy(css = "a.nav-link[routerlink='']")
    private WebElement contactsList;

}
