package api.address;

import api.ApiBase;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import schemas.AddressesDTO;
import schemas.ContactDTO;

public class AddressesApi extends ApiBase {

    String ENDPOINT = "/api/address";
    AddressesDTO dto;

    Response response;

    Faker faker = new Faker();

    String city = faker.internet().uuid();
    String country = faker.internet().uuid();
    String street = faker.internet().uuid();
    String zip = faker.internet().uuid();



    public AddressesDTO randomRequestBodyForCreatingAddress(int contactId) {
        dto = new AddressesDTO();
        dto.setCity(city);
        dto.setCountry(country);
        dto.setStreet(street);
        dto.setZip(zip);
        dto.setContactId(contactId);
        return dto;
    }

    public AddressesDTO randomRequestBodyForEditingAddress(int id, int contactId) {
        dto = new AddressesDTO();
        dto.setId(id);
        dto.setCity(city);
        dto.setCountry(country);
        dto.setStreet(street);
        dto.setZip(zip);
        dto.setContactId(contactId);
        return dto;
    }

    public Response createAddress(int code) {
        Object body = randomRequestBodyForCreatingAddress(code);
        response = postRequest(ENDPOINT, code, body);
        response.as(AddressesDTO.class);
        return response;
    }

    public void editAddress(int code, int id, int contactId){
        Object body = randomRequestBodyForEditingAddress(id, contactId);
        putRequest(ENDPOINT, code, body);
    }

    public Response deleteAddress(int code, int id){
        response  = deleteRequest(ENDPOINT + "/{id}", code, id);
        return response;
    }

    public Response getAddress(int code, int id){
        response = getRequestWithParam(ENDPOINT + "/{id}", code, "id", id);
        return response;
    }

    public Response getAllAddresses(int code, int id){
        response = getRequestWithParam(ENDPOINT + "/{contactId}/all", code, "contactId", id);
        return response;
    }


}
