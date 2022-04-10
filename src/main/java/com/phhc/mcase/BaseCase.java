package com.phhc.mcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseCase {
    public static WebDriver webDriver;

    //还是testng框架
    @BeforeClass
    public void beforeClass() {
        //获取webDriver
        webDriver = new ChromeDriver();
        //进行窗口最大化设置
        webDriver.manage().window().maximize();
        //设置隐式等待
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void afterClass() {
        try {
            Thread.sleep(2000);
            //退出浏览器
            webDriver.quit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
