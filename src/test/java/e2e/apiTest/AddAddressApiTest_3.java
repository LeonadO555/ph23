package e2e.apiTest;

import api.address.AddressAPI;
import api.contact.ContactApi;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import schemas.AddressesDTO;

import java.util.LinkedHashMap;
import java.util.Map;

public class AddAddressApiTest_3 {
    ContactApi contactApi;
    AddressAPI addressAPI;

    public void checkAddressData(JsonPath actualAddressData, AddressesDTO expectedAddressData){
        LinkedHashMap<String, String> objectAddresses = new LinkedHashMap<>();
        objectAddresses.put(actualAddressData.getString("[0].city"), expectedAddressData.getCity());
        objectAddresses.put(actualAddressData.getString("[0].country"), expectedAddressData.getCountry());
        objectAddresses.put(actualAddressData.getString("[0].street"), expectedAddressData.getStreet());
        objectAddresses.put(actualAddressData.getString("[0].zip"), expectedAddressData.getZip());

        for (Map.Entry<String, String> address : objectAddresses.entrySet()) {
            String actualResult = address.getKey();
            String expectedResult = address.getValue();
            Assert.assertEquals(actualResult, expectedResult, actualResult + " not equal " + expectedResult);
        }
    }
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
        JsonPath actualAllAddresses = addressAPI.getAllAddress(200, contactId).jsonPath();
        int addressId = actualAllAddresses.getInt("[0].id");
        AddressesDTO expectedAddress = addressAPI.randomRequestBodyForCreateAddress(addressId);
        checkAddressData(actualAllAddresses, expectedAddress);

        // edit address
        addressAPI.editAddress(200, addressId, contactId);

        //check after edit address
        JsonPath actualAllEditedAddresses = addressAPI.getAllAddress(200, contactId).jsonPath();
        AddressesDTO expectedEditedAddress = addressAPI.randomRequestBodyForEditAddress(addressId, contactId);
        checkAddressData(actualAllEditedAddresses, expectedEditedAddress);

        // delete address and contact
        addressAPI.deleteAddress(200, addressId);
        contactApi.deleteContact(200, contactId);

        //check after delete
        String responseFromDelete = contactApi.getContact(500, contactId).jsonPath().getString("message");
        String expectedMessageAfterDelete = "Error! This contact doesn't exist in our DB";
        Assert.assertEquals(responseFromDelete, expectedMessageAfterDelete);
    }
}



