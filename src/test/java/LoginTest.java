import org.junit.Test;

import static org.junit.Assert.assertTrue;



public class LoginTest extends BaseTest {
   @org.testng.annotations.Test
    public void successLogin() {
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.login("test@gmail.com", "test@gmail.com");
        HeaderPage header = new HeaderPage(app.driver);
        assertTrue(header.isHeaderPresent());
    }

    @Test
    public void invalidEmail()  {
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.login("tttt@gmail.com", "test@gmail.com");
        assertTrue(loginPage.errorMessageHasText( "Please check your activation or Login + Password combination"));
    }

    @Test
    public void invalidPass() throws InterruptedException {
        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.login("test@gmail.com", "tttt@gmail.com");
        assertTrue(loginPage.errorMessageHasText( "Please check your activation or Login + Password combination"));
    }


}