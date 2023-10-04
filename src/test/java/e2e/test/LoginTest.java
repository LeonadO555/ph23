package e2e.test;

import e2e.pages.LoginHelper;
import e2e.pages.LoginPage;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    LoginHelper loginHelper;


    @Test
    public void successLogin() {
        loginHelper = new LoginHelper(BaseTest.app.driver);
        loginHelper.loginTestHelper();
    }

    @Test
    public void invalidEmail() {
        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login("asqw@gmail.com", "test@gmail.com");
        assertTrue(loginPage.errorMessageHasText("Please check your activation or Login + Password combination"));
    }

    @Test
    public void invalidPass() throws InterruptedException {
        loginPage = new LoginPage(app.driver);
        loginPage.login("test@gmail.com", "t123qwerty");
        assertTrue(loginPage.errorMessageHasText("Please check your activation or Login + Password combination"));
    }

}