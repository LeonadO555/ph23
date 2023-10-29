package e2e.apiTest;

import api.address.AddressAPI;
import api.contact.ContactApi;
import api.email.EmailApi;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserCanAddEditDeleteEmailViaApi {

    ContactApi contactApi;
    AddressAPI addressAPI;
    EmailApi emailApi;

    @Test
    public void addEditDeleteContactAndEmail() {
        contactApi = new ContactApi();
        addressAPI = new AddressAPI();
        emailApi = new EmailApi();

        // create user
        JsonPath createdContactResponse = contactApi.createContact(201).jsonPath();
        int contactId = createdContactResponse.getInt("id");

        // create Email
        emailApi.createEmail(201, contactId);

        // check after create email
        int emailId= emailApi.getAllEmail(200, contactId).jsonPath().getInt("[0].id");
        String actualEmail = emailApi.getAllEmail(200, contactId).jsonPath().getString("[0].email");
        String expectedEmail = emailApi.randomRequestBodyForCreateEmail(emailId).getEmail();
        Assert.assertEquals(actualEmail, expectedEmail, actualEmail + " not equal " + expectedEmail );

        // edit Email
        emailApi.editEmail(200, emailId, contactId);

        // check after edit email
        String actualEditAllEmail = emailApi.getAllEmail(200, contactId).jsonPath().getString("[0].email");
        String expectedEditAllEmail = emailApi.randomRequestBodyForEditEmail(emailId, contactId).getEmail();
        Assert.assertEquals(actualEditAllEmail, expectedEditAllEmail, actualEditAllEmail + " not equal " + expectedEditAllEmail);

        // delete email
        emailApi.deleteEmail(200, emailId);

        // check after delete email
        String actualMessageAfterDeleteEmail = emailApi.getEmail(500, emailId).jsonPath().getString("message");
        String expectedMessageAfterDeleteEmail = "Error! This email doesn't exist in our DB";
        Assert.assertEquals(actualMessageAfterDeleteEmail, expectedMessageAfterDeleteEmail , actualMessageAfterDeleteEmail + " not equal " + expectedMessageAfterDeleteEmail);


        contactApi.deleteContact(200, contactId);
    }
}
