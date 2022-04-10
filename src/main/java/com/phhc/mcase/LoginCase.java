package com.phhc.mcase;

import com.phhc.pageObject.platform.LoginPage;
import com.phhc.utils.MyUtils;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author lvwd
 * @data 2022/3/16
 * @apiNote
 */

@Feature("登录测试用例")
public class LoginCase extends BaseCase{
    @Story("准备单个的数据集合，登录成功")
    @Test
    public void testSingleLoginSuccess() {
        //登录的测试逻辑...
        //准备数据.csv放置数据,csv的操作，公共性的东西，准备工具类...
        List<String> data = MyUtils.getData("src/main/resources/user_success.csv");
        //根据索引获取一行数据
        String s = data.get(0);
        //获取字符串数组
        String[] split = s.split(",");
        //创建登录类对象
        LoginPage loginPage = new LoginPage(webDriver);
        //进行登录
        loginPage.login(split[0], split[1]);
        //进行断言
        Assert.assertEquals(loginPage.getTitle(), "PHHC合理用药监控系统");
        System.out.println(webDriver.manage().getCookies());
    }

    //使用数据驱动方式进行
    //创建一个数据提供者，在这个函数中，提供参数
    @DataProvider(name = "csvSuccessData")
    public Object[][] csvSuccessData() {
        return getDataProvider("src/main/resources/user_success.csv");
    }

    @DataProvider(name = "csvFailerData")
    public Object[][] csvFailerData() {
        return getDataProvider("src/main/resources/user_failer.csv");
    }


    public Object[][] getDataProvider(String path) {
        List<String> data = MyUtils.getData(path);
        //定义一个二维数组
        Object[][] objectArray = new Object[data.size()][2];
        for (int i = 0; i < data.size(); i++) {
            String s = data.get(i);
            //进行字符串分割
            String[] split = s.split(",");
            for (int j = 0; j < split.length; j++) {
                objectArray[i][j] = split[j];
            }
        }
        return objectArray;
    }


    @Test(dataProvider = "csvSuccessData")
    public void testLoginSuccess(String username, String password) {
        //创建登录类对象
        LoginPage loginPage = new LoginPage(webDriver);
        //进行登录
        loginPage.login(username, password);
        //进行断言
        Assert.assertEquals(loginPage.getTitle(), "PHHC合理用药监控系统");
    }

    @Story("准备错误的数据集合，登录失败")
    @Test(dataProvider = "csvFailerData")
    public void testLoginFailer(String username, String password) {
        //创建登录类对象
        LoginPage loginPage = new LoginPage(webDriver);
        //进行登录
        loginPage.login(username, password);
        //进行断言
        Assert.assertNotEquals(loginPage.getTitle(), "PHHC合理用药监控系统");
    }
}
