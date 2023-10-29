package api.email;

import api.ApiBase;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import schemas.EmailDTO;

public class EmailApi extends ApiBase {


    String ENDPOINT = "/api/email";

    EmailDTO dto;

    Response response;

    Faker faker = new Faker();
    String email = faker.internet().emailAddress();

    String editEmail = faker.internet().emailAddress();


    public EmailDTO randomRequestBodyForCreateEmail(int contactId){
        dto = new EmailDTO();
        dto.setEmail(email);
        dto.setContactId(contactId);
        return dto;
    }

    public EmailDTO randomRequestBodyForEditEmail(int id, int contactId){
        dto = new EmailDTO();
        dto.setId(id);
        dto.setEmail(editEmail);
        dto.setContactId(contactId);
        return dto;
    }

    public Response createEmail(int code, int contactId){
        Object body = randomRequestBodyForCreateEmail( contactId);
        response = postRequest(ENDPOINT, code, body);
        return response;
    }

    public void editEmail(int code, int id, int contactId){
        Object body = randomRequestBodyForEditEmail(id, contactId);
        putRequest(ENDPOINT, code, body);
    }

    public Response deleteEmail (int code, int id){
        response = deleteRequest(ENDPOINT + "/{id}", code, id);
        return response;
    }

    public Response getEmail (int code, int id){
        response = getRequestWithParam(ENDPOINT + "/{id}", code, "id", id);
        return response;
    }

    public Response getAllEmail (int code, int id){
        response = getRequestWithParam(ENDPOINT + "/{contactId}/all", code, "contactId", id);
        return response;
    }

}


