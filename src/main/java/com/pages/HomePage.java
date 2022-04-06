package com.pages;

import com.qa.utils.BaseUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BaseUtils {

    private WebDriver driver;


    // 1. By Locators: WebElements locators of the page
    private final By whoWeAreButton = By.xpath("//div[contains(@aria-hidden,'false')]//a[contains(@class,'btn btn-primary')]");
    private final By productsAndServicesLink = By.xpath("//div[contains(@class,'desktop')]//li[@class='home-icon']/following-sibling::li[1]");
    private final By currentAccountLink = By.xpath("(//div[contains(@class,'desktop')]//li[@class='home-icon']/following-sibling::li[1]//li/a[@href='/current-accounts.html'])[1]");
    private final By classicAccountButton = By.xpath("//div[@data-selector='promo-box-title-icon']//a[contains(@href,'current')]//span[text()='Classic account']");

    // 2. Constructor of the page class:
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. page actions: features(behavior) of the page the form of methods:
    public void navigateToHomePage() {
        String appLink = getProperty("appLink");
        driver.get(appLink);
    }

    public boolean isWhoWeAreButtonExist() {
        return driver.findElement(whoWeAreButton).isDisplayed();
    }

    public CurrentAccountPage navigateToCurrentAccountPage() {
        WebElement mainMenu = new WebDriverWait(driver, Duration.ofSeconds(10))
               .until(ExpectedConditions.presenceOfElementLocated(productsAndServicesLink));
        Actions action = new Actions(driver);
        int xOffset = mainMenu.getRect().getX();
        int yOffset = mainMenu.getRect().getY();
        action.moveByOffset(xOffset, yOffset).build().perform();
        WebElement subMainMenu = new WebDriverWait(driver, Duration.ofSeconds(10))
               .until(ExpectedConditions.presenceOfElementLocated(currentAccountLink));
         action.moveToElement(subMainMenu).click(subMainMenu).build().perform();
         return new CurrentAccountPage(driver);
    }

    public boolean validateCurrentAccountPageDisplayed(){
        WebElement classAccountButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(classicAccountButton));
        return classAccountButton.isDisplayed();
    }

}
