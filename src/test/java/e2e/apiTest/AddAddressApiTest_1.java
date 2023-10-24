package e2e.apiTest;
import api.address.AddressAPI;
import api.contact.ContactApi;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddAddressApiTest_1 {
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
        String actualCity = allAddresses.getString("[0].city");
        String actualCountry = allAddresses.getString("[0].country");
        String actualStreet = allAddresses.getString("[0].street");
        String actualZip = allAddresses.getString("[0].zip");

        String expectedCity = addressAPI.randomRequestBodyForCreateAddress(contactId).getCity();
        String expectedCountry = addressAPI.randomRequestBodyForCreateAddress(contactId).getCountry();
        String expectedStreet = addressAPI.randomRequestBodyForCreateAddress(contactId).getStreet();
        String expectedZip = addressAPI.randomRequestBodyForCreateAddress(contactId).getZip();

        Assert.assertEquals(expectedCity, actualCity);
        Assert.assertEquals(expectedCountry, actualCountry);
        Assert.assertEquals(expectedStreet, actualStreet);
        Assert.assertEquals(expectedZip, actualZip);

        // edit address
        addressAPI.editAddress(200, addressId, contactId);

        //check after edit address
        JsonPath allEditedAddresses = addressAPI.getAllAddress(200, contactId).jsonPath();
        String actualEditedCity = allEditedAddresses.getString("[0].city");
        String actualEditedCountry = allEditedAddresses.getString("[0].country");
        String actualEditedStreet = allEditedAddresses.getString("[0].street");
        String actualEditedZip =allEditedAddresses.getString("[0].zip");

        String expectedEditCity = addressAPI.randomRequestBodyForEditAddress(addressId, contactId).getCity();
        String expectedEditCountry = addressAPI.randomRequestBodyForEditAddress(addressId, contactId).getCountry();
        String expectedEditStreet = addressAPI.randomRequestBodyForEditAddress(addressId, contactId).getStreet();
        String expectedEditZip = addressAPI.randomRequestBodyForEditAddress(addressId, contactId).getZip();

        Assert.assertEquals(expectedEditCity, actualEditedCity);
        Assert.assertEquals(expectedEditCountry, actualEditedCountry);
        Assert.assertEquals(expectedEditStreet, actualEditedStreet);
        Assert.assertEquals(expectedEditZip, actualEditedZip);

        // delete address and contact
        addressAPI.deleteAddress(200, addressId);
        contactApi.deleteContact(200, contactId);

        //check after delete
        String responseFromDelete = contactApi.getContact(500, contactId).jsonPath().getString("message");
        String expectedMessageAfterDelete = "Error! This contact doesn't exist in our DB";
        Assert.assertEquals(responseFromDelete, expectedMessageAfterDelete);
    }
}



