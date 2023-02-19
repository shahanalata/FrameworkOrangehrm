package com.qa.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuzzPage {

    private WebDriver driver;


@FindBy(xpath = "//textarea[@class='oxd-buzz-post-input']")
public WebElement textBox;

@FindBy(xpath = "//div[@class='oxd-buzz-post-slot']//button[text()=' Post ']")
public WebElement postButton;

    @FindBy(xpath = "(//i[@class='oxd-icon bi-three-dots'])[1]")
    public WebElement deleteButton;

    @FindBy(xpath = "//li[@class='orangehrm-buzz-post-header-config-item']//i[@class='oxd-icon bi-trash']")
    public WebElement postDelete;

    @FindBy(xpath = "//i[@class='oxd-icon bi-trash oxd-button-icon']")
    public WebElement acceptDeleteMsg;
    public BuzzPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

}
