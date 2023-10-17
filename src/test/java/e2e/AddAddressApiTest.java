package e2e;

import api.address.AddressAPI;
import api.contact.ContactApi;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import schemas.AddressesDTO;
import schemas.ContactDTO;

@Test
public class AddAddressApiTest {
    ContactApi contactApi;
    AddressAPI addressAPI;
public void addNewContactAndAddress(){
    contactApi = new ContactApi();

        // create
        JsonPath createdContactResponse = contactApi.createContact(201).jsonPath(); // jsonPath помогает вытащить путь до объекта, чтобы потом вытащить нужный параметр
        int contactId = createdContactResponse.getInt("id");

  addressAPI = new AddressAPI();

  addressAPI.createAddress(201);
 // addressAPI.editAddress();


        // delete and check
        contactApi.deleteContact(200, contactId);
        contactApi.getContact(500, contactId);
    }
}

//
//    public Response createContact(int code){
//        response = postRequest(ENDPOINT, code, randomRequestBodyForCreateContact());
//        response.as(AddressesDTO.class);
//        return response;
//    }
