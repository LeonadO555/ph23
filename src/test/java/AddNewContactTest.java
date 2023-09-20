import org.testng.annotations.Test;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddNewContactTest extends BaseTest {


    @Test
    public void successAddNewContact() throws InterruptedException {
        LoginHelper loginHelper = new LoginHelper(app.driver);
        loginHelper.loginTestHelper();
        ContactsPage contactsPage = new ContactsPage(app.driver);
        sleep(2000);
        contactsPage.clickButtonAddNewContact();
        assertTrue(contactsPage.modalWindowIsDisplayed());
        AddContactDialog addContactDialog = new AddContactDialog(app.driver);
        addContactDialog.enterFirstName("Maria");
        addContactDialog.enterLastName("Marz");
        addContactDialog.enterAbout("123");
        addContactDialog.clickButtonSave();
        ContactInfoPage contactInfoPage = new ContactInfoPage(app.driver);
        sleep(2000);
        assertEquals(contactInfoPage.firstNameIsCorrect(), "Maria");
        assertEquals(contactInfoPage.lastNameIsCorrect(), "Marz");
        assertEquals(contactInfoPage.descriptionIsCorrect(), "123");
        contactInfoPage.clickButtonEdit();
        contactInfoPage.editAllInputFields("Maria9", "Marz9", "1239");
        contactInfoPage.clickButtonSave();
        contactInfoPage.clickButtonContact();
        contactsPage.clickSearchInputField();
        contactsPage.enterNameInputSearchField("Maria9");
        assertEquals(contactsPage.contactIsCorrect(), "MariaMaria9 MarzMarz9");
        contactsPage.clickToButtonDelete();
        DeleteContactPage deleteContactPage = new DeleteContactPage(app.driver);
        deleteContactPage.clickToCheckBox();
        deleteContactPage.clickButtonDeleteElement();
        assertTrue(deleteContactPage.alertTextIsDisplayed());

    }


}
