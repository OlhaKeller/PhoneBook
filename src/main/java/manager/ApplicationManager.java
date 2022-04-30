package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    //WebDriver wd;//vin ne sluchae Listener
    EventFiringWebDriver wd;// cey vmie proslushuvat sobutia
    HelperUser helperUser;//1 Schritt - contaction between HelperUser and ApplicManager
    HelperContact contact;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);


    public void init(){
        wd =  new EventFiringWebDriver(new ChromeDriver());
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/");
        logger.info("The link is-->" + wd.getCurrentUrl());
        helperUser = new HelperUser(wd);//2 Schritt
        contact = new HelperContact(wd);

        wd.register(new MyListener());//tut mu ix svysala, listener bude fiksuvatu webdriver
    }
    public void stop(){
      //  wd.quit();
    }

    public HelperUser getHelperUser() {   //3 Schritt
        return helperUser;
    }

    public HelperContact contact(){
        return contact;
    }
}
