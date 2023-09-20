import org.openqa.selenium.WebDriver;

import static java.lang.Thread.sleep;
import static org.bouncycastle.oer.its.ieee1609dot2.EndEntityType.app;
import static org.junit.Assert.assertTrue;

public class LoginHelper extends BasePage{
    public LoginHelper(WebDriver driver) {
        super(driver);
    }

    public void loginTestHelper() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("test@gmail.com");
        loginPage.enterPassword("test@gmail.com");
        loginPage.clickOnLoginButton();
        ContactsPage contactsPage = new ContactsPage(driver);
        sleep(1000);
        assertTrue(contactsPage.contactsPageIsDisplayed());
        contactsPage.clickButtonAddNewContact();
        assertTrue(contactsPage.modalWindowIsDisplayed());

    }
}
