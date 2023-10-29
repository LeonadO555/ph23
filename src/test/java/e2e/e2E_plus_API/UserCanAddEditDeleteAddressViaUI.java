package e2e.e2E_plus_API;

import api.contact.ContactApi;
import com.github.javafaker.Faker;
import e2e.BaseTest;
import e2e.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class UserCanAddEditDeleteAddressViaUI extends BaseTest {
    ContactApi contactApi;
    AddressesPage addressesPage;
    LoginHelper loginHelper;
    ContactsPage contactsPage;
    AddEditNewAddressDialog addEditNewAddressDialog;
    ContactInfoPage contactInfoPage;
    Header header;
    RemoveContactDialog removeContactDialog;

    Faker faker = new Faker();

    String city = faker.address().cityName();
    String postcode = faker.address().zipCode();
    String street = faker.address().streetName();

    String editCity = faker.address().city();
    String editPostcode = faker.address().zipCode();
    String editStreet = faker.address().streetAddress();
    String alertMessage = "Address removed";

  /*
        В этом тесте я,
                  при помощи API создаю и удаляю КОНТАКТ
                  при помощи UI создаю, редактирую и удаляю АДРЕС
 */
    @Test
    public void userCanAddEditDeleteAddress_E2E_API()  {
        contactApi = new ContactApi();
        loginHelper = new LoginHelper(app.driver);
        contactsPage = new ContactsPage(app.driver);
        addressesPage = new AddressesPage(app.driver);
        addEditNewAddressDialog = new AddEditNewAddressDialog(app.driver);
        contactInfoPage = new ContactInfoPage(app.driver);
        header = new Header(app.driver);
        removeContactDialog = new RemoveContactDialog(app.driver);


        int contactId = contactApi.createContact(201).jsonPath().getInt("id");
        loginHelper.loginTestHelper();

        contactsPage.openContactByContactId(contactId);

        contactInfoPage.waitForLoading();

        addressesPage.goToAddressTab();
        addressesPage.waitForLoading();
        addressesPage.clickAddNewAddressButton();

        addEditNewAddressDialog.waitForLoading();
        addEditNewAddressDialog.selectCountry();
        addEditNewAddressDialog.selectGermany();
        addEditNewAddressDialog.fillInAddress(city,postcode,street);
        addEditNewAddressDialog.clickSaveButton();
        addEditNewAddressDialog.waitForClosing();

        addressesPage.waitForLoading();
        addressesPage.checkAddress(city,postcode,street);
        addressesPage.clickEditRemoveButton();
        addressesPage.editAddress();

        addEditNewAddressDialog.waitForLoading();
        addEditNewAddressDialog.selectCountry();
        addEditNewAddressDialog.selectDenmark();
        addEditNewAddressDialog.editFillInAddress(editCity, editPostcode, editStreet);
        addEditNewAddressDialog.clickSaveButton();
        addEditNewAddressDialog.waitForClosing();

        addressesPage.waitForLoading();
        addressesPage.checkAddress(editCity,editPostcode,editStreet);
        addressesPage.clickEditRemoveButton();
        addressesPage.waitForLoadingRemoveAddressLink();
        addressesPage.removeAddress();
        addressesPage.waitForLoading();
        addressesPage.alertMessageIsDisplayed(alertMessage);

        //delete contact
        contactApi.deleteContact(200, contactId);
        //check after delete contact
        String responseFromDeleteContact = contactApi.getContact(500, contactId).jsonPath().getString("message");
        String expectedMessageAfterDeleteContact = "Error! This contact doesn't exist in our DB";
        Assert.assertEquals(responseFromDeleteContact, expectedMessageAfterDeleteContact);

    }
}
