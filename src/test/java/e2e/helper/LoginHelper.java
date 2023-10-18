package e2e.helper;


import e2e.pages.BasePage;
import e2e.pages.ContactsPage;
import e2e.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginHelper extends BasePage {
    public LoginHelper(WebDriver driver) {
        super(driver);
    }

    public void loginTestHelper() throws InterruptedException {
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.waitForLoading();
        loginPage.enterEmail("test@gmail.com");
        loginPage.enterPassword("test@gmail.com");
        loginPage.clickOnLoginButton();
        ContactsPage contactsPage = new ContactsPage(this.driver);
       contactsPage.waitForLoading();
      //  Assert.assertTrue(contactsPage.contactsPageIsDisplayed());
      //  contactsPage.clickButtonAddNewContact();
       // Assert.assertTrue(contactsPage.modalWindowIsDisplayed());
    }
}
