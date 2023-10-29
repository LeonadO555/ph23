package e2e.e2E_plus_API;

import api.contact.ContactApi;
import com.github.javafaker.Faker;
import e2e.BaseTest;
import e2e.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.junit.Assert.assertTrue;


public class userCanAddEditDeleteEmailViaUI extends BaseTest {
    ContactApi contactApi;
    LoginHelper loginHelper;
    ContactsPage contactsPage;
    AddEditEmailDialog addEditEmailDialog;
    EmailsPage emailsPage;
    ContactInfoPage contactInfoPage;
    Header header;
    RemoveContactDialog removeContactDialog;
    Faker faker = new Faker();

    String email = faker.internet().emailAddress();
    String editEmail = faker.internet().emailAddress();
    String successRemoveMessage = "Email removed";

  /*
            В этом тесте я,
                     при помощи API создаю КОНТАКТ
                     при помощи UI создаю, редактирую и удаляю EMAIL
                     при помощи UI удаляю КОНТАКТ
  */
    @Test
    public void userCanAddEditDeleteEmail_E2E_API()  {
        contactApi = new ContactApi();
        loginHelper = new LoginHelper(app.driver);
        contactsPage = new ContactsPage(app.driver);
        emailsPage = new EmailsPage(app.driver);
        contactInfoPage = new ContactInfoPage(app.driver);
        addEditEmailDialog = new AddEditEmailDialog(app.driver);
        header =new Header(app.driver);
        removeContactDialog = new RemoveContactDialog(app.driver);

        int contactId = contactApi.createContact(201).jsonPath().getInt("id");
        loginHelper.loginTestHelper();

        contactsPage.openContactByContactId(contactId);
        contactInfoPage.waitForLoading();

        emailsPage.goToEmailsTab();
        emailsPage.waitForLoading();
        emailsPage.clickAddEmailButton();

        addEditEmailDialog.waitForLoading();
        addEditEmailDialog.inputEmail(email);
        addEditEmailDialog.saveEmail();
        addEditEmailDialog.waitForClosing();

        emailsPage.waitForLoading();
        String actualEmail = emailsPage.checkEmail();
        Assert.assertEquals(actualEmail, email, actualEmail + " not equal " + email);
        emailsPage.clickEditRemoveButton();
        emailsPage.waitForLoadingEditEmailLink();
        emailsPage.clickEditEmail();

        addEditEmailDialog.waitForLoading();
        addEditEmailDialog.inputEditEmail(editEmail);
        addEditEmailDialog.saveEmail();
        addEditEmailDialog.waitForClosing();

        emailsPage.waitForLoading();
        String actualEditEmail = emailsPage.checkEmail();
        Assert.assertEquals(actualEditEmail, editEmail, actualEditEmail + " not equal " + editEmail);
        emailsPage.clickEditRemoveButton();
        emailsPage.waitForLoadingRemoveEmailLink();
        emailsPage.clickRemoveEmail();
        emailsPage.alertMessageIsDisplayed(successRemoveMessage);

        header.goToContactsPage();

        contactsPage.waitForLoading();
        contactsPage.openContactByContactId(contactId);
        contactInfoPage.waitForLoading();
        String firstName = contactInfoPage.getFirstNameText();
        String lastName = contactInfoPage.getLastNameText();

        header.goToContactsPage();

        contactsPage.waitForLoading();
        contactsPage.searchContact(firstName+lastName);
        contactsPage.clickDeleteContactButton();

        removeContactDialog.waitForLoading();
        removeContactDialog.clickCheckbox();
        removeContactDialog.clickOnRemoveContactButton();
        removeContactDialog.waitForClose();

        contactsPage.waitForLoading();
        assertTrue(contactsPage.isNoResultsDisplayed());

    }
}
