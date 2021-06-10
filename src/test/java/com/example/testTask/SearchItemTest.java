package com.example.testTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchItemTest {
    WebDriver wd;

    @BeforeMethod
    public void setUp(){
        wd = new ChromeDriver();
        wd. manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://yandex.ru");
    }
    @Test
    public void itemTest(){
        wd.findElement(By.cssSelector("[data-id='market']")).click();

    }
    @AfterMethod(enabled = false)
    public void tearDown(){
        wd.quit();
    }

}
