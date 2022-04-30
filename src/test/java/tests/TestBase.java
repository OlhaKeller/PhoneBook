package tests;

import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();//verxnyja ssulka
    Logger logger= LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void startLogger(Method m){logger.info("Start test --->" +m.getName());}

    @BeforeSuite
    public void setUp(){

        app.init();
   }

    @AfterSuite
    public void tearDown(){
        //app.stop();
    }


}
