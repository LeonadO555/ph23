package e2e;

import api.address.AddressesApi;
import api.contact.ContactApi;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import schemas.AddressesDTO;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AddAddressContactApiTest {
    ContactApi contactApi;
    AddressesApi addressesApi;

    @Test
    public void userCanAddAddressContactTest() {
        contactApi = new ContactApi();
        addressesApi = new AddressesApi();

            JsonPath createdContactResponse = contactApi.createContact(201).jsonPath();
            int contactId = createdContactResponse.getInt("id");

            addressesApi.createAddress(201, contactId);
            JsonPath allAddresses = addressesApi.getAllAddresses(200, contactId).jsonPath();
            int addressId = allAddresses.getInt("[0].id");
            AddressesDTO expectedAddress = addressesApi.randomRequestBodyForCreateAddress(addressId);
            addressesApi.editAddress(200, addressId, contactId);

            LinkedHashMap<String, String> objectAddresses = new LinkedHashMap<>();
            objectAddresses.put(allAddresses.getString("[0].city"), expectedAddress.getCity());
            objectAddresses.put(allAddresses.getString("[0].country"), expectedAddress.getCountry());
            objectAddresses.put(allAddresses.getString("[0].street"), expectedAddress.getStreet());
            objectAddresses.put(allAddresses.getString("[0].zip"), expectedAddress.getZip());

            for (Map.Entry<String, String> address : objectAddresses.entrySet()) {
                String actualResult = address.getKey();
                String expectedResult = address.getValue();
                Assert.assertEquals(actualResult, expectedResult, actualResult+" not equal "+expectedResult);
            }


            // delete and check
            contactApi.deleteContact(200, addressId);
            Response errorMessage = contactApi.getContact(500, addressId);
            Assert.assertEquals(errorMessage.jsonPath().getString("message"),
                    "Error! This contact doesn't exist in our DB");
        }
}
