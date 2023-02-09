import com.qa.orangehrm.base.TestBase;
import com.qa.orangehrm.pages.AdminPage;
import com.qa.orangehrm.pages.AdminPageDemo;
import com.qa.orangehrm.pages.DashBoardPage;
import com.qa.orangehrm.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class AdminPageDemoTest extends TestBase {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() throws IOException {       //all test cases related to loginPage
        driver = driver_init();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin(prop.getProperty("userName"), prop.getProperty("passWord"));
        DashBoardPage db = new DashBoardPage(driver);
        db.adminButton.click();

    }

@Test
public void validUserManagementTest(){
    AdminPageDemo adminPageDemo = new AdminPageDemo(driver);
    adminPageDemo.userNameEditBox("Shahanalata");
    adminPageDemo.userRoleSelect();
    adminPageDemo.employeeNameEditBox("Shahana");
    adminPageDemo.statusSelect();
    adminPageDemo.searchButtonSelect();
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000l);
        driver.quit();
    }



}


