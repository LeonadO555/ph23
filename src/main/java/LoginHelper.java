
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

public class LoginHelper extends BasePage {


    public LoginHelper(WebDriver driver) {
        super(driver);
    }

    public void loginTestHelper() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("test@gmail.com", "test@gmail.com"); // успешно login

        HeaderPage header = new HeaderPage(driver);
        assertTrue(header.isHeaderPresent()); // проверяем, что перешли на новую страницу
    }
}
