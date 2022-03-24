package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Registration extends TestBase{


    @BeforeMethod
    public void preCondition(){
        //is logged? ->logout
        if(app.getHelperUser().isSingOutPresent()){
            app.getHelperUser().isSingOut();
        }
    }

    @Test
    public void registrationSuccess(){
    //open regform
        int index = (int)(System.currentTimeMillis()/1000)%36000;
        System.out.print(index);

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("zha"+index+"@gmail.com","Cha12345$");
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isLoginRegistrationSuccess());

        //fill email
        //fill password
        //clickregistration
        
    }
    @Test
    public void registrationSuccessModel(){

        int index = (int)(System.currentTimeMillis()/1000)%36000;
        System.out.print(index);
        //System.out.print(index);
        User user = new User().withEmail("zha"+index+"@gmail.com").withPassword("Cha12345$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

       // Assert.assertTrue(app.getHelperUser().isLoginRegistrationSuccess());
        Assert.assertTrue(app.getHelperUser().isLoginRegistrationSuccess());
    }
}