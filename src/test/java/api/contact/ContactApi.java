package api.contact;

import api.ApiBase;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import schemas.ContactDTO;

public class ContactApi extends ApiBase {

    String ENDPOINT = "/api/contact";
    ContactDTO dto;

    Response response;

    Faker faker = new Faker();

    String firstName = faker.internet().uuid();
    String lastName = faker.internet().uuid();
    String description = faker.internet().uuid();
    String editFirstName = faker.internet().uuid();
    String editLastName = faker.internet().uuid();
    String editDescription = faker.internet().uuid();


    public ContactDTO randomRequestBodyForCreatingContact() {
        dto = new ContactDTO();
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setDescription(description);
        return dto;
    }

    public ContactDTO randomRequestBodyForEditingContact(int id) {
        dto = new ContactDTO();
        dto.setId(id);
        dto.setFirstName(editFirstName);
        dto.setLastName(editLastName);
        dto.setDescription(editDescription);
        return dto;
    }

    public Response createContact(int code) {
        response = postRequest(ENDPOINT, code, randomRequestBodyForCreatingContact());
        response.as(ContactDTO.class);
        return response;
    }

    public void editContact(int code, int id){
        putRequest(ENDPOINT, code, randomRequestBodyForEditingContact(id));
    }

    public Response deleteContact(int code, int id){
        response  = deleteRequest(ENDPOINT + "/{id}", code, id);
        return response;
    }

    public Response getContact(int code, int id){
        response = getRequestWithParam(ENDPOINT + "/{id}", code, "id", id);
        return response;
    }


}
