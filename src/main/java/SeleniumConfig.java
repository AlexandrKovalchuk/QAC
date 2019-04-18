import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by alex on 18/04/2019.
 */
public class SeleniumConfig {

    private WebDriver driver;


    public SeleniumConfig() {
        Capabilities capabilities = DesiredCapabilities.firefox();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void setUrl(String url){
        driver.get(url);
    }

    static {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\alex\\eclipse-workspace\\selenium_tutorials\\geckodriver-v0.21.0-win64\\geckodriver.exe");

    }

    static private String findFile(String filename) {
        String paths[] = {"", "bin/", "target/classes"};
        for (String path : paths) {
            if (new File(path + filename).exists())
                return path + filename;
        }
        return "";
    }

    public WebDriver getDriver() {
        return driver;
    }
}
