package e2e.test;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import e2e.dialogs.AddContactDialog;
import e2e.helper.LoginHelper;
import e2e.pages.ContactInfoPage;
import e2e.pages.ContactsPage;
import e2e.dialogs.DeleteContactDialog;
import org.junit.Assert;
import org.testng.annotations.Test;

public class AddNewContactTest extends BaseTest {
    public AddNewContactTest() {
    }

    @Test
    public void successAddNewContact() throws InterruptedException {
        String firstName = "Maria";
        String lastName = "Marz";
        String about = "123";

        LoginHelper loginHelper = new LoginHelper(app.driver);
        loginHelper.loginTestHelper();
        ContactsPage contactsPage = new ContactsPage(app.driver);
        contactsPage.clickButtonAddNewContact();
        Assert.assertTrue(contactsPage.modalWindowIsDisplayed());

        AddContactDialog addContactDialog = new AddContactDialog(app.driver);
        addContactDialog.waitForLoading();
        addContactDialog.enterFirstName("Maria");
        addContactDialog.enterLastName("Marz");
        addContactDialog.enterAbout("123");
        addContactDialog.clickButtonSave();
        addContactDialog.waitForClosed();

        ContactInfoPage contactInfoPage = new ContactInfoPage(app.driver);
        contactInfoPage.waitForLoading();
        Assert.assertEquals(contactInfoPage.firstNameIsCorrect(), "Maria");
        Assert.assertEquals(contactInfoPage.lastNameIsCorrect(), "Marz");
        Assert.assertEquals(contactInfoPage.descriptionIsCorrect(), "123");
        contactInfoPage.clickButtonEdit();
        contactInfoPage.editAllInputFields("Maria9", "Marz9", "1239");
        contactInfoPage.clickButtonSave();
        contactInfoPage.clickButtonContact();
        contactsPage.clickSearchInputField();
        contactsPage.enterNameInputSearchField("Maria9");
        Assert.assertEquals(contactsPage.contactIsCorrect(), "MariaMaria9 MarzMarz9");
        contactsPage.clickToButtonDelete();

        DeleteContactDialog deleteContactPage = new DeleteContactDialog(app.driver);
        deleteContactPage.waitForLoading();
        deleteContactPage.clickToCheckBox();
        deleteContactPage.clickButtonDeleteElement();
        Assert.assertTrue(deleteContactPage.alertTextIsDisplayed());
        deleteContactPage.waitForClosed();
    }
}
