package api.contact;

import api.ApiBase;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import schemas.ContactDTO;

public class ContactApi extends ApiBase {

    ContactDTO dto;

    Response response;

    Faker faker = new Faker();
    String firstName = faker.internet().uuid();
    String lastName = faker.internet().uuid();
    String description = faker.internet().uuid();

    // int number = faker.number().numberBetween(1,9);
    public ContactDTO randomRequestBodyForCreateContact(){
        dto = new ContactDTO();
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setDescription(description);
        return dto;
    }

    public Response createContact(Integer code){
        String endPoint = "/api/contact";
        response = postRequest(endPoint, code, randomRequestBodyForCreateContact());
        response.as(ContactDTO.class);
        return response;
    }
}
