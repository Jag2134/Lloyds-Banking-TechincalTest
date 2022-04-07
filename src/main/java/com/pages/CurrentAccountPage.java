package com.pages;

import com.qa.utils.BaseUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CurrentAccountPage extends BaseUtils {
    private WebDriver driver;
    String[] currentAccountName = {"Classic account","Club Lloyds account","Platinum account","Club Lloyds Platinum account"};


    // 1. By Locators: WebElements locators of the page
    private final By platinumFeeText = By.xpath("//span[text()='Platinum account']/parent::h2/parent::div/following-sibling::div[contains(@class,'rich-text')]//strong");

    // 2. Constructor of the page class:
    public CurrentAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. page actions: features(behavior) of the page the form of methods:
    public void validateCurrentAccountsOnPage(){
        for(int i=0;i<currentAccountName.length;i++) {
            String expectedCurrentAccount = currentAccountName[i];
            WebElement currentElement = driver.findElement(By.xpath("//div[@data-selector='promo-box-title-icon']//a[contains(@href,'current')]//span[text()=\""+expectedCurrentAccount+"\"]"));
           boolean checkElement = currentElement.isDisplayed();
           if(checkElement){
               System.out.println(expectedCurrentAccount +"is present on the page");
           }else{
               System.out.println(expectedCurrentAccount +"is not present on the page");
           }
        }
    }

    public boolean validatePlatinumFeeValue(String feeValue){
        WebElement element = driver.findElement(platinumFeeText);
        String actualText = getElementText(element);
        return actualText.contains(feeValue);
    }

}
