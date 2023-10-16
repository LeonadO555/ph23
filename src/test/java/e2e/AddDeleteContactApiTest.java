package e2e;

import api.contact.ContactApi;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AddDeleteContactApiTest {
    ContactApi contactApi;

    @Test
    public void userCanWorkWithContactTest(){
        contactApi = new ContactApi();
        for (int i = 0; i < 5 ; i++) {

            // create and check
            JsonPath createdContactResponse = contactApi.createContact(201).jsonPath(); // jsonPath помогает вытащить путь до объекта, чтобы потом вытащить нужный параметр
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


/*
List<Integer> listId = new ArrayList<>();
        List<String> listExpectedFirstName = new ArrayList<>();
        List<String> listFirstName = new ArrayList<>();
        JsonPath createdContactResponse = contactApi.createContact(201).jsonPath();
        listId.add(createdContactResponse.getInt("id"));
        listExpectedFirstName.add(contactApi.randomRequestBodyForCreateContact().getFirstName());
        for (Integer id:  listId) {
            JsonPath actualCreatedContact = contactApi.getContact(200, id).jsonPath();
            listFirstName.add(actualCreatedContact.getString("firstName"));
        }
        Assert.assertEquals(listFirstName,listExpectedFirstName);

     //   int contactId = createdContactResponse.getInt("id");
      //  String firstName = createdContactResponse.getString("firstName");
     //   JsonPath actualCreatedContact = contactApi.getContact(200, contactId).jsonPath();

        List<String> listEditedFirstName = new ArrayList<>();
        for (Integer id : listId) {
            contactApi.editContact(200, id);
            listEditedFirstName.add(contactApi.randomRequestBodyForEditContact(id).getFirstName());
        }

        List<String> listActualEditedFirstName = new ArrayList<>();
        for (Integer id : listId) {
            JsonPath actualCreatedContact = contactApi.getContact(200, id).jsonPath();
            listActualEditedFirstName.add(actualCreatedContact.getString("firstName"));
        }
        Assert.assertEquals(listActualEditedFirstName, listEditedFirstName);

        for (Integer id: listId){
            contactApi.deleteContact(200, id);
            contactApi.getContact(500, id);
        }
 */

