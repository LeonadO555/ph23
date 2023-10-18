package e2e.pages;

import api.address.AddressesApi;
import api.contact.ContactApi;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

public class AddingAddressForContact {

    ContactApi contactApi;
    AddressesApi addressesApi;


    public void userCanAddAddress() {

        contactApi = new ContactApi();
        addressesApi = new AddressesApi();

        // create and check
        JsonPath createdContactResponse = contactApi.createContact(201).jsonPath();
        int contactId = createdContactResponse.getInt("id");

        addressesApi.createAddress(201);
        JsonPath allAddresses = addressesApi.getAllAddresses(200, contactId).jsonPath();

        // String expectedAddress = addressesApi.
        // String actualAddress = allAddresses.getString()

        int addressId = allAddresses.getInt("[0].id");
        addressesApi.editAddress(200, addressId, contactId);

        // delete and check
        contactApi.deleteContact(200, addressId);
        contactApi.getContact(500, addressId);

    }

}
