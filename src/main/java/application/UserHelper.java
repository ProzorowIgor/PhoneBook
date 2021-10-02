package application;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends HelperBase {
    public UserHelper(WebDriver wd) {
        super(wd);
    }


    public void fillLogInForm(User user) {
        click(By.xpath("//a[text()='LOGIN']"));
        pause(3000);
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

    public void openLoginRegistrationForm() {
        click(By.xpath("//a[.='LOGIN']"));
    }

    public void clickRegistrationButton() {
        click(By.xpath("//button[2]"));
    }

    public boolean isLogged() {
        return wd.findElements(By.xpath("//*[text()='Sign Out']")).size() > 0;
    }

    public boolean isAlertPresent() {

        Alert alert = new WebDriverWait(wd, 10)
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            alert.accept();
            return true;
        }
    }

    public void fillLoginRegForm(User user) {
        type(By.xpath("//input[1]"), user.getEmail());
        type(By.xpath("//input[2]"), user.getPassword());
    }
}
