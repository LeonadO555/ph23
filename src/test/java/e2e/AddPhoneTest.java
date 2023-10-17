package e2e;

import e2e.pages.*;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class AddPhoneTest extends BaseTest {
    LoginHelper loginHelper;
    ContactsPage contactsPage;
    AddContactDialog addContactDialog;
    ContactInfoPage contactInfoPage;
    PhonesPage phonesPage;
    AddPhoneNumberDialog addNewPhoneNumberDialog;
    Header header;
    RemoveContactDialog removeContactDialog;

    @Test
    public void successAddPhoneForNewContact() {
        String newContactName = "Contato";
        String newContactLastName = "Novo";
        String contactDescription = "Sortudo";
        String phoneNumber = "1234123";
        String expectedCode = "+49";

        List<String> contactsInfo = new ArrayList<>();
        contactsInfo.add("Contato");
        contactsInfo.add("Novo");
        contactsInfo.add("Sortudo");

        loginHelper = new LoginHelper(app.driver);
        loginHelper.loginTestHelper();

        contactsPage = new ContactsPage(app.driver);
        contactsPage.waitForLoading();
        contactsPage.clickAddNewContactLink();

        addContactDialog = new AddContactDialog(app.driver);
        addContactDialog.waitForLoading();
        addContactDialog.inputInfoForSaving(newContactName, newContactLastName, contactDescription);
        addContactDialog.saveContact();
        addContactDialog.waitForClose();

        contactInfoPage = new ContactInfoPage(app.driver);
        contactInfoPage.waitForLoading();
        Assert.assertEquals(contactInfoPage.getContactInfo() + " not equal " + contactsInfo, contactInfoPage.getContactInfo(), contactsInfo);


        phonesPage = new PhonesPage(app.driver);
        phonesPage.clickPhoneTab();
        phonesPage.waitForLoading();
        phonesPage.clickAddPhoneNumberButton();

        addNewPhoneNumberDialog = new AddPhoneNumberDialog(app.driver);
        addNewPhoneNumberDialog.waitForLoading();
        addNewPhoneNumberDialog.selectCountryCode();
        addNewPhoneNumberDialog.enterPhoneNumber(phoneNumber);
        addNewPhoneNumberDialog.savePhoneNumber();
        addNewPhoneNumberDialog.waitForClose();

        phonesPage.waitForLoading();
        assertTrue(phonesPage.isPhoneCode(expectedCode));
        assertTrue(phonesPage.isPhoneNumber(phoneNumber));

        header = new Header(app.driver);
        header.goToContactsPage();

        contactsPage.waitForLoading();
        contactsPage.searchContact(newContactName); // ищу контакт по изменённому имени + фамилии
        String changedContactNameFromContactsLIst = contactsPage.readValueFromNewContact();
        assertEquals(newContactName, changedContactNameFromContactsLIst); // проверяю, совпадает ли имя изменённого контакта с тем, что вышло в результате поиска.
        contactsPage.deleteContact();

        removeContactDialog = new RemoveContactDialog(app.driver);
        removeContactDialog.waitForLoading();
        removeContactDialog.clickCheckbox();
        removeContactDialog.clickOnRemoveContactButton();
        removeContactDialog.waitForClose();

        contactsPage.waitForLoading();
        assertTrue(contactsPage.isNoResultsDisplayed());


    }

}
