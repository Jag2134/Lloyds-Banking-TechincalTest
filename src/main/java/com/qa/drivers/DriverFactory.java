package com.qa.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class DriverFactory {

    public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    /**
     * this is used to get the driver with ThreadLocal
     *
     * @return this will return threadLocalDriver
     */
    public static synchronized WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    /**
     * This method is used to initialize the ThreadLocal driver on the basis of given
     * browser
     *
     * @param browser
     * @return this will return threadLocalDriver.
     */
    public WebDriver initiate_driver(String browser) {

        System.out.println("browser value is: " + browser);

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            threadLocalDriver.set(new ChromeDriver());
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            threadLocalDriver.set(new FirefoxDriver());
        } else if (browser.equals("safari")) {
            threadLocalDriver.set(new SafariDriver());
        } else {
            System.out.println("Please pass the correct browser value: " + browser);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        //getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return getDriver();

    }
}
