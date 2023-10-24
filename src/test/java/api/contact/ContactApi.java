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
    String firstName = faker.name().firstName(); // faker.internet().uuid() - рандомный набор символов
    String lastName = faker.name().lastName();  // faker.internet().uuid() - рандомный набор символов
    String description = faker.internet().uuid();

    String editFirstName = faker.name().firstName(); // faker.internet().uuid() - рандомный набор символов
    String editLastName = faker.name().lastName(); // faker.internet().uuid() - рандомный набор символов
    String editDescription = faker.internet().uuid(); // faker.internet().uuid() - рандомный набор символов

    // int number = faker.number().numberBetween(1,9);
    public ContactDTO randomRequestBodyForCreateContact(){
        dto = new ContactDTO();
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setDescription(description);
        return dto;
    }

    public ContactDTO randomRequestBodyForEditContact(int id){
        dto = new ContactDTO();
        dto.setId(id);
        dto.setFirstName(editFirstName);
        dto.setLastName(editLastName);
        dto.setDescription(editDescription);
        return dto;
    }

    public Response createContact(int code){
        ContactDTO body = randomRequestBodyForCreateContact();
        response = postRequest(ENDPOINT, code, body);
        response.as(ContactDTO.class);
        return response;
    }

    public void editContact(int code, int id){
        ContactDTO body = randomRequestBodyForEditContact(id);
        putRequest(ENDPOINT, code, body);
    }

    public Response deleteContact (int code, int id){
         response = deleteRequest(ENDPOINT + param, code, id);
         return response;
    }

    public Response getContact (int code, int id){
        response = getRequestWithParam(ENDPOINT + param, code, "id", id);
        return response;
    }
}
