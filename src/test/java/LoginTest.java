import org.testng.annotations.Test;

import static java.lang.Thread.sleep;
import static org.apache.commons.lang3.ThreadUtils.sleep;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;



public class LoginTest extends BaseTest {
    @Test
    public void successLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.enterEmail("test@gmail.com");
        loginPage.enterPassword("test@gmail.com");
        loginPage.clickOnLoginButton();
        ContactsPage contactsPage = new ContactsPage(app.driver);
        sleep(1000);
        assertTrue(contactsPage.contactsPageIsDisplayed());
    }
    @Test
    public void invalidEmail() throws InterruptedException {
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.enterEmail("bullshit@gmail.com");
        loginPage.enterPassword("test@gmail.com");
        loginPage.clickOnLoginButton();
        ContactsPage contactsPage = new ContactsPage(app.driver);
        sleep(1000);
        assertFalse(contactsPage.contactsPageIsDisplayed());
        assertTrue(loginPage.errorMessageHasText(
                "Please check your activation or Login + Password combination"));
    }
    @Test
    public void invalidPass() throws InterruptedException {
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.enterEmail("test@gmail.com");
        loginPage.enterPassword("bullshit@gmail.com");
        loginPage.clickOnLoginButton();
        ContactsPage contactsPage = new ContactsPage(app.driver);
        sleep(1000);
        assertFalse(contactsPage.contactsPageIsDisplayed());
        assertTrue(loginPage.errorMessageHasText(
                "Please check your activation or Login + Password combination"));
    }

}


//    @Test
//    public void invalidPassword() {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.enterUsername("standard_user");
//        loginPage.enterPassword("bullshit");
//        loginPage.clickOnLoginButton();
//        loginPage.errorMessageIsDisplayed();
//        assertTrue(loginPage.errorMessageHasText(
//                "Username and password do not match any user in this service"));
//    }
//
//    @Test
//    public void loginLockedOutUser() {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.enterUsername("locked_out_user");
//        loginPage.enterPassword("secret_sauce");
//        loginPage.clickOnLoginButton();
//        loginPage.errorMessageIsDisplayed();
//        assertTrue(loginPage.errorMessageHasText(
//                "Sorry, this user has been locked out"));
//    }
//
//    @Test
//    public void loginInvalidUsername() throws InterruptedException {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.enterUsername("bullshit");
//        loginPage.enterPassword("secret_sauce");
//        loginPage.clickOnLoginButton();
//        assertTrue(loginPage.errorMessageHasText(
//                "Username and password do not match any user in this service"));
//    }
//
//    @Test
//    public void elementsAreDisplayed() {
//        LoginPage loginPage = new LoginPage(driver);
//        assertTrue(loginPage.logoIsDisplayed("Swag Labs"));
//        assertTrue(loginPage.credIsDisplayed());
//        assertTrue(loginPage.passwordsAreDisplayed());
//    }
//    @Test
//    public void successLogout() throws InterruptedException {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.successLogin("standard_user", "secret_sauce");
//        InventoryPage inventoryPage = new InventoryPage(driver);
//        assertTrue(inventoryPage.inventoryListIsDisplayed());
//        Header header = new Header(driver);
//        header.clickOnBurgerMenu();
//        SideBar sideBar = new SideBar(driver);
//        sleep(300);
//        sideBar.followTheLogoutLink();
//        assertTrue(loginPage.usernameIsDisplayed());
//    }