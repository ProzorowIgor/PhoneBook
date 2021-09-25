package application;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void initAddingNewContact() {
        if (isElementPresent(By.xpath("//a[text()='ADD']"))) {
            click(By.xpath("//a[text()='ADD']"));
        }
    }


    public void fillContactFields(Contact contact) {

        type(By.xpath("//input[@placeholder='Name']"), contact.getName());
        type(By.xpath("//input[@placeholder='Last Name']"), contact.getLastName());
        type(By.xpath("//input[@placeholder='Phone']"), contact.getPhone());
        type(By.xpath("//input[@placeholder='email']"), contact.getEmail());
        type(By.xpath("//input[@placeholder='Address']"), contact.getAddress());
        type(By.xpath("//input[@placeholder='description']"), contact.getDescription());


    }

    public void pushSaveButton() {

        click(By.xpath("//div[@class='add_form__2rsm2']//button"));

    }

    public boolean isContactPageApears() {
            pause(5000);
        return isElementPresent(By.cssSelector(".contact-item_card__2SOIM"));
    }

    /*public void clickOnContact() {

        click(By.xpath("//div[@class='contact-page_leftdiv__yhyke']//div//div[1]"));

    }*/


    public void clickOnContact(int i){
        String path = "//h3[text()='0"+i+"']";

        click(By.xpath(path));


    }


    public void clickOnRemoveButton() {

        click(By.xpath("//button[text()='Remove']"));
    }

    public void clickOnContactBook() {

        click(By.xpath("//a[text()='CONTACTS']"));
    }
}
