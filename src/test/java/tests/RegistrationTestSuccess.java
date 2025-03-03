package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTestSuccess extends TestBased{

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        if(app.getUserHelper().isLogOutPresent()){
            app.getUserHelper().logOut();
        }

    }

    @Test
    public void registrationTestSuccess(){
        int i =(int) ((System.currentTimeMillis()/1000)%3600);
        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillLoginRegForm(new User().withEmail("john"+i+"@gmail.com").withPassword("Jj123$"+i));
        app.getUserHelper().clickRegistrationButton();
        Assert.assertTrue(app.getUserHelper().isLogged());

        System.out.println("1========="+Thread.currentThread().getId());
    }

    @Test(dependsOnMethods = "registrationTestSuccess")

    public void registrationNegativeWrongPassword(){
        int i =(int) ((System.currentTimeMillis()/1000)%3600);
        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillLoginRegForm(new User().withEmail("john"+i+"@gmail.com").withPassword("j123$"+i));
        app.getUserHelper().clickRegistrationButton();
        Assert.assertTrue(app.getUserHelper().isAlertPresent());
        System.out.println("2========="+Thread.currentThread().getId());

    }




}
