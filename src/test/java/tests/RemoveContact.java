package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContact extends TestBased{

    @BeforeClass

    public void precondition() {

        LogInTest.logInSuccess();
    }

  /*  @Test

    public void deleteContact(){
        app.getContactHelper().clickOnContactBook();
        if(app.getContactHelper().isContactPresent()){

            app.getContactHelper().deleteContact();
        }
    }*/

    @Test

    public void deleteAllContacts(){

        app.getContactHelper().clickOnContactBook();
        while (app.getContactHelper().isContactPresent()==true) {

            app.getContactHelper().pushOnContact();
            app.getContactHelper().clickOnRemoveButton();
            app.getContactHelper().clickOnContactBook();
        }

    }


}
