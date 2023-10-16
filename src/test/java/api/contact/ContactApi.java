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
    String firstname = faker.internet().uuid();
    String lastname = faker.internet().uuid();
    String description = faker.internet().uuid();
    String editFirstname = faker.internet().uuid();
    String editLastname = faker.internet().uuid();
    String editDescription = faker.internet().uuid();

    public ContactDTO randomRequestBodyForCreateContact(){
        dto = new ContactDTO();
        dto.setFirstName(firstname);
        dto.setLastName(lastname);
        dto.setDescription(description);
        return dto;
    }

    public ContactDTO randomRequestBodyForEditContact(int id){
        dto = new ContactDTO();
        dto.setId(id);
        dto.setFirstName(editFirstname);
        dto.setLastName(editLastname);
        dto.setDescription(editDescription);
        return dto;
    }

    public Response createContact(int code){
        response = postRequest(ENDPOINT,code,randomRequestBodyForCreateContact());
        response.as(ContactDTO.class);
        return response;
    }

    public void editContact(int code, int id){
        putRequest(ENDPOINT,code,randomRequestBodyForEditContact(id));
    }

    public Response deleteContact(int code, int id){
        response = deleteRequest(ENDPOINT+"/{id}",code,id);
        return response;
    }

    public Response getContact(int code, int id){
        response = getRequestWithParam(ENDPOINT+"/{id}",code,"id",id);
        return response;
    }
}