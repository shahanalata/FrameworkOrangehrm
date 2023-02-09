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

public class TestBase {   //driver invocation in this page

public WebDriver driver;
 public Properties prop;
  public  FileInputStream fis;
  public WebDriver driver_init() throws IOException {
      //  Properties pro = new Properties();
      prop = new Properties();//where see properties file, file can read by properties Class,
      // FileInputStream fil= new FileInputStream();
      fis = new FileInputStream("C:\\Users\\shahana\\IdeaProjects\\OrangeFrameWork\\src\\main\\java\\com.qa.orangehrm.config\\config.properties");//file location where the file is
      prop.load(fis);
    // prop.getProperty("browser_Name");//firefox/edge/safari-we can change in config file
     //prop.getProperty("url");

       String browser_Name ="chrome";//firefox/edge/safari/*//different type of url,for different stage//properties file*/

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
      driver. manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3000l));//for browser page loading-for whole page
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000l));//-for all web element.global wait-if need it will wait,if no need no wait
     driver.get(prop.getProperty("url"));
     return driver;
  }

    public static void main(String[] args) throws IOException {
      TestBase tb = new TestBase();
      tb.driver_init();

    }

}
