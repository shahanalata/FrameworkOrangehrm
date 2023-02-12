package com.qa.orangehrm.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class CommonUtils {

    public WebDriver driver;
    public Actions action;

    public CommonUtils(WebDriver driver){
        this.driver=driver;
        action = new Actions(driver);
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

    action.keyDown(Keys.ARROW_DOWN).perform();
    action.keyDown(Keys.TAB).perform();

}

public void doKeyDown(int a) {


    for (int i = 0; i<a; i++) {
        action.keyDown(Keys.ARROW_DOWN).perform();
    }
    action.keyDown(Keys.TAB).perform();
}

}