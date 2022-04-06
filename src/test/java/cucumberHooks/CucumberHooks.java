package cucumberHooks;

import com.qa.drivers.DriverFactory;
import com.qa.utils.BaseUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;


public class CucumberHooks extends BaseUtils {
    private DriverFactory driverFactory;
    private WebDriver driver;

    @Before
    public void launchBrowser() {
        String browserName = getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.initiate_driver(browserName);
    }

    @After
    public void quitBrowser() {
        driver.quit();
    }

}
