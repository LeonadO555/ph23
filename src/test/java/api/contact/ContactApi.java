package api.contact;

import api.ApiBase;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import schemas.ContactDto;

public class ContactApi extends ApiBase {

    ContactDto dto;
    Response response;
    Faker faker = new Faker();
    String firstName = faker.internet().uuid();
    String lastName = faker.internet().uuid();
    String description = faker.internet().uuid();

    public ContactDto randomRequestBodyForCreateContact() {
        dto = new ContactDto();
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setDescription(description);
        return dto;
    }

    public Response createContact(Integer code) {
        String endpoint = "/api/contact";
        response = postRequest(endpoint, code, randomRequestBodyForCreateContact());
        response.as(ContactDto.class);
        return response;
    }
}
