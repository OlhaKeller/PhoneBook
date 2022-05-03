package tests;

import manager.MyDataProvider;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginSuccess(){
        //open login form
   //     WebElement loginItem = wd.findElement(By.cssSelector("[href='/login']"));
        //loginItem.click();
        //fill Email
        //WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        //emailInput.click();
        //emailInput.clear();//chustka polja
        //emailInput.sendKeys("noa@gmail.com");
        //fill password
        //WebElement passwordInput = wd.findElement(By.xpath("//input[2]"));
        //passwordInput.click();
        //passwordInput.clear();
        //passwordInput.sendKeys("Nnoa12345$");
        //click button login
        //wd.findElement(By.xpath("//*[text()=' Login']")).click();
        //Assert
       // Assert.assertTrue(wd.findElements(By.xpath("//*[text()='Sign Out'")).size()>0);//

    }

    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        //is logged? ->logout
        if(app.getHelperUser().isSignOutPresent()){
            app.getHelperUser().isSignOut();
        }
    }
                                                                                    //enable false, poku wo ne sapuskatu
    @Test (dataProvider = "validLoginData",dataProviderClass = MyDataProvider.class, groups = {"web"},enabled = false)
    public void loginSuccessNew(String email, String password){

        //logger.info("Tests starts with email: 'kvitka@gmail.com' and password: 'Kvi12345$'"); kolu bes data provider
        logger.info("Tests starts with email: "+email+" and password:"+password);
        //open login Registration form
        app.getHelperUser().openLoginRegistrationForm();

        //fill email
        //app.getHelperUser().fillLoginRegistrationForm("kvitka@gmail.com", "Kvi12345$"); kolu bes Dataprovider
        app.getHelperUser().fillLoginRegistrationForm(email, password);
        app.getHelperUser().submitLogin();

      //  type(By.xpath("//input[1]"),"noa@gmail.com");
        //fill password
        //type(By.xpath("//input[2]"),"Nnoa12345$");
        //click button login
        //click(By.xpath("//*[text()=' Login']"));

        //Assert.assertTrue(isElementPresent(By.xpath("//*[text()='Sign Out']")));
        Assert.assertTrue(app.getHelperUser().isLoginRegistrationSuccess());
        logger.info("Test passed");
    }

    @Test
    public void loginSuccessNewModel(){

        User user = new User().withEmail("kvitka@gmail.com").withPassword("Kvi12345$");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();


        Assert.assertTrue(app.getHelperUser().isLoginRegistrationSuccess());
    }

    @Test (dataProvider = "validModelLogin", dataProviderClass = MyDataProvider.class)
    public void loginModelDataProvider(User user){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLoginRegistrationSuccess());
    }

    @Test (dataProvider = "validModelCSV", dataProviderClass = MyDataProvider.class)
    public void loginModelDataProviderCSV(User user){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLoginRegistrationSuccess());
    }

    @Test(groups ={"web"})
    public void loginNegativWrongPassword(){
        User user = new User().withEmail("kvitka@gmail.com").withPassword("12345");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertFalse(app.getHelperUser().isLoginRegistrationSuccess());
        Assert.assertTrue(app.getHelperUser().isAlertDisplay());

        Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());

    }
}
