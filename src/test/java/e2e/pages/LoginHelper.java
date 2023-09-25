package e2e.pages;

import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class LoginHelper extends BasePage {

    public LoginHelper(WebDriver driver) {
        super(driver);
    }
    LoginPage loginPage;
    ContactsPage contactsPage;


    public void loginTestHelper() {
        loginPage = new LoginPage(driver);
        loginPage.waitForLoading();
        loginPage.login("test@gmail.com", "test@gmail.com"); // успешно login

        contactsPage = new ContactsPage(driver);
        assertTrue(contactsPage.isHeaderPresent()); // проверяем, что перешли на новую страницу
    }
}
