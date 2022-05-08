package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Registration extends TestBase{


    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        //is logged? ->logout
        if(app.getHelperUser().isSignOutPresent()){
            app.getHelperUser().isSignOut();
        }
    }

    @Test(groups ={"web"})
    public void registrationSuccess(){
    //open regform
        int index = (int)(System.currentTimeMillis()/1000)%3600;
        System.out.print("zha"+index+"@gmail.com");
        logger.info("zha"+index+"@gmail.com");
        logger.info("The index is:"+index);


        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("zha"+index+"@gmail.com","Cha12345$");
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isLoginRegistrationSuccess());
        logger.info("end of test");
        //fill email
        //fill password
        //clickregistration
        
    }
    @Test
    public void registrationSuccessModel(){

        int index = (int)(System.currentTimeMillis()/1000)%36000;
        System.out.print(index);
        //System.out.print(index);
        User user = new User()
                .withEmail("zha"+index+"@gmail.com")
                .withPassword("Cha12345$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

       // Assert.assertTrue(app.getHelperUser().isLoginRegistrationSuccess());
        Assert.assertTrue(app.getHelperUser().isLoginRegistrationSuccess());
    }


}
