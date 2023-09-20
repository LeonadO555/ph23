import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginHelper extends BasePage {
    public LoginHelper(WebDriver driver) {super(driver);}

    public void loginTestHelper() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("test@gmail.com");
        loginPage.enterPassword("test@gmail.com");
        loginPage.clickOnLoginButton();
    }
}
