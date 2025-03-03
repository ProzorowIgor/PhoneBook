package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ParallelClass {
    WebDriver wd;

    @Test
    public void test1(){
        wd = new ChromeDriver();
        wd.navigate().to("https://www.google.com/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("1===========" +Thread.currentThread().getId());


    }

    @Test(threadPoolSize = 3, invocationCount = 10,  invocationTimeOut = 10000)
    public void test2(){
        wd = new FirefoxDriver();
        wd.navigate().to("https://www.google.com/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("1===========" +Thread.currentThread().getId());


    }


}
