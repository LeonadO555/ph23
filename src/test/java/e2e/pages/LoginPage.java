package e2e.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Wait;


public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "defaultRegisterFormEmail")
    private WebElement emailInputField;

    @FindBy(xpath = "//*[@formcontrolname='password']")
    private WebElement passInputField;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    @FindBy(id = "error-message")
    private WebElement errorMessage;

    public void waitForLoading(){
        getWait().forVisibility(emailInputField);
        getWait().forVisibility(passInputField);
        getWait().forVisibility(loginButton);
    }

    public void login (String emailValue, String passwordValue) {
        emailInputField.sendKeys(emailValue);
        passInputField.sendKeys(passwordValue);
        loginButton.click();
    }
    public boolean errorMessageHasText(String expectedText){
        return errorMessage.getText().contains(expectedText);
    }
}
