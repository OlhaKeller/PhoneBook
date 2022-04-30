package tests;

import manager.TestNgMyListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNgMyListener.class)   //Mozna pered koznum testom Listener pusatu
public class OpenWiki {               //a mozna stvorutu konfigurazionuy file, jk Logback

    WebDriver wd;
    @Test
    public void openWikipedia(){
    wd = new ChromeDriver();
    wd.get("https://de.wikipedia.org");
    }

}
