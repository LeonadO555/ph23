package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {super(driver);}

    @FindBy(id = "defaultRegisterFormEmail")
    private WebElement emailInputField;

    @FindBy(css = "input[formcontrolname='password']")
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

    public void enterEmail(String emailValue) {emailInputField.sendKeys(emailValue);}
    public void enterPassword(String passValue) {
        passInputField.sendKeys(passValue);
    }
    public void clickOnLoginButton() {
        loginButton.click();
    }
    public boolean errorMessageHasText(String expectedText){
        return errorMessage.getText().contains(expectedText);
    }
}
