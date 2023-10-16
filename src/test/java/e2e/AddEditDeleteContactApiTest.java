package e2e;

import api.contact.ContactApi;
import io.restassured.path.json.JsonPath;
import org.checkerframework.checker.units.qual.C;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AddEditDeleteContactApiTest {
    ContactApi contactApi;

    @Test
    public void userCanWorkWithContactTest() {
        contactApi = new ContactApi();
        for (int i = 0; i < 10 ; i++) {
            // create and check
            JsonPath createdContactResponse = contactApi.createContact(201).jsonPath();
            int contactId = createdContactResponse.getInt("id");
            String expectedFirstName = contactApi.randomRequestBodyForCreateContact().getFirstName();
            JsonPath actualCreatedContact = contactApi.getContact(200, contactId).jsonPath();
            String actualFirstName = actualCreatedContact.getString("firstName");
            Assert.assertEquals(actualFirstName, expectedFirstName);

            // edit and check
            contactApi.editContact(200, contactId);
            String expectedEditedFirstName = contactApi.randomRequestBodyForEditContact(contactId).getFirstName();
            JsonPath actualEditedContact = contactApi.getContact(200, contactId).jsonPath();
            String actualEditedFirstName = actualEditedContact.getString("firstName");
            Assert.assertEquals(actualEditedFirstName, expectedEditedFirstName);

            // delete and check
            contactApi.deleteContact(200, contactId);
            contactApi.getContact(500, contactId);
        }
    }
}
