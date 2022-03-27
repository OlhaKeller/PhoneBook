package tests;

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

    @BeforeMethod
    public void preCondition(){
        //is logged? ->logout
        if(app.getHelperUser().isSingOutPresent()){
            app.getHelperUser().isSingOut();
        }
    }

    @Test
    public void loginSuccessNew(){
        //open login Registration form
        app.getHelperUser().openLoginRegistrationForm();

        //fill email
        app.getHelperUser().fillLoginRegistrationForm("kvitka@gmail.com", "Kvi12345$");
        app.getHelperUser().submitLogin();

      //  type(By.xpath("//input[1]"),"noa@gmail.com");
        //fill password
        //type(By.xpath("//input[2]"),"Nnoa12345$");
        //click button login
        //click(By.xpath("//*[text()=' Login']"));

        //Assert.assertTrue(isElementPresent(By.xpath("//*[text()='Sign Out']")));
        Assert.assertTrue(app.getHelperUser().isLoginRegistrationSuccess());
    }

    @Test
    public void loginSuccessNewModel(){

        User user = new User().withEmail("kvitka@gmail.com").withPassword("Kvi12345$");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();


        Assert.assertTrue(app.getHelperUser().isLoginRegistrationSuccess());
    }
    @Test
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
