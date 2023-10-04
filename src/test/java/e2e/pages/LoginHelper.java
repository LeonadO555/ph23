package e2e.pages;


import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class LoginHelper extends Header {



    public LoginHelper(WebDriver driver) {
        super(driver);
    }

    LoginPage loginPage;
    ContactsPage contactsPage;

    public void loginTestHelper() {
        loginPage = new LoginPage(driver);
        loginPage.waitForLoading();
        loginPage.login("test@gmail.com", "test@gmail.com");

        contactsPage = new ContactsPage(driver);
        contactsPage.waitForLoading();

    }
}
