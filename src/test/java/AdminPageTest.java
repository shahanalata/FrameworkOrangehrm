import com.qa.orangehrm.base.TestBase;
import com.qa.orangehrm.pages.AdminPage;
import com.qa.orangehrm.pages.DashBoardPage;
import com.qa.orangehrm.pages.LoginPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class AdminPageTest extends TestBase {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() throws IOException {
      driver   = driver_init();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin(prop.getProperty("userName"), prop.getProperty("passWord"));
        DashBoardPage db = new DashBoardPage(driver);
        db.adminButton.click();

    }

   @Test
   public void validUserManagementTest() throws InterruptedException {
        AdminPage adminPage = new AdminPage(driver);
        Thread.sleep(2000l);
        adminPage.userName.sendKeys("Shahanalata");
        adminPage.userRole.click();
       Actions action = new Actions(driver);
       action.keyDown(Keys.ARROW_DOWN).perform();
       //action.keyDown(Keys.ARROW_DOWN).perform();//for double arrow down
       action.keyDown(Keys.TAB).perform();
       adminPage.employeeName.sendKeys("Shahana");
       adminPage.staTus.click();
       action.keyDown(Keys.ARROW_DOWN).perform();
       action.keyDown(Keys.TAB).perform();
       adminPage.searchButton.click();

   }

   @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000l);
        driver.quit();
    }
}
