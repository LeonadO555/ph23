package e2e.apiTest;
import api.address.AddressAPI;
import api.contact.ContactApi;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import schemas.AddressesDTO;
import java.util.LinkedHashMap;
import java.util.Map;

public class AddAddressApiTest_2 {
    ContactApi contactApi;
    AddressAPI addressAPI;

    @Test
    public void addNewContactAndAddress() {
        contactApi = new ContactApi();
        addressAPI = new AddressAPI();

        // create user
        JsonPath createdContactResponse = contactApi.createContact(201).jsonPath(); // jsonPath помогает вытащить путь до объекта, чтобы потом вытащить нужный параметр
        int contactId = createdContactResponse.getInt("id");

        // create address
        addressAPI.createAddress(201, contactId);

        //check after create address
        JsonPath allAddresses = addressAPI.getAllAddress(200, contactId).jsonPath();
        int addressId = allAddresses.getInt("[0].id");

        AddressesDTO expectedAddress = addressAPI.randomRequestBodyForCreateAddress(addressId);
        LinkedHashMap<String, String>objectAddresses = new LinkedHashMap<>();
        objectAddresses.put(allAddresses.getString("[0].city"), expectedAddress.getCity());
        objectAddresses.put(allAddresses.getString("[0].country"), expectedAddress.getCountry());
        objectAddresses.put(allAddresses.getString("[0].street"), expectedAddress.getStreet());
        objectAddresses.put(allAddresses.getString("[0].zip"), expectedAddress.getZip());

        for(Map.Entry<String, String> address : objectAddresses.entrySet()){
            String actualResult = address.getKey();
            String expectedResult = address.getValue();
            Assert.assertEquals(actualResult, expectedResult, actualResult  + " not equal " + expectedResult);
        }

        // edit address
        addressAPI.editAddress(200, addressId, contactId);

        //check after edit address
        JsonPath allEditedAddresses = addressAPI.getAllAddress(200, contactId).jsonPath();
        AddressesDTO expectedEditedAddress = addressAPI.randomRequestBodyForEditAddress(addressId, contactId);
        LinkedHashMap<String, String>objectEditedAddresses = new LinkedHashMap<>();
        objectEditedAddresses.put(allEditedAddresses.getString("[0].city"), expectedEditedAddress.getCity());
        objectEditedAddresses.put(allEditedAddresses.getString("[0].country"), expectedEditedAddress.getCountry());
        objectEditedAddresses.put(allEditedAddresses.getString("[0].street"), expectedEditedAddress.getStreet());
        objectEditedAddresses.put(allEditedAddresses.getString("[0].zip"), expectedEditedAddress.getZip());

        for(Map.Entry<String, String> address : objectEditedAddresses.entrySet()){
            String actualEditedResult = address.getKey();
            String expectedEditedResult = address.getValue();
            Assert.assertEquals(actualEditedResult, expectedEditedResult, actualEditedResult  + " not equal " + expectedEditedResult);
        }

        // delete address and contact
        addressAPI.deleteAddress(200, addressId);
        contactApi.deleteContact(200, contactId);

        //check after delete
        String responseFromDelete = contactApi.getContact(500, contactId).jsonPath().getString("message");
        String expectedMessageAfterDelete = "Error! This contact doesn't exist in our DB";
        Assert.assertEquals(responseFromDelete, expectedMessageAfterDelete);
    }
}

