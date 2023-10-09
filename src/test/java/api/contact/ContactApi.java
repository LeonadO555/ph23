package api.contact;

import api.ApiBase;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import schemas.ContactDTO;

public class ContactApi extends ApiBase {
    ContactDTO dto;

    Response response;
    Faker faker = new Faker();
    String firstname = faker.internet().uuid();
    String lastname = faker.internet().uuid();
    String description = faker.internet().uuid();

    public ContactDTO randomRequestBodyForCreateContact(){
        dto = new ContactDTO();
        dto.setFirstName(firstname);
        dto.setLastName(lastname);
        dto.setDescription(description);
        return dto;
    }

    public Response createContact(Integer code){
        String endpoint = "/api/contact";
        response = postRequest(endpoint,code,randomRequestBodyForCreateContact());
        response.as(ContactDTO.class);
        return response;
    }
}