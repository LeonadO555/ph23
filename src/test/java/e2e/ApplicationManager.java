package e2e;

import e2e.pages.LoginHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ApplicationManager {
    public WebDriver driver;

    protected void init() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("http://phonebook.telran-edu.de:8080/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//      driver.manage().window().setSize();
        driver.manage().window().maximize();
    }

    protected void stop() {
        driver.quit();
    }


}
