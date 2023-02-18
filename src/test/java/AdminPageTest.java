import com.qa.orangehrm.base.TestBase;
import com.qa.orangehrm.pages.AdminPage;
import com.qa.orangehrm.pages.DashBoardPage;
import com.qa.orangehrm.pages.LoginPage;
import com.qa.orangehrm.utils.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class AdminPageTest extends TestBase {
    public WebDriver driver;
    public AdminPage adminPage;
    public CommonUtils commonUtils;
    public Actions action;

    @BeforeMethod
    public void setUp() throws IOException {
        driver = driver_init();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin(prop.getProperty("userName"), prop.getProperty("passWord"));
        DashBoardPage db = new DashBoardPage(driver);
        db.adminButton.click();
        adminPage = new AdminPage(driver);
        commonUtils = new CommonUtils(driver);
        action = new Actions(driver);

    }

    @Test
    public void validUserManagementTest() throws InterruptedException {
        adminPage.userNameOne.sendKeys("branding123");
        adminPage.userRole.click();
        commonUtils.doKeyDown(1);
        Thread.sleep(2000l);
        adminPage.employeeName.sendKeys("Shahana");
        adminPage.staTus.click();
        commonUtils.doKeyDown(1);
        adminPage.resetButton.click();

    }

    @Test
    public void validAddUserTest() throws InterruptedException {
        Thread.sleep(2000l);
        adminPage.addButton.click();
        Thread.sleep(2000l);
        adminPage.userRole.click();
       // Thread.sleep(2000l);
        //commonUtils.doKeyDown(1);
        //action.moveToElement(adminPage.userRoleOne).click().build().perform();
         JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();",adminPage.userRoleOne);
       // js.executeScript(adminPage.userRoleOne)
        js.executeScript("arguments[0].click();", adminPage.userRoleOne);
        // action.moveToElement(adminPage.userRoleOne).perform();
        Thread.sleep(2000l);
        action.sendKeys("O").perform();
        Thread.sleep(3000l);
        adminPage.employeeNameList.click();
        Thread.sleep(2000l);
        adminPage.staTus.click();
        Thread.sleep(2000l);
        commonUtils.doKeyDown(1);
        Thread.sleep(3000l);
        action.sendKeys("branding123").perform();
        Thread.sleep(3000l);
        adminPage.passWord.sendKeys("Shahana123!");
        Thread.sleep(3000l);
        adminPage.confirmPassWord.sendKeys("Shahana123!");
        Thread.sleep(2000l);
        adminPage.saveButton.click();
    }

    @Test
    public void validUserTest() throws InterruptedException {
        Thread.sleep(2000l);
        adminPage.userNameOne.sendKeys("branding123S");
        Thread.sleep(2000l);
        adminPage.userRole.click();
        commonUtils.doKeyDown(1);
        Thread.sleep(2000l);
        action.sendKeys("O").perform();
        Thread.sleep(3000l);
        adminPage.employeeNameList.click();
        // commonUtils.doKeyDown(1);
        //action.sendKeys(adminPage.employeeNameList).click();
        Thread.sleep(2000l);
        adminPage.staTus.click();
        Thread.sleep(2000l);
        commonUtils.doKeyDown(1);
        Thread.sleep(2000l);
        adminPage.searchButton.click();
        Thread.sleep(2000l);
        adminPage.deleteButton.click();
        Thread.sleep(3000l);
        adminPage.acceptDeleteMsg.click();
        String b = adminPage.toastMsg.getText();
        System.out.println(b);
    }

    @Test
    public void validRecordTest() throws InterruptedException {
        action.moveToElement(adminPage.foundChart).perform();
        int totalList = adminPage.recordList.size();
        System.out.println("The size of the list:  "+totalList);//manually also show 50 users but msg is written 79/ sometimes 80
        String s = adminPage.foundRecordMSG.getText();
        System.out.println("Message of the recordlist: "+s);

        StringBuffer st = new StringBuffer(s);
        st.delete(3, 18);
        st.deleteCharAt(0);
        System.out.println("Number of the recordlist: "+st);
        Assert.assertEquals(totalList, Integer.parseInt(String.valueOf(st)));
        //wrapper class


    }
    @Test
    public void validCheckList() throws InterruptedException {
        action.moveToElement(adminPage.foundChart).perform();
        Thread.sleep(2000l);
        adminPage.checkList.click();
        Thread.sleep(2000l);
        adminPage.checkList.click();
        Thread.sleep(2000l);
        adminPage.userAscending.click();
        Thread.sleep(2000l);
        action.moveToElement(adminPage.ascendingBtn).click().build().perform();
        Thread.sleep(2000l);
        action.moveToElement(adminPage.checkButton).click().build().perform();
        Thread.sleep(2000l);
        adminPage.deleteMsgUP.click();
        Thread.sleep(2000l);
        adminPage.acceptDeleteMsg.click();
        Thread.sleep(2000l);
        String d = adminPage.toastMsg.getText();
        System.out.println(d);
    }

    // String b = adminPage.deleteMsgUP.getText();
    //System.out.println(b);

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000l);
        driver.quit();
    }
}
