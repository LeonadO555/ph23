package e2e;

import api.contact.ContactApi;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import schemas.ContactDTO;

import java.util.LinkedHashMap;
import java.util.Map;

public class AddEditDeleteContactApiTest {
    ContactApi contactApi;

    private void checkContactData(JsonPath actualData, ContactDTO expectedData){
        LinkedHashMap<String,String> objectCreatedContact = new LinkedHashMap<>();
        objectCreatedContact.put(actualData.getString("firstName"), expectedData.getFirstName());
        objectCreatedContact.put(actualData.getString("lastName"), expectedData.getLastName());
        objectCreatedContact.put(actualData.getString("description"), expectedData.getDescription());

        for (Map.Entry<String,String> object: objectCreatedContact.entrySet()) {
            String actualResult = object.getKey();
            String expectedResult = object.getValue();
            Assert.assertEquals(actualResult,expectedResult, actualResult + " not equal " + expectedResult);
        }
    }

    @Test
    public void userCanWorkWithContactTest() {
        contactApi = new ContactApi();
        // create and check
        JsonPath createdContactResponse = contactApi.createContact(201).jsonPath();
        int contactId = createdContactResponse.getInt("id");
        ContactDTO expectedCreatedContact = contactApi.randomRequestBodyForCreateContact();
        JsonPath actualCreatedContact = contactApi.getContact(200, contactId).jsonPath();
        checkContactData(actualCreatedContact,expectedCreatedContact);

        // edit and check
        contactApi.editContact(200, contactId);
        ContactDTO expectedEditedContact = contactApi.randomRequestBodyForEditContact(contactId);
        JsonPath actualEditedContact = contactApi.getContact(200, contactId).jsonPath();
        checkContactData(actualEditedContact,expectedEditedContact);

        // delete and check
        contactApi.deleteContact(200, contactId);
        contactApi.getContact(500, contactId);
    }
}
