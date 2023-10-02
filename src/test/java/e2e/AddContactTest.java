package e2e;

import e2e.pages.*;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class AddContactTest extends BaseTest {
    LoginHelper loginHelper;
    ContactsPage contactsPage;
    AddContactDialog addContactDialog;
    ContactInfoPage contactInfoPage;
    RemoveContactDialog removeContactDialog;

    @Test
    public void addContactTest() {
        String newContactName = "TomTom";
        String newContactLastName = "MotMot";

        List<String> contactsInfo = new ArrayList<>();
        contactsInfo.add("TomTom");
        contactsInfo.add("MotMot");
        contactsInfo.add("student");

        String changedName = "Tom";
        String changedLastName = "Mot";

        loginHelper = new LoginHelper(BaseTest.app.driver);
        loginHelper.loginTestHelper();

        contactsPage = new ContactsPage(BaseTest.app.driver);
        contactsPage.waitForLoading();
        contactsPage.clickOnAddNewContactLink(); // нажимаем на кнопку AddNewContact

        addContactDialog = new AddContactDialog(BaseTest.app.driver);
        addContactDialog.waitForLoading();
        addContactDialog.inputInfoForSaving(newContactName, newContactLastName, "student"); // регистрируем новый контакт
        addContactDialog.saveContact();
        addContactDialog.waitForClose();

        contactInfoPage = new ContactInfoPage(BaseTest.app.driver);
        contactInfoPage.waitForLoading();
        Assert.assertEquals(contactInfoPage.getContactInfo() + " not equal " + contactsInfo, contactInfoPage.getContactInfo(), contactsInfo);
        // assertTrue(contactInfoPage.isEditButtonDisplayed()); // проверяем, что мы перешли на страницу contactInfoPage
        contactInfoPage.goToContactsPage();//возвращаюсь на страницу e2e.AddContactTest.ContactsPage


        contactsPage.waitForLoading();
        contactsPage.searchContact(newContactName); // ищу контакт по имени (можно и по фамилии)
        String newContactNameFromContactsLIst = contactsPage.readValueFromNewContact();
        assertEquals(newContactName, newContactNameFromContactsLIst); // проверяю, совпадает ли имя нового контакта с тем, что вышло в результате поиска.
        contactsPage.clickOnNewContactNameLinkFromContactsList(); //выбираю этот контакт и кликаю по нему


        assertTrue(contactInfoPage.isEditButtonDisplayed()); // проверяю, перешла ли на страницу contactInfoPage для дальнейшего изменения крнтакта
        contactInfoPage.clickOnEditButton(); // нажимаю нa кнопку Edit

        contactInfoPage.editName(changedName); // меняю имя
        contactInfoPage.editLastName(changedLastName); // меняю фамилию
        contactInfoPage.clickOnSaveButton(); // сохраняю изменения
        assertTrue(contactInfoPage.isEditButtonDisplayed()); // проверяем, что мы перешли на страницу contactInfoPage
        contactInfoPage.goToContactsPage();//возвращаюсь на страницу e2e.AddContactTest.ContactsPage

        contactsPage.waitForLoading();
        contactsPage.searchContact(changedName + changedLastName); // ищу контакт по изменённому имени + фамилии
        String changedContactNameFromContactsLIst = contactsPage.readValueFromNewContact();
        assertEquals(changedName, changedContactNameFromContactsLIst); // проверяю, совпадает ли имя изменённого контакта с тем, что вышло в результате поиска.
        contactsPage.deleteContact();

        removeContactDialog = new RemoveContactDialog(BaseTest.app.driver);
        removeContactDialog.waitForLoading();
        removeContactDialog.clickCheckbox();
        removeContactDialog.clickOnRemoveContactButton();
        removeContactDialog.waitForClose();

        contactsPage.waitForLoading();
        assertTrue(contactsPage.isNoResultsDisplayed());
    }

}
