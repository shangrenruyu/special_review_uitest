package com.phhc.pageObject.platform;

import com.phhc.pageObject.BasePage;
import com.phhc.utils.PageUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author lvwd
 * @data 2022/3/16
 * @apiNote
 */
public class LoginPage extends BasePage {
    /**
     * 用户名输入框
     */
    By usernameBy = By.id("userName");
    /**
     * 密码输入框
     */
    By passwordBy = By.id("password");
    //登录按钮
    By submitBy = By.id("btnSubmit");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    //定义登录的方法
    public void login(String username, String password) {
        //打开登录页面
        openUrl(PageUrl.LOGIN_URL);
        //找到元素，并输入内容
        sendKeys(usernameBy, username);
        sendKeys(passwordBy, password);
        click(submitBy);
    }
}
