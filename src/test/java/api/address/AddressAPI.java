package api.address;

import api.ApiBase;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import schemas.AddressesDTO;
import schemas.ContactDTO;


public class AddressAPI extends ApiBase {
    /*


    @JsonProperty("contactId")
    private int contactId;
     */
    String ENDPOINT = "/api/address";
    AddressesDTO dto;


    Response response;

    Faker faker = new Faker();
    String city = faker.address().city();
    String country = faker.country().name();
    String street = faker.address().streetAddress();
    String zip = faker.address().zipCode();


    String editCity = faker.address().city();
    String editCountry = faker.country().name();
    String editStreet = faker.address().streetAddress();
    String editZip = faker.address().zipCode();


    // int number = faker.number().numberBetween(1,9);
    public AddressesDTO randomRequestBodyForCreateAddress(){
        dto = new AddressesDTO();
        dto.setCity(city);
        dto.setCountry(country);
        dto.setStreet(street);
        dto.setZip(zip);
        return dto;
    }

    public AddressesDTO randomRequestBodyForEditAddress(int id, int contactId){
        dto = new AddressesDTO();
        dto.setId(id);
        dto.setCity(editCity);
        dto.setCountry(editCountry);
        dto.setStreet(editStreet);
        dto.setZip(editZip);
        dto.setContactId(contactId);
        return dto;
    }

    public Response createAddress(int code){
        response = postRequest(ENDPOINT, code, randomRequestBodyForCreateAddress());
        response.as(AddressesDTO.class);
        return response;
    }

    public void editAddress(int code, int id, int contactId){
        Object body = randomRequestBodyForEditAddress(id, contactId);
        putRequest(ENDPOINT, code, body);
    }

    public Response deleteAddress (int code, int id){
        response = deleteRequest(ENDPOINT + "/{id}", code, id);
        return response;
    }

    public Response getContact (int code, int id){
        response = getRequestWithParam(ENDPOINT + "/{contactId}", code, "contactId", id);
        return response;
    }
}


