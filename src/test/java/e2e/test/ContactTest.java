package e2e.test;

import e2e.dialog.ContactAddDialog;
import e2e.dialog.DeleteContactDialog;
import e2e.pages.ContactsPage;
import e2e.pages.LoginPage;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class ContactTest extends BaseTest{

    @Test
    public void addingNewContact() throws InterruptedException {
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
        contactAddDialog.setEnterFirstName("Anton7777");
        contactAddDialog.setEnterLastName("Ojjjjj");
        contactAddDialog.setAboutField("Nothing to tell");
        contactAddDialog.clickOnSaveButton();
        contactAddDialog.contactInformationHeaderIsDisplayed();
        sleep(1000);
        assertTrue(contactAddDialog.firstNameHasText("Anton7777"));
        assertTrue(contactAddDialog.lastNameHasText("Ojjjjj"));
        assertTrue(contactAddDialog.aboutFieldHasText("Nothing to tell"));

        contactsPage.clickOnEditContact();
        contactsPage.clickOnEditContactDescriptionField();
        contactsPage.clearDescriptionField();
        contactsPage.updateAboutField("Nothing new");
        contactsPage.clickOnSaveButtonInEditContact();
        contactsPage.clickOnContactsBtn();
        contactsPage.clickOnSearchForm();
        contactsPage.enterInSearchField("Anton7777");
        contactsPage.deleteContact("Anton7777");

        DeleteContactDialog deleteContactDialog = new DeleteContactDialog(app.driver);
        deleteContactDialog.waitForLoading();
        deleteContactDialog.clickOnDeleteCheckbox();
        deleteContactDialog.clickOnSubmitDeletingBtn();
        deleteContactDialog.waitForClosed();
    }

}