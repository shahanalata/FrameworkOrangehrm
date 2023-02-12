import com.qa.orangehrm.base.TestBase;
import com.qa.orangehrm.pages.DashBoardPage;
import com.qa.orangehrm.pages.LoginPage;
import com.qa.orangehrm.pages.PIMpage;
import com.qa.orangehrm.utils.CommonUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class PIMpageTest extends TestBase {
    public WebDriver driver;
    public Actions action;
    public CommonUtils commonutils;

    @BeforeMethod
    public void setUp() throws IOException {
        driver = driver_init();
        action = new Actions(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin(prop.getProperty("userName"), prop.getProperty("passWord"));
        DashBoardPage db = new DashBoardPage(driver);
        db.pimButton.click();
        commonutils = new CommonUtils(driver);
    }

    @Test
    public void validEmployeeListTest() throws InterruptedException {
        PIMpage pimPage = new PIMpage(driver);
        pimPage.employeeName.sendKeys("Shahana");
        pimPage.employeeID.sendKeys("00123");
        pimPage.employmentStatus.click();
        Thread.sleep(2000l);
        commonutils.doKeyDown(2);
        Thread.sleep(2000l);
        //pimPage.includeStatus.click();
        action.doubleClick(pimPage.includeStatus).perform();
        commonutils.doKeyDown(2);
        pimPage.supervisorName.sendKeys("Rahman");
        Thread.sleep(3000l);
        pimPage.jobTitle.click();
        action.doubleClick(pimPage.jobTitle).perform();
        commonutils.doKeyDown(1);
        Thread.sleep(3000l);
        //pimPage.subUnit.click();
        action.doubleClick(pimPage.subUnit).perform();
        commonutils.doKeyDown(3);
        Thread.sleep(2000l);
        pimPage.resetButton.click();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000l);
        driver.quit();
    }


}
