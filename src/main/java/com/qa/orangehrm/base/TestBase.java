package com.qa.orangehrm.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

public WebDriver driver;
 public Properties prop;
  public  FileInputStream fis;
  public void driver_init() throws IOException {
      prop = new Properties();//where see properties file, file can read by properties Class,
      fis = new FileInputStream("C:\\Users\\shahana\\IdeaProjects\\OrangeFrameWork\\src\\main\\java\\com\\qa\\orangehrm\\config\\config.properties");//file location where the file is
      prop.load(fis);
     // prop.getProperty("browser_Name");//firefox/edge/safari-we can change in config file
    //  prop.getProperty("url");

       String browser_Name ="chrome";//firefox/edge/safari

      if(browser_Name.equalsIgnoreCase("Chrome")){
           driver = new ChromeDriver();
      }else if (browser_Name.equalsIgnoreCase("firefox")) {
          driver = new FirefoxDriver();
      }else if (browser_Name.equalsIgnoreCase("safari")) {
           driver = new SafariDriver();
      }else if (browser_Name.equalsIgnoreCase("edge")) {
         driver = new EdgeDriver();
      }else{
          System.out.println("Please provide current browser name");
      }
      driver.manage().window().maximize();
      driver.manage().deleteAllCookies();
      driver. manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));//for browser page loading-for whole page
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));//-for all web element.global wait-if need it will wait,if no need no wait
     driver.get(prop.getProperty("url"));
  }

    public static void main(String[] args) throws IOException {
      TestBase tb = new TestBase();
      tb.driver_init();

    }
}
