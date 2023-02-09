package com.qa.orangehrm.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class CommonUtils {

    public WebDriver driver;


    public CommonUtils(WebDriver driver){
        this.driver=driver;
    }

   public void doSendKeys(By locator, String s) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(s);
    }
    public void doSendKeysUsingFindBy(WebElement element, String s) {
        element.clear();
       // driver.findElement(element).sendkeys(s);
        element.sendKeys(s);

    }
public void moveToElement(By locator){
    WebElement element =driver.findElement(locator);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();",element);
}
public void doActionKeyDown(){
    Actions action = new Actions(driver);
    action.keyDown(Keys.ARROW_DOWN).perform();
    action.keyDown(Keys.TAB).perform();

}




}
