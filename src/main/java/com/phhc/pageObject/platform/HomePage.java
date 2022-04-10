package com.phhc.pageObject.platform;

import com.phhc.pageObject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author lvwd
 * @data 2022/3/30
 * @apiNote
 */
public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }


    /**
     * @descripiton 系统管理
     * */
    @FindBy(css = "body > div.easyui-layout.layout.easyui-fluid > div.panel.layout-panel.layout-panel-center > div > div > ul > li:nth-child(1) > div.num")
    WebElement link_system_management;

    /**
     * @description 审方中心
     */
    @FindBy(css = "body > div.easyui-layout.layout.easyui-fluid > div.panel.layout-panel.layout-panel-center > div > div > ul > li:nth-child(2) > div.num > h1")
    WebElement link_pre_center;

    /**
     * @descripiton 临床药师工作站
     * */
    @FindBy(css = ".solution-item>ul>li:nth-child(3) h1")
    WebElement link_pharworkstation;

    /**
     * @description 临床药师工作站第二层索引 处方点评
     * */
    @FindBy(css = ".solution-item>ul>li:nth-child(3) div:nth-child(3) > p")
    WebElement link_rp_review;

    /**
     * @description 临床药师工作站第二层索引 医嘱点评
     * */
    @FindBy(css = ".solution-item>ul>li:nth-child(3) div:nth-child(4) > p")
    WebElement link_zy_review;

    /**
     * @description 临床药师工作站第二层索引 专项点评
     * */
    @FindBy(css = ".solution-item>ul>li:nth-child(3) div:nth-last-child(2) > p")
    WebElement link_special_review;










}
