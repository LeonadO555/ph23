package e2e;

import api.contact.ContactApi;
import io.restassured.path.json.JsonPath;
import org.checkerframework.checker.units.qual.C;
import org.testng.Assert;
import org.testng.annotations.Test;
import schemas.ContactDTO;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AddEditDeleteContactApiTest {
    ContactApi contactApi;
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
    public void userCanWorkWithContactTest() {
        contactApi = new ContactApi();
        for (int i = 0; i < 2 ; i++) {
            // create and check
            JsonPath createdContactResponse = contactApi.createContact(201).jsonPath();
            int contactId = createdContactResponse.getInt("id");
            ContactDTO expectedData = contactApi.randomRequestBodyForCreateContact();
            JsonPath actualCreatedContact = contactApi.getContact(200, contactId).jsonPath();
            checkContactData(actualCreatedContact, expectedData);

            // edit and check
            contactApi.editContact(200, contactId);
            ContactDTO expectedEditedContact = contactApi.randomRequestBodyForEditContact(contactId);
            JsonPath actualEditedContact = contactApi.getContact(200, contactId).jsonPath();
            checkContactData(actualEditedContact, expectedEditedContact);


            // delete and check
            contactApi.deleteContact(200, contactId);
            contactApi.getContact(500, contactId);
        }
    }
}
