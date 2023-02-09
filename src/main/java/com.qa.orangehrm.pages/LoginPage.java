package com.qa.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {        //create locator in this page
   //page factory model in selenium,when declare it, we need to create a constructor method for initialization
   private WebDriver driver;
    @FindBy(xpath="//input[@name='username']")
    public WebElement userName;     //in this page we do create only webElement(locator)
    @FindBy(xpath="//input[@name='password']")// for testcase we create same naming convocation in test java
    public WebElement passWord;
    @FindBy(xpath="//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "(//img[@alt='orangehrm-logo'])[2]")
    public WebElement logo;

    @FindBy(xpath="//p[text()='Forgot your password? ']")
    public WebElement forgotPassword;
    public LoginPage(WebDriver driver){  // by default java  call constructor, if we didn't create
    PageFactory.initElements(driver,this);
    //this is a keyword refers to current class object/local variable.


     }
     public DashBoardPage doLogin(String uName, String pswrd){    //declare a generic method
     userName.clear();             //unique
     userName.sendKeys(uName);
     passWord.clear();
     passWord.sendKeys(pswrd);
     loginButton.click();
     return new DashBoardPage(driver);

}
}
