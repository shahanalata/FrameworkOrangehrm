import com.qa.orangehrm.base.TestBase;
import com.qa.orangehrm.pages.AdminPage;
import com.qa.orangehrm.pages.DashBoardPage;
import com.qa.orangehrm.pages.LoginPage;
import com.qa.orangehrm.utils.CommonUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
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
        commonUtils.doKeyDown(1);
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
        adminPage.userNameOne.sendKeys("brandling123S");
        Thread.sleep(2000l);
        adminPage.userRole.click();
        commonUtils.doKeyDown(1);
        Thread.sleep(2000l);
        action.sendKeys("O").perform();
        Thread.sleep(3000l);
        adminPage.employeeNameList.click();
       // commonUtils.doKeyDown(1);
        //action.moveToElement(adminPage.employeeNameList).click();
        //action.sendKeys(adminPage.employeeNameList).click();
         Thread.sleep(2000l);
        adminPage.staTus.click();
        Thread.sleep(2000l);
        commonUtils.doKeyDown(1);
        adminPage.searchButton.click();
        Thread.sleep(2000l);
        adminPage.deleteButton.click();
        Thread.sleep(3000l);
        adminPage.acceptDeleteMsg.click();
    }

   @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000l);
       // driver.quit();
    }
}
