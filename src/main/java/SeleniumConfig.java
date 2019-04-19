import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by alex on 18/04/2019.
 */
public class SeleniumConfig {

    private WebDriver driver;


    public SeleniumConfig() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    static {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\alex\\eclipse-workspace\\selenium_tutorials\\geckodriver-v0.21.0-win64\\geckodriver.exe");

    }

    public WebDriver getDriver() {
        return driver;
    }
}
