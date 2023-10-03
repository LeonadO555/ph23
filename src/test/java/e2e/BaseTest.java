package e2e;

import e2e.pages.ContactsPage;
import e2e.pages.LoginHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected static ApplicationManager app = new ApplicationManager();
    @BeforeMethod
    public void setupTest (){
        app.init();
    }
    @AfterMethod
    public void tearDown(){
        app.stop();
    }


}

