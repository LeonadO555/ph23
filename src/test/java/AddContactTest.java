import org.testng.Assert;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

public class AddContactTest extends BaseTest {

    @Test
    public void AddContactTest() {
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.enterEmail("test@gmail.com");
        loginPage.enterPassword("test@gmail.com");
        loginPage.clickOnLoginButton();

        ContactsPage contactsPage = new ContactsPage(app.driver);
        assertTrue(contactsPage.contactsPageIsDisplayed());
        contactsPage.addNewContact();

        AddContactDialog addContactDialog = new AddContactDialog(app.driver);
        String firstName = "Ivan";
        String lastName = "Petrov";
        String aboutDescription = "a cool guy";
        addContactDialog.setFirstNameInputField(firstName);
        addContactDialog.setLastNameInputField(lastName);
        addContactDialog.setAboutInputField(aboutDescription);
        addContactDialog.clickSaveButton();

        ContactsInfoPage contactsInfoPage = new ContactsInfoPage(app.driver);
        Assert.assertTrue(contactsInfoPage.contactsPageIsDisplayed());
        Assert.assertEquals(contactsInfoPage.getFirstName(), firstName);
        Assert.assertEquals(contactsInfoPage.getLastName(), lastName);
        Assert.assertEquals(contactsInfoPage.getAbout(), aboutDescription);

        String newFirstName = "Petr";
        String newLastName = "Ivanov";
        String newAboutDescription = "a bad guy";
        contactsInfoPage.clickOnEditContactButton();
        EditContactsInfoPage editContactsInfoPage = new EditContactsInfoPage(app.driver);
        editContactsInfoPage.setFirstNameInput(newFirstName);
        editContactsInfoPage.setLastNameInput(newLastName);
        editContactsInfoPage.setEditDescriptionTextarea(newAboutDescription);
        editContactsInfoPage.clickOnSaveButton();

        Assert.assertTrue(contactsInfoPage.contactsPageIsDisplayed());
        Assert.assertEquals(contactsInfoPage.getFirstName(), newFirstName);
        Assert.assertEquals(contactsInfoPage.getLastName(), newLastName);
        Assert.assertEquals(contactsInfoPage.getAbout(), newAboutDescription);

        contactsPage.clickContactList();
        Assert.assertTrue(contactsPage.contactsPageIsDisplayed());
        contactsPage.searchContact(newFirstName);

        DeleteContactDialog deleteContactDialog = new DeleteContactDialog(app.driver);
        deleteContactDialog.deleteContact();
        deleteContactDialog.setDeleteContactCheckbox();
        deleteContactDialog.clickDeleteContactButton();
        contactsPage.searchContact(newFirstName);
        Assert.assertTrue(contactsPage.alertMessageIsDisplayed());
    }
}
