import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class AddContactTest extends BaseTest{
    @Test
    public void addContactTest(){
        LoginHelper loginHelper = new LoginHelper(app.driver);
        loginHelper.loginTestHelper();
        HeaderPage header = new HeaderPage(app.driver);
        header.clickOnAddNewContactLink(); // нажимаем на кнопку AddNewContact

        AddContactDialog addContactDialog = new AddContactDialog(app.driver);
        String newContactName = "TomTom";
        String newContactLastName = "MotMot";
        addContactDialog.inputInfoForSaving(newContactName, newContactLastName, "student"); // регистрируем новый контакт

        addContactDialog.saveContact();

        ContactInfoPage contactInfoPage = new ContactInfoPage(app.driver);

        List<String> contactsInfo = new ArrayList<>();
        contactsInfo.add("TomTom");
        contactsInfo.add("MotMot");
        contactsInfo.add("student");
        assertEquals(contactInfoPage.getContactInfo() +  " not equal " + contactsInfo,  contactInfoPage.getContactInfo(), contactsInfo);

        assertTrue(contactInfoPage.isEditButtonDisplayed()); // проверяем, что мы перешли на страницу contactInfoPage

        header.goToContactsPage();//возвращаюсь на страницу ContactsPage

        ContactsPage contactsPage = new ContactsPage(app.driver);
        assertTrue(contactsPage.isContactsPageDisplayed()); // проверяю, что нахожусь на СontactsPage

        contactsPage.searchContact(newContactName); // ищу контакт по имени (можно и по фамилии)
        String newContactNameFromContactsLIst = contactsPage.readValueFromNewContact();
        assertEquals(newContactName, newContactNameFromContactsLIst); // проверяю совпадает ли имя нового контакта с тем, что вышло в результате поиска.

        contactsPage.clickOnNewContactNameLinkFromContactsList(); //выбираю этот контакт и кликаю по нему
        assertTrue(contactInfoPage.isEditButtonDisplayed()); // проверяю, перешла ли на страницу contactInfoPage для дальнейшего изменения крнтакта
        contactInfoPage.clickOnEditButton(); // нажимаю нa кнопку Edit

        String changedName = "Tom";
        String changedLastName = "Mot";
        contactInfoPage.editName(changedName); // меняю имя
        contactInfoPage.editLastName(changedLastName); // меняю фамилию
        contactInfoPage.clickOnSaveButton(); // сохраняю изменения

        assertTrue(contactInfoPage.isEditButtonDisplayed()); // проверяем, что мы перешли на страницу contactInfoPage

        header.goToContactsPage();//возвращаюсь на страницу ContactsPage
        assertTrue(contactsPage.isContactsPageDisplayed()); // проверяю, что нахожусь на СontactsPage

        contactsPage.searchContact(changedName+changedLastName); // ищу контакт по изменённому имени + фамилии

        String changedContactNameFromContactsLIst = contactsPage.readValueFromNewContact();
        assertEquals(changedName, changedContactNameFromContactsLIst); // проверяю совпадает ли имя изменённого контакта с тем, что вышло в результате поиска.

        contactsPage.deleteContact();

        RemoveContactDialog removeContactPage = new RemoveContactDialog(app.driver);
        removeContactPage.isCheckBoxIsDisplayed();
        removeContactPage.clickCheckbox();

        removeContactPage.clickOnRemoveContactButton();

        assertTrue(contactsPage.isNoResultsDisplayed());

    }
}
