package e2e;

import api.contact.ContactApi;
import e2e.pages.ContactsPage;
import e2e.pages.LoginHelper;
import io.restassured.path.json.JsonPath;
import org.checkerframework.checker.units.qual.C;
import org.testng.annotations.Test;

public class AddPhoneForCreatedContactViaApi extends BaseTest{
    ContactApi contactApi;
    LoginHelper loginHelper;
    ContactsPage contactsPage;

    @Test
    public void addPhoneForCreatedContactViaApiTest() {
        contactApi = new ContactApi();
        JsonPath createdContact = contactApi.createContact(201).jsonPath();
        int contactId = createdContact.getInt("id");

        loginHelper = new LoginHelper(app.driver);
        loginHelper.loginTestHelper();

        contactsPage = new ContactsPage(app.driver);
        contactsPage.waitForLoading();
        contactsPage.openContactByContactId(contactId);
    }
}
