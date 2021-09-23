package tests;

import models.Contact;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContact extends TestBased {

    @BeforeMethod

    public void preCondition() {

        LogInTest.logInSuccess();


    }

    @Test

    public void contactAddedSuccess() {
        int i = (int) ((System.currentTimeMillis() / 10000));

        Contact contact = Contact.builder()
                .name("Obama")
                .lastName("Byden")
                .phone("0" + i)
                .email("VAS" + i + "@mail.ru")
                .address("rehovot, tuval 2/3")
                .description("maybe it works")
                .build();


        app.getContactHelper().initAddingNewContact();
        app.getContactHelper().fillContactFields(contact);
        app.getContactHelper().pushSaveButton();
        Assert.assertTrue(app.getContactHelper().isContactPageApears());
    }

  /*  @Test

    public void negativeTestOfAddingContact() {




    }*/

    @Test

    public void deleteContact() {
        app.getContactHelper().clickOnContact();
        app.getContactHelper().clickOnRemoveButton();


    }


    @AfterMethod

    public void postCondition() {
        if (app.getUserHelper().isLogOutPresent()) {
            app.getUserHelper().logOut();
        }

    }
}
