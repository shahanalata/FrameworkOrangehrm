package com.qa.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {

    private WebDriver driver;

 @FindBy(xpath= "//span[@class='oxd-userdropdown-tab']//p")
    public WebElement successLoginMsg ;

 @FindBy(xpath="//p[text()='My Actions']")
    public WebElement myActionsTag;
 @FindBy(xpath="//span[text()='Admin']")
 public WebElement adminButton;

 @FindBy(xpath ="//span[text()='PIM']")
 public WebElement pimButton;


//(//a[@class='oxd-main-menu-item'])[10]
    @FindBy(xpath = "//span[text()='Buzz']")
    public WebElement buzzButton;
 public DashBoardPage(WebDriver driver){

     PageFactory.initElements(driver,this);
 }

}
