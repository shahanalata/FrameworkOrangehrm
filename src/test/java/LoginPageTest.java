import com.qa.orangehrm.base.TestBase;
import com.qa.orangehrm.pages.DashBoardPage;
import com.qa.orangehrm.pages.LoginPage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTest extends TestBase {    //browser invocation
    // child class (inheritance concept) extends parent/super class to get all properties from there
public WebDriver driver;

 @BeforeMethod
 public void setUp() throws IOException {       //all test cases related to loginPage
    driver = driver_init();
 }

 @Test
    public void validLoginTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.userName.sendKeys("Admin");
        loginPage.passWord.sendKeys("admin123");
        loginPage.loginButton.click();

    }
    @Test
    public void forgotPasswordTest(){
     LoginPage loginPage = new LoginPage(driver);
     boolean b = loginPage.forgotPassword.isDisplayed();
     Assert.assertTrue(b);
 }
    @Test
    public void pageTitleTest() {
        String actualPageTitle = driver.getTitle();
        String expectedPageTitle = "OrangeHRM";
        System.out.println("Actual page title is : --> " + actualPageTitle);
        Assert.assertEquals(actualPageTitle, expectedPageTitle);
        //boolean b = actualPageTitle.equals(expectedPageTitle);
        // Assert.assertTrue(b);
 }
 @Test
 public void validLogo(){
     LoginPage loginPage = new LoginPage(driver);
     boolean b = loginPage.logo.isDisplayed();
     //Assert.assertTrue(b);
 }

@Test
public void validLoginTestOptimize(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.userName.sendKeys(prop.getProperty("userName"));
    loginPage.passWord.sendKeys(prop.getProperty("passWord"));
    loginPage.loginButton.click();
    DashBoardPage dashboardPage = new DashBoardPage(driver);
  //  dashboardPage.successLoginMsg.isDisplayed();
    Assert.assertTrue( dashboardPage.successLoginMsg.isDisplayed());
}
@AfterMethod
public void tearDown() throws InterruptedException {
     Thread.sleep(3000l);
     driver.quit();
}

}
