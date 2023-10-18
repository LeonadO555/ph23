package e2e;

import e2e.pages.*;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;


public class AddPhoneTest extends BaseTest {
    LoginHelper loginHelper;
    ContactsPage contactsPage;
    AddContactDialog addContactDialog;
    ContactInfoPage contactInfoPage;
    PhonesPage phonesPage;
    AddNewPhoneNumberDialog addNewPhoneNumberDialog;

    @Test
    public void successAddPhone() {
        String newFirstName = "Jack";
        String newLastName = "Smith";
        String description = "a cool guy";
        String phoneNumber = "1234123";
        String expectedCode = "+49";

        List<String> contactsInfo = new ArrayList<>();
        contactsInfo.add("Jack");
        contactsInfo.add("Smith");
        contactsInfo.add("a cool guy");

        loginHelper = new LoginHelper(BaseTest.app.driver);
        loginHelper.loginTestHelper();

        contactsPage = new ContactsPage(BaseTest.app.driver);
        contactsPage.waitForLoading();
        contactsPage.clickAddNewContactLink();

        addContactDialog = new AddContactDialog(BaseTest.app.driver);
        addContactDialog.waitForLoading();
        addContactDialog.inputInfoForSaving(newFirstName, newLastName, description);
        addContactDialog.saveContact();
        addContactDialog.waitForClose();

        contactInfoPage = new ContactInfoPage(app.driver);
        contactInfoPage.waitForLoading();
        Assert.assertEquals(contactInfoPage.getContactInfo() + " not equal " + contactsInfo,
                contactInfoPage.getContactInfo(), contactsInfo);

        phonesPage = new PhonesPage(app.driver);
        phonesPage.clickPhoneTab();
        phonesPage.waitForLoading();
        phonesPage.clickAddPhoneNumberButton();

        addNewPhoneNumberDialog = new AddNewPhoneNumberDialog(app.driver);
        addNewPhoneNumberDialog.waitForLoading();
        addNewPhoneNumberDialog.selectCountryCode();
        addNewPhoneNumberDialog.enterPhoneNumber(phoneNumber);
        addNewPhoneNumberDialog.savePhoneNumber();
        addNewPhoneNumberDialog.waitForClose();

        phonesPage.waitForLoading();
        assertTrue(phonesPage.isPhoneCode(expectedCode));
        assertTrue(phonesPage.isPhoneNumber(phoneNumber));
    }
}