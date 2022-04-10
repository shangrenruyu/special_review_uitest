package com.phhc.pageObject;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;


public class BasePage {
    public WebDriver driver;
    private final int TIMEOUT = 10;//单位秒
    public static WebDriverWait waitTime;
    public static int  eleWaitTime;

    //需要获取到驱动
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT) , this);
    }

    BasePage(WebDriver driver, final String title) {
        this.driver = driver;

        //如果不进行判断，
        WebDriverWait wait = new WebDriverWait(driver,TIMEOUT);
        try{
            boolean flag = wait.until(new ExpectedCondition<Boolean>(){
                @Override
                public Boolean apply(WebDriver arg0) {
                    // TODO Auto-generated method stub
                    String acttitle = arg0.getTitle();
                    return acttitle.equals(title);
                }});
        }catch(TimeoutException te) {
            throw new IllegalStateException("当前不是预期页面，当前页面title是：" + driver.getTitle());
        }

        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT) , this);

    }

    /*
     * 等待元素可点击
     * */
    public static WebElement waitElementCanClickable(WebDriver driver,WebElement element){
        waitTime = new WebDriverWait(driver,eleWaitTime);
        return waitTime.until(ExpectedConditions.elementToBeClickable(element));
    }


    /*
     * 等待元素可点击
     * */
    public static WebElement waitElementCanClickable(WebDriver driver,By element){
        waitTime = new WebDriverWait(driver,eleWaitTime);
        return waitTime.until(ExpectedConditions.elementToBeClickable(element));
    }


    //查找页面元素
    public WebElement getElement(By by) {
        return driver.findElement(by);
    }

    //查找页面多个元素
    public List<WebElement> getElements(By by) {
        return driver.findElements(by);
    }

    //简略--输入框，情况内容-设置内容

    /**
     * 直接找到元素进行清空，并设置内容
     *
     * @param by 定位元素的方式
     * @param s  输入的内容
     */
    public void sendKeys(By by, String s) {
        getElements(by).clear();
        getElement(by).sendKeys(s);

    }

    /**
     * 元素点击操作
     *
     * @param by
     */
    public void click(By by) {
        getElement(by).click();
    }

    public void click(WebElement webElement) {
        webElement.click();
    }

    //截屏操作
    public void getScreen(String des) {
        //强制类型转换,将driver转换成能够截屏的对象
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        //进行截屏-获取文件
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        //将内存中的文件,存储到本地
        try {
            //复制操作
            long l = System.currentTimeMillis();
            FileUtils.copyFile(file, new File(l + des + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //处理弹框-让弹框消失
    public void dismissAlert() {
        try {
            driver.switchTo().alert().dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    //接受弹框内容-确认键
    public void acceptAlert() {
        try {
            driver.switchTo().alert().dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //切换iframe
    public void switchToIframe(WebElement s) {
        try {
            driver.switchTo().frame(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //窗口操作
    public void switchWindow() {
        try {
            //获取当前窗口
            String current = driver.getWindowHandle();
            //获取所有窗口
            Set<String> windowHandles = driver.getWindowHandles();
            for (String s : windowHandles) {
                if (!s.equals(current)) {
                    //关闭当前window
                    driver.close();
                    driver.switchTo().window(s);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //cookie处理
    public void addCookie(String name, String value, String path) {
        Cookie cookie = new Cookie(name, value, path);
        driver.manage().addCookie(cookie);
    }

    //获取当前标题
    public String getTitle() {
        return driver.getTitle();
    }

    //打开路径
    public void openUrl(String url) {
        driver.get(url);
    }
}