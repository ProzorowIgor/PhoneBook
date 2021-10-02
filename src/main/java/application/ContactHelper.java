package application;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        new WebDriverWait(wd,10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Name']")));
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
       /* new WebDriverWait(wd,10)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".contact-item_card__2SOIM")));*/
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

        new WebDriverWait(wd,10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='CONTACTS']")));
        click(By.xpath("//a[text()='CONTACTS']"));
        //pause(3000);
    }

    public boolean isContactPresent() {
        new WebDriverWait(wd,10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='contact-page_leftdiv__yhyke']//div//div[1]")));

        return isElementPresent(By.xpath("//div[@class='contact-page_leftdiv__yhyke']//div//div[1]"));
    }

    public void pushOnContact() {

        new WebDriverWait(wd,10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='contact-page_leftdiv__yhyke']//div//div[1]")));
        click(By.xpath("//div[@class='contact-page_leftdiv__yhyke']//div//div[1]"));
        //pause(5000);

    }
}
