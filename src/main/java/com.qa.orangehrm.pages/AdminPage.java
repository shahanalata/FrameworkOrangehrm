package com.qa.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active oxd-input--error']")
    public WebElement userName;
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    public WebElement userNameOne;
    @FindBy(xpath = "//div[@class='oxd-select-text oxd-select-text--active']//div//i[1]")
    public WebElement userRole;

    @FindBy(xpath = "//div[@class='oxd-select-text oxd-select-text--active']//div[text()='Admin']")
    public WebElement userRoleOne;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    public WebElement employeeName;

    @FindBy(xpath = "//div[@role='listbox']//div[1]")
    public WebElement employeeNameList;

    @FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]")
    public WebElement staTus;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    public WebElement addButton;

     @FindBy(xpath = "(//input[@type='password'])[1]")
     public WebElement passWord;

     @FindBy(xpath = "(//input[@type='password'])[2]")
     public WebElement confirmPassWord;

      @FindBy(xpath = "//button[@type='submit']")
      public WebElement saveButton;

    @FindBy(xpath = "//button[text()=' Search ']")
    public WebElement searchButton;

    @FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
    public WebElement deleteButton;

    @FindBy(xpath = "//i[@class='oxd-icon bi-trash oxd-button-icon']")
    public WebElement acceptDeleteMsg;
    @FindBy(xpath = "//button[text()=' Reset ']")
    public WebElement resetButton;
    @FindBy(xpath = "//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']//div[@class='oxd-toast-content oxd-toast-content--success']")
    public WebElement toastMsg;

    @FindBy(xpath = "//div[@class='orangehrm-container']//div[@role='rowgroup'][2]/div")
    public WebElement foundChart;

    //div[@role='rowgroup'][2]
    @FindBy(xpath = "//div[@class='orangehrm-container']//div[@role='rowgroup'][2]/div")
    public List<WebElement> recordList;

    @FindBy(xpath = "//div[@class='oxd-table-header-cell oxd-padding-cell oxd-table-th']//label")
    public WebElement checkList;

    @FindBy(xpath="//i[@class='oxd-icon bi-trash-fill oxd-button-icon']")
    public WebElement deleteMsgUP;

    @FindBy(xpath="//div[text()='Username']//div[@class='oxd-table-header-sort']")
    public WebElement userAscending;

    @FindBy(xpath = "//ul[@role='menu']//li//span[text()='Ascending']")
    public WebElement ascendingBtn;

     @FindBy(xpath = "(//div[@class='oxd-table-row oxd-table-row--with-border']//div//div//label/input[@type='checkbox'])[2]")
     public WebElement checkButton;

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span']")
    public WebElement foundRecordMSG;
  public AdminPage(WebDriver driver)  {

      PageFactory.initElements(driver,this);


  }


}




