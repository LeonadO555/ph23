package api.contact;

import api.ApiBase;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import schemas.ContactDTO;

public class ContactApi extends ApiBase {
    String ENDPOINT = "/api/contact";

    String param = "/{id}";
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
        ContactDTO body = randomRequestBodyForCreateContact();
        response = postRequest(ENDPOINT,code,body);
        response.as(ContactDTO.class);
        return response;
    }

    public void editContact(int code, int id){
        ContactDTO body = randomRequestBodyForEditContact(id);
        putRequest(ENDPOINT,code,body);
    }

    public Response deleteContact(int code, int id){
        response = deleteRequest(ENDPOINT+param,code,id);
        return response;
    }

    public Response getContact(int code, int id){
        response = getRequestWithParam(ENDPOINT+param,code,"id",id);
        return response;
    }
}