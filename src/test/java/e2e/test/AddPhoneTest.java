package e2e.test;
import e2e.dialog.AddContactDialog;
import e2e.dialog.AddNewPhoneNumberDialog;
import e2e.pages.*;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class AddPhoneTest extends BaseTest{
    LoginHelper loginHelper;
    ContactsPage contactsPage;
    AddContactDialog addContactDialog;
    ContactInfoPage contactInfoPage;
    PhonesPage phonesPage;
    AddNewPhoneNumberDialog addNewPhoneNumberDialog;

    @Test
    public void successAddPhone(){
        String newContactName = "Michael";
        String newContactLastName = "Jordan";
        String contactDescription = "I'm a GOAT";
        String phoneNumber = "1122233";
        String expectedCode = "+49";

        List<String> contactsInfo = new ArrayList<>();
        contactsInfo.add("Michael");
        contactsInfo.add("Jordan");
        contactsInfo.add("I'm a GOAT");


        loginHelper = new LoginHelper(BaseTest.app.driver);
        loginHelper.loginTestHelper();

        contactsPage = new ContactsPage(BaseTest.app.driver);
        contactsPage.waitForLoading();
        contactsPage.clickOnAddNewContactLink();

        addContactDialog = new AddContactDialog(BaseTest.app.driver);
        addContactDialog.waitForLoading();
        addContactDialog.inputInfoForSaving(newContactName, newContactLastName, contactDescription);
        addContactDialog.saveContact();
        addContactDialog.waitForClose();

        contactInfoPage = new ContactInfoPage(app.driver);
        Assert.assertEquals(contactInfoPage.getContactInfo() + " not equal " + contactsInfo, contactInfoPage.getContactInfo(), contactsInfo);
        contactInfoPage.waitForLoading();

        phonesPage = new PhonesPage(app.driver);
        phonesPage.clickPhoneTab();
        phonesPage.waitForLoading();
        phonesPage.clickAddPhoneNumber();

        addNewPhoneNumberDialog = new AddNewPhoneNumberDialog(app.driver);
        addNewPhoneNumberDialog.waitForLoading();
        addNewPhoneNumberDialog.selectCountryCode();
        addNewPhoneNumberDialog.enterPhoneNumber(phoneNumber);
        addNewPhoneNumberDialog.savePhoneNumber();
        addNewPhoneNumberDialog.waitForClose();
        assertTrue(phonesPage.isPhoneCode(expectedCode));
        assertTrue(phonesPage.isPhoneNumber(phoneNumber));
    }

}
