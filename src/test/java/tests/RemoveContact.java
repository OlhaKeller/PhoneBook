package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContact extends TestBase{

    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if(!app.getHelperUser().isSignOutPresent()){
            app.getHelperUser().login(new User().withEmail("kvitka@gmail.com").withPassword("Kvi12345$"));
        }
        app.contact().provideContactData();
    }

    @Test(groups ={"web"}, priority = 1)
    public void removeOneContact(){
        //count before
        Assert.assertEquals(app.contact().removeOneContact(),1);
        //count after
        //assert(before-after, 1)
    }

    @Test(priority = 2)
    public void removeAllContact(){
        app.contact().removeAllContacts();

    }
}
