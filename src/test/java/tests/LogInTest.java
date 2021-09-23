package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LogInTest extends TestBased {



    @Test

    public static void logInSuccess(){
        User user = new User()
                .withEmail("VASYA@mail.ru").withPassword("Awww123~");
        app.getUserHelper().fillLogInForm(user);

    }

   /* @Test

    public void negativeLogIn(){

        User user2 = new User()
                .withEmail("VASYAmail.ru").withPassword("Awww123~");
        app.getUserHelper().fillLogInForm(user2);
        Assert.assertFalse(app.getUserHelper().isLogOutPresent());

    }*/

    @AfterMethod

    public void postCondition(){
        if(app.getUserHelper().isLogOutPresent()) {
            app.getUserHelper().logOut();
        }
    }



}
