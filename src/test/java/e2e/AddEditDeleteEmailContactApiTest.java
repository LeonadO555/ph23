package e2e;

import api.contact.ContactApi;
import api.email.EmailApi;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import schemas.ContactDTO;
import schemas.EmailDTO;

import java.util.LinkedHashMap;
import java.util.Map;

public class AddEditDeleteEmailContactApiTest {
    ContactApi contactApi;
    EmailApi emailApi;
    private void checkContactData(JsonPath actualData, ContactDTO expectedData) {
        LinkedHashMap<String, String> objectCreatedContact = new LinkedHashMap<>();
        objectCreatedContact.put(actualData.getString("firstName"), expectedData.getFirstName());
        objectCreatedContact.put(actualData.getString("lastName"), expectedData.getLastName());
        objectCreatedContact.put(actualData.getString("description"), expectedData.getDescription());

        for (Map.Entry<String, String> object: objectCreatedContact.entrySet()) {
            String actualResult = object.getKey();
            String expectedCreatedContact = object.getValue();
            Assert.assertEquals(actualResult, expectedCreatedContact, actualResult + " not equal " + expectedCreatedContact);
        }
    }

    @Test
    public void userCanAddEditDeleteEmailViaApi() {
        contactApi = new ContactApi();
        emailApi = new EmailApi();

            // create contact and check
            JsonPath createdContactResponse = contactApi.createContact(201).jsonPath();
            int contactId = createdContactResponse.getInt("id");
            ContactDTO expectedData = contactApi.randomRequestBodyForCreateContact();
            JsonPath actualCreatedContact = contactApi.getContact(200, contactId).jsonPath();
            checkContactData(actualCreatedContact, expectedData);

            // create and edit email
            emailApi.createEmail(201, contactId);
            JsonPath allEmails = emailApi.getAllEmails(200, contactId).jsonPath();
            int emailId = allEmails.getInt("[0].id");

            emailApi.editEmail(200, emailId, contactId);
            EmailDTO expectedEditedEmail = emailApi.randomRequestBodyForEditEmail(emailId, contactId);
            JsonPath actualEditedEmail = emailApi.getEmail(200, emailId).jsonPath();
            Assert.assertEquals(actualEditedEmail.getString("email"), expectedEditedEmail.getEmail(), actualEditedEmail + " not equal " + expectedEditedEmail);

            // delete email
            emailApi.deleteEmail(200, emailId);
            Response errorMessageEmail = emailApi.getEmail(500, emailId);
            Assert.assertEquals(errorMessageEmail.jsonPath().getString("message"), "Error! This email doesn't exist in our DB");

            // delete and check contact
            contactApi.deleteContact(200, emailId);
            Response errorMessageContact = contactApi.getContact(500, emailId);
            Assert.assertEquals(errorMessageContact.jsonPath().getString("message"),
                    "Error! This contact doesn't exist in our DB");
        }
}
