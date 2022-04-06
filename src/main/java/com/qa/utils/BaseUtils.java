package com.qa.utils;

import com.qa.drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Properties;

public abstract class BaseUtils {
    private final WebDriver driver = DriverFactory.getDriver();
    Properties prop;
    private ConfigReader configReader;

    /**
     * @return Page title String
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     *
     * @param keyValue
     * @return property value from the config file
     */
    public String getProperty(String keyValue) {
        configReader = new ConfigReader();
        prop = configReader.initiate_properties();
        return prop.getProperty(keyValue);
    }

    /**
     *
     * @param element
     */
    public void mouseOverOnElements(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    /**
     *
     * @param element
     * @return Text from the WebElement
     */
    public String getElementText(WebElement element){
       return element.getText();
    }
}
