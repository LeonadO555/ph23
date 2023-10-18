package e2e.test;
import e2e.pages.ContactsPage;
import e2e.pages.LoginPage;
import org.junit.Test;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class AddPhoneTest extends BaseTest{
    @Test
    public void successAddPhone() throws InterruptedException {
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.enterEmail("test@gmail.com");
        loginPage.enterPassword("test@gmail.com");
        loginPage.clickOnLoginButton();
        ContactsPage contactsPage = new ContactsPage(app.driver);
        sleep(1000);
        assertTrue(contactsPage.contactsPageIsDisplayed());
    }
}
