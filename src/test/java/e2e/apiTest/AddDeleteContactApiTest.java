package e2e.apiTest;

import api.contact.ContactApi;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import schemas.ContactDTO;
import java.util.LinkedHashMap;
import java.util.Map;

public class AddDeleteContactApiTest {
    ContactApi contactApi;

    public void checkContactData(JsonPath actualData, ContactDTO expectedData) {
        LinkedHashMap<String, String> objectCreatedContact = new LinkedHashMap<>();
        objectCreatedContact.put(actualData.getString("firstName"), expectedData.getFirstName());
        objectCreatedContact.put(actualData.getString("lastName"), expectedData.getLastName());
        objectCreatedContact.put(actualData.getString("description"), expectedData.getDescription());

        for (Map.Entry<String, String> object : objectCreatedContact.entrySet()) {
            String actualResult = object.getKey();
            String expectedResult = object.getValue();
            Assert.assertEquals(actualResult, expectedResult, actualResult + " not equal " + expectedResult);
        }
    }

    @Test
    public void userCanWorkWithContactTest() {
        contactApi = new ContactApi();

        // create and check
        JsonPath createdContactResponse = contactApi.createContact(201).jsonPath(); // jsonPath помогает вытащить путь до объекта, чтобы потом вытащить нужный параметр
        int contactId = createdContactResponse.getInt("id");
        ContactDTO expectedCreatedContact = contactApi.randomRequestBodyForCreateContact();
        JsonPath actualCreatedContact = contactApi.getContact(200, contactId).jsonPath();
        checkContactData(actualCreatedContact, expectedCreatedContact);

        // edit and check
        contactApi.editContact(200, contactId);
        ContactDTO expectedEditedFirst = contactApi.randomRequestBodyForEditContact(contactId);
        JsonPath actualEditedContact = contactApi.getContact(200, contactId).jsonPath();
        checkContactData(actualEditedContact, expectedEditedFirst);

        // delete and check
        contactApi.deleteContact(200, contactId);
        contactApi.getContact(500, contactId);
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


