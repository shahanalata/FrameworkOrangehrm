import com.qa.orangehrm.base.TestBase;
import com.qa.orangehrm.pages.AdminPage;
import com.qa.orangehrm.pages.BuzzPage;
import com.qa.orangehrm.pages.DashBoardPage;
import com.qa.orangehrm.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class BuzzPageTest extends TestBase {

    public WebDriver driver;
    public LoginPage loginPage;
    public BuzzPage buzzPage;

    public Actions action;

    @BeforeMethod
    public void setUp() throws IOException {
        driver = driver_init();
        loginPage = new LoginPage(driver);
        loginPage.doLogin(prop.getProperty("userName"), prop.getProperty("passWord"));
        DashBoardPage db = new DashBoardPage(driver);
        db.buzzButton.click();
        buzzPage = new BuzzPage(driver);
        action = new Actions(driver);
    }

    @Test
    public void ValidReviewTest() throws InterruptedException {
        Thread.sleep(2000l);
        buzzPage.textBox.sendKeys("Hi! This is a free and open source HR software");
        Thread.sleep(3000l);
        //buzzPage.postButton.click();
        action.moveToElement(buzzPage.postButton).click().build().perform();
        Thread.sleep(2000l);
        buzzPage.deleteButton.click();
        Thread.sleep(3000l);
        action.moveToElement(buzzPage.postDelete).click().build().perform();
        Thread.sleep(3000l);
        buzzPage.acceptDeleteMsg.click();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000l);
        driver.quit();
    }


}
