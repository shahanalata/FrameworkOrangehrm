package com.qa.orangehrm.pages;

import com.qa.orangehrm.utils.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AdminPageDemo {
    private WebDriver driver;//null
    public CommonUtils commonUtils;
    public Actions action ;


    //by locator,
   By userName = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
   By userRole = By.xpath("//div[@class='oxd-select-text oxd-select-text--active']//div//i[1]");
   By employeeName = By.xpath("//input[@placeholder='Type for hints...']");
   By Status = By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]") ;
   By searchButton = By.xpath("//button[text()=' Reset ']");



    public AdminPageDemo(WebDriver driver) {//electrifying driver,assign to local driver, then it pass in here.
        //driver comes from adminPage,//need to spread in whole class
        this.driver=driver; //this driver refer to current class object(global driver)
        commonUtils = new CommonUtils(driver);
        action = new Actions(driver);
    }
    public void userNameEditBox(String name) {//make this method for locator
       // CommonUtils commonUtils = new CommonUtils(driver);
        commonUtils.doSendKeys(userName,name);
       // driver.findElement(userName).clear();
      // driver.findElement(userName).sendKeys(name);
    }
    public void userRoleSelect(){
        driver.findElement(userRole).click();
       // Actions action = new Actions(driver);
        action.keyDown(Keys.ARROW_DOWN).perform();
        action.keyDown(Keys.TAB).perform();
    }
    public void employeeNameEditBox(String name){
     //   CommonUtils commonUtils = new CommonUtils(driver);
        commonUtils.doSendKeys(employeeName,name);
      // driver.findElement(employeeName).clear();
        //driver.findElement(employeeName).sendKeys(name);
    }
    public void statusSelect(){
        driver.findElement(Status).click();
      //  Actions action = new Actions(driver);
        action.keyDown(Keys.ARROW_DOWN).perform();
        action.keyDown(Keys.TAB).perform();
    }
    public void searchButtonSelect(){
        driver.findElement(searchButton).click();
    }
    }






