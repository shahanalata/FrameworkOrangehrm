import com.qa.orangehrm.base.TestBase;
import com.qa.orangehrm.pages.DashBoardPage;
import com.qa.orangehrm.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class DashBoardPageTest extends TestBase {
   public WebDriver driver;
@BeforeMethod
public void setUp() throws IOException {
    //TestBase tb = new TestBase();
   // tb.driver_init();
      driver = driver_init();
      LoginPage loginPage = new LoginPage(driver);
   loginPage.userName.sendKeys(prop.getProperty("userName"));
    loginPage.passWord.sendKeys(prop.getProperty("passWord"));
    loginPage.loginButton.click();
   // loginPage.doLogin(prop.getProperty("userName"), prop.getProperty("passWord"));
}


@Test
public void myActionsTagTest() throws InterruptedException {
    DashBoardPage db = new DashBoardPage(driver);
    Thread.sleep(2000l);
    String actualTag = db.myActionsTag.getText();
    String expectedTag ="My Actions";//My Actions
    System.out.println(actualTag);
   Assert.assertTrue(actualTag.equals(expectedTag));
    //boolean b = actualTag.equals(expectedTag);
   // Assert.assertTrue(b);
}
@AfterMethod
    public void TearDown() throws InterruptedException {
    Thread.sleep(3000l);
    driver.quit();
}

}
