package e2e.test;

import e2e.dialog.ContactAddDialog;
import e2e.pages.ContactsPage;
import e2e.pages.LoginPage;
import org.junit.Test;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class AddPhoneTest extends BaseTest{



    @Test
    public void addingAPhoneNumber() throws InterruptedException {
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.enterEmail("test@gmail.com");
        loginPage.enterPassword("test@gmail.com");
        loginPage.clickOnLoginButton();

        ContactsPage contactsPage = new ContactsPage(app.driver);
        contactsPage.waitForLoading();

        ContactAddDialog contactAddDialog = new ContactAddDialog(app.driver);
        contactAddDialog.waitForLoading();
        contactAddDialog.clickOnAddNewContactButton();
        contactAddDialog.setEnterFirstName("AntonMMM");
        contactAddDialog.setEnterLastName("Lytutgf");
        contactAddDialog.setAboutField("Nothing to tell");
        contactAddDialog.clickOnSaveButton();
        contactAddDialog.contactInformationHeaderIsDisplayed();
        sleep(1000);


    }
}
