package e2e.test;

import e2e.dialog.AddContactDialog;
import e2e.dialog.RemoveContactDialog;
import e2e.pages.*;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddContactTest extends BaseTest {
    LoginHelper loginHelper;
    ContactsPage contactsPage;
    AddContactDialog addContactDialog;
    ContactInfoPage contactInfoPage;
    RemoveContactDialog removeContactDialog;

    @Test
    public void addContactTest() {
        String newContactName = "Miguel Hernandez";
        String newContactLastName = "Cabrera";

        List<String> contactsInfo = new ArrayList<>();
        contactsInfo.add("Miguel Hernandez");
        contactsInfo.add("Cabrera");
        contactsInfo.add("Student");

        String changedName = "Shahei";
        String changedLastName = "Othani";

        loginHelper = new LoginHelper(BaseTest.app.driver);
        loginHelper.loginTestHelper();

        contactsPage = new ContactsPage(BaseTest.app.driver);
        contactsPage.waitForLoading();
        contactsPage.clickOnAddNewContactLink();

        addContactDialog = new AddContactDialog(BaseTest.app.driver);
        addContactDialog.waitForLoading();
        addContactDialog.inputInfoForSaving(newContactName, newContactLastName, "Student");
        addContactDialog.saveContact();
        addContactDialog.waitForClose();

        contactInfoPage = new ContactInfoPage(BaseTest.app.driver);
        contactInfoPage.waitForLoading();
        Assert.assertEquals(contactInfoPage.getContactInfo() + " not equal " + contactsInfo, contactInfoPage.getContactInfo(), contactsInfo);
        contactInfoPage.goToContactsPage();

        contactsPage.waitForLoading();
        contactsPage.searchContact(newContactName);
        String newContactNameFromList = contactsPage.readValueFromNewContact();
        assertEquals(newContactName, newContactNameFromList);
        contactsPage.clickOnNewContactNameLinkFromList();


        assertTrue(contactInfoPage.isEditButtonDisplayed());
        contactInfoPage.clickOnEditButton();

        contactInfoPage.editName(changedName);
        contactInfoPage.editLastName(changedLastName);
        contactInfoPage.clickOnSaveButton();
        assertTrue(contactInfoPage.isEditButtonDisplayed());
        contactInfoPage.goToContactsPage();

        contactsPage.waitForLoading();
        contactsPage.searchContact(changedName + changedLastName);
        String changedContactNameFromList = contactsPage.readValueFromNewContact();
        assertEquals(changedName, changedContactNameFromList);
        contactsPage.deleteContact();

        removeContactDialog = new RemoveContactDialog(BaseTest.app.driver);
        removeContactDialog.waitForLoading();
        removeContactDialog.clickCheckbox();
        removeContactDialog.clickOnRemoveContactButton();
        removeContactDialog.waitForClose();

        contactsPage.waitForLoading();
        assertTrue(contactsPage.isNoResultsDisplayed());
    }
}