package e2e.dialogs;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import e2e.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteContactDialog extends BasePage {

    @FindBy(xpath = "//*[@role='dialog']")
    private WebElement dialog;
    @FindBy(
            id = "check-box-remove-contact"
    )
    private WebElement checkBox;
    @FindBy(
            id = "submit-remove"
    )
    private WebElement buttonDeleteElem;
    @FindBy(
            xpath = "//*[@class='alert text-center alert-warning']"
    )
    private WebElement alertText;

    public void waitForLoading(){
        getWait().forVisibility(dialog);
        getWait().forVisibility(checkBox);
        getWait().forVisibility(buttonDeleteElem);

    }

    public DeleteContactDialog(WebDriver driver) {
        super(driver);
    }

    public void clickToCheckBox() {
        this.checkBox.click();
    }

    public void clickButtonDeleteElement() {
        this.buttonDeleteElem.click();
    }

    public boolean alertTextIsDisplayed() {
        return this.alertText.isDisplayed();
    }

public void waitForClosed(){
        getWait().forInvisibility(dialog);
}
}