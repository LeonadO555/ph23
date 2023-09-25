package e2e;

import e2e.pages.AddContactDialog;
import e2e.pages.RemoveContactDialog;
import e2e.pages.LoginHelper;
import e2e.pages.ContactInfoPage;
import e2e.pages.ContactsPage;
import e2e.pages.Header;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class AddContactTest extends BaseTest{
    LoginHelper loginHelper;
    ContactsPage contactsPage;
    AddContactDialog addContactDialog;
    ContactInfoPage contactInfoPage;
    RemoveContactDialog removeContactDialog;
    @Test
    public void addContactTest(){
        String newContactName = "TomTom";
        String newContactLastName = "MotMot";
        List<String> contactsInfo = new ArrayList<>();
        contactsInfo.add("TomTom");
        contactsInfo.add("MotMot");
        contactsInfo.add("student");
        String changedName = "Tom";
        String changedLastName = "Mot";

        loginHelper = new LoginHelper(app.driver);
        loginHelper.loginTestHelper();

        contactsPage = new ContactsPage(app.driver);
        contactsPage.clickOnAddNewContactLink(); // нажимаем на кнопку AddNewContact

        addContactDialog = new AddContactDialog(app.driver);
        addContactDialog.inputInfoForSaving(newContactName, newContactLastName, "student"); // регистрируем новый контакт
        addContactDialog.saveContact();

        contactInfoPage = new ContactInfoPage(app.driver);
        assertEquals(contactInfoPage.getContactInfo() +  " not equal " + contactsInfo,  contactInfoPage.getContactInfo(), contactsInfo);
        assertTrue(contactInfoPage.isEditButtonDisplayed()); // проверяем, что мы перешли на страницу contactInfoPage
        contactInfoPage.goToContactsPage();//возвращаюсь на страницу e2e.pages.ContactsPage

        assertTrue(contactsPage.isContactsPageDisplayed()); // проверяю, что нахожусь на СontactsPage
        contactsPage.searchContact(newContactName); // ищу контакт по имени (можно и по фамилии)
        String newContactNameFromContactsLIst = contactsPage.readValueFromNewContact();
        assertEquals(newContactName, newContactNameFromContactsLIst); // проверяю совпадает ли имя нового контакта с тем, что вышло в результате поиска.
        contactsPage.clickOnNewContactNameLinkFromContactsList(); //выбираю этот контакт и кликаю по нему

        assertTrue(contactInfoPage.isEditButtonDisplayed()); // проверяю, перешла ли на страницу contactInfoPage для дальнейшего изменения крнтакта
        contactInfoPage.clickOnEditButton(); // нажимаю нa кнопку Edit
        contactInfoPage.editName(changedName); // меняю имя
        contactInfoPage.editLastName(changedLastName); // меняю фамилию
        contactInfoPage.clickOnSaveButton(); // сохраняю изменения
        assertTrue(contactInfoPage.isEditButtonDisplayed()); // проверяем, что мы перешли на страницу contactInfoPage
        contactInfoPage.goToContactsPage();//возвращаюсь на страницу e2e.pages.ContactsPage

        assertTrue(contactsPage.isContactsPageDisplayed()); // проверяю, что нахожусь на СontactsPage
        contactsPage.searchContact(changedName+changedLastName); // ищу контакт по изменённому имени + фамилии
        String changedContactNameFromContactsLIst = contactsPage.readValueFromNewContact();
        assertEquals(changedName, changedContactNameFromContactsLIst); // проверяю совпадает ли имя изменённого контакта с тем, что вышло в результате поиска.
        contactsPage.deleteContact();

        removeContactDialog = new RemoveContactDialog(app.driver);
        removeContactDialog.isCheckBoxIsDisplayed();
        removeContactDialog.clickCheckbox();
        removeContactDialog.clickOnRemoveContactButton();

        assertTrue(contactsPage.isNoResultsDisplayed());

    }
}
