package application;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase {
    public UserHelper(WebDriver wd) {
        super(wd);
    }


    public void fillLogInForm(User user) {
        click(By.xpath("//a[text()='LOGIN']"));
        pause(5000);
        type(By.cssSelector("input[placeholder='Email']"), user.getEmail());
        type(By.cssSelector("input[placeholder='Password']"), user.getPassword());
        click(By.xpath("//button[text()=' Login']"));
    }

    public void logOut() {

        click(By.xpath("//button[text()='Sign Out']"));

    }

    public boolean isLogOutPresent() {

        return isElementPresent(By.xpath("//button[text()='Sign Out']"));

    }
}
