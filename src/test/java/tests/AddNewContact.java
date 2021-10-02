package tests;

import models.Contact;
import org.testng.Assert;
import org.testng.annotations.*;

public class AddNewContact extends TestBased {

    int i;

    @BeforeMethod

    public void preCondition() {

        LogInTest.logInSuccess();


    }

    // @Test(invocationCount = 5)
    @Test(priority = 1)
    public void contactAddedSuccess() {
        i = (int) ((System.currentTimeMillis() / 10000));

        Contact contact = Contact.builder()
                .name("George")
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

    // @Test
    @Test(priority = 2)
    public void negativeTestOfAddingContact() {

        Contact contact2 = Contact.builder()
                .name("Bush")
                .lastName("Byden")
                .phone("0" + i)
                .email("VAS" + i + "@mail.ru")
                .address("rehovot, tuval 2/3")
                .description("maybe it works")
                .build();


        app.getContactHelper().initAddingNewContact();
        app.getContactHelper().fillContactFields(contact2);
        app.getContactHelper().pushSaveButton();
        Assert.assertFalse(app.getContactHelper().isContactPageApears());


    }

    // @Test
    @Test(priority = 3)
    public void deleteContact() {
        app.getContactHelper().clickOnContactBook();
        app.getContactHelper().clickOnContact(i);
        app.getContactHelper().clickOnRemoveButton();
    }


    @AfterMethod

    public void postCondition() {
        if (app.getUserHelper().isLogOutPresent()) {
            app.getUserHelper().logOut();
        }

    }
}
