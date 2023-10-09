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

    public ContactDTO randomRequestBodyForCreatingContact() {
        dto = new ContactDTO();
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setDescription(description);
        return dto;
    }

    public Response createContact(Integer code) {
        String endpoint = "/api/contact";
        response = postRequest(endpoint, code, randomRequestBodyForCreatingContact());
        response.as(ContactDTO.class);
        return response;
    }


}
