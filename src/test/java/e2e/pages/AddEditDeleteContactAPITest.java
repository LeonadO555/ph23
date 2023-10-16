package e2e.pages;

import api.contact.ContactApi;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AddEditDeleteContactAPITest {

    ContactApi contactApi;

    @Test
    public void userCanWorkWithContactTest(){

        contactApi = new ContactApi();
        for (int i = 0; i < 5 ; i++) {
            // create and check
            JsonPath createdContactResponse = contactApi.createContact(201).jsonPath();
            int contactId = createdContactResponse.getInt("id");
            String expectedFirstName = contactApi.randomRequestBodyForCreatingContact().getFirstName();
            JsonPath actualCreatedContact = contactApi.getContact(200, contactId).jsonPath();
            String actualFirstName = actualCreatedContact.getString("firstName");
            Assert.assertEquals(actualFirstName, expectedFirstName);

            // edit and check
            contactApi.editContact(200, contactId);
            String expectedEditedFirstName = contactApi.randomRequestBodyForEditingContact(contactId).getFirstName();
            JsonPath actualEditedContact = contactApi.getContact(200, contactId).jsonPath();
            String actualEditedFirstName = actualEditedContact.getString("firstName");
            Assert.assertEquals(actualEditedFirstName, expectedEditedFirstName);

            // delete and check
            contactApi.deleteContact(200, contactId);
            contactApi.getContact(500, contactId);
        }

    }

}
