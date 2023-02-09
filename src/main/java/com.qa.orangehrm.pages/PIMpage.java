package com.qa.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMpage {
    private WebDriver driver;

    @FindBy(xpath="(//input[@placeholder='Type for hints...'])[1]")
    public WebElement employeeName;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    public WebElement employeeID;

    @FindBy(xpath="(//input[@placeholder='Type for hints...'])[2]")
    public WebElement supervisorName;

    @FindBy(xpath ="(//div[@class='oxd-select-text--after']//i)[1]")
    public WebElement employmentStatus;

    @FindBy(xpath="(//div[@class='oxd-select-text--after']//i)[2]")
    public WebElement includeStatus;

    @FindBy(xpath = "(//div[@class='oxd-select-text--after']//i)[3]")
    public WebElement jobTitle;

    @FindBy(xpath ="(//div[@class='oxd-select-text--after']//i)[4]")
    public WebElement subUnit;

    @FindBy(xpath="//button[@type='reset']")
    public WebElement resetButton;







   public PIMpage(WebDriver driver) {

       PageFactory.initElements(driver,this);
   }

}
