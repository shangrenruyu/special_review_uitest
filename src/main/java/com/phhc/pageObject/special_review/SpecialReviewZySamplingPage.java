package com.phhc.pageObject.special_review;

import com.phhc.pageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.phhc.utils.MyUtils.getRandomStr;
import static com.phhc.utils.PageUrl.SPECIAL_REVIEW_ZY_SAMPLING_URL;

/**
 * @author lvwd
 * @data 2022/3/21
 * @apiNote
 */
public class SpecialReviewZySamplingPage extends BasePage {
    //新增批次按钮
    By newBatchButton = By.cssSelector("#dglinkbutton00 > span > span");

    //新增抽样批次页面
    By newBatchWindow = By.cssSelector(".panel.window.easyui-fluid");

    //请输入方案名称
    //By inputPlanName = By.cssSelector("#form-1 > div:nth-child(1) > span > input.textbox-text.validatebox-text.textbox-prompt");
    By inputPlanName = By.xpath("//*[@id=\"form-1\"]/div[1]/span/input[1]");

    //通过方案名称查询按钮
    By clickPlanName = By.xpath("//*[@id=\"form-1\"]/div[1]/span/span/a");


    public SpecialReviewZySamplingPage(WebDriver driver) {
        super(driver);
    }

    //新增批次
    public void newBatch() {
        //打开医嘱抽样页面
        openUrl(SPECIAL_REVIEW_ZY_SAMPLING_URL);
        //找到新增按钮，点击新增
        click(newBatchButton);


    }


    public void toIframe() {
        //抽样子页面iframe
        //By batchWindow = By.xpath("//*[@id=\"myWindow\"]/iframe");
        try {
            WebElement batchWindow = driver.findElement(By.xpath("//*[@id=\"myWindow\"]/iframe"));

            switchToIframe(batchWindow);

            //List<WebElement> elements = driver.findElements(By.cssSelector("#plist>li"));
            //
            //sendKeys(inputPlanName,"只抽围术期");
            //
            //click(clickPlanName);

            By selectPlan = By.cssSelector("#plist > li:nth-child(7) > input[type=radio]");

            click(selectPlan);

            WebElement selector = driver.findElement(By.id("scheme_date_type"));
            Select select = new Select(selector);
            select.selectByVisibleText("入院日期");

            //开始时间-左
            WebElement beforeDateLeft = driver.findElement(By.cssSelector("#form-1 > div:nth-child(5) > span:nth-child(3) > input.textbox-text.validatebox-text.validatebox-invalid.textbox-prompt"));
            beforeDateLeft.sendKeys("2021-12-08");


            //开始时间-左-具体日期
            WebElement beforeDateLeftTime = driver.findElement(By.cssSelector("body > div:nth-child(3) > div > div.datebox-calendar-inner.panel-noscroll > div > div.calendar-body > table > tbody > tr:nth-child(2) > td.calendar-day.calendar-selected"));
            Thread.sleep(2000);
            beforeDateLeftTime.click();


            //开始时间-右
            WebElement beforeDateRight = driver.findElement(By.cssSelector("#form-1 > div:nth-child(5) > span:nth-child(5) > input.textbox-text.validatebox-text.validatebox-invalid.textbox-prompt"));
            beforeDateRight.sendKeys("2021-12-08");

            //开始时间-右-具体日期

            WebElement beforeDateRightTime = driver.findElement(By.cssSelector("body > div:nth-child(4) > div > div.datebox-calendar-inner.panel-noscroll > div > div.calendar-body > table > tbody > tr:nth-child(2) > td.calendar-day.calendar-selected"));
            Thread.sleep(2000);
            beforeDateRightTime.click();
            Thread.sleep(2000);


            //结束时间-左
            WebElement afterDateLeft = driver.findElement(By.xpath("//*[@id=\"form-1\"]/div[6]/span[1]"));
            afterDateLeft.click();
            Thread.sleep(2000);

            //结束时间-左-具体时间
            WebElement afterDateLeftTime = driver.findElement(By.cssSelector("body > div:nth-child(5) > div > div.datebox-calendar-inner.panel-noscroll > div > div.calendar-body > table > tbody > tr:nth-child(4) > td:nth-child(6)"));
            afterDateLeftTime.click();

            Thread.sleep(1000);
            //结束时间-右
            WebElement afterDateRight = driver.findElement(By.xpath("//*[@id=\"form-1\"]/div[6]/span[2]/span"));
            afterDateRight.click();

            Thread.sleep(1000);
            //结束时间-右-具体时间
            WebElement afterDateRightTime = driver.findElement(By.cssSelector("body > div:nth-child(6) > div > div.datebox-calendar-inner.panel-noscroll > div > div.calendar-body > table > tbody > tr:nth-child(5) > td:nth-child(4)"));
            afterDateRightTime.click();

            //显示医生
            WebElement drView = driver.findElement(By.id("is_dr_view"));
            drView.click();

            //批次名称
            WebElement batchName = driver.findElement(By.cssSelector("#form-1 > div:nth-child(8) > span > input.textbox-text.validatebox-text.validatebox-invalid.textbox-prompt"));
            batchName.sendKeys("抽取抗菌药物" + getRandomStr(2));

            //保存并抽样
            WebElement batchingClick = driver.findElement(By.cssSelector("#form-1 > div:nth-child(8) > span > input.textbox-text.validatebox-text.validatebox-invalid.textbox-prompt"));
            click(batchingClick);

        } catch (Exception e) {
            e.printStackTrace();
        }


        //int index = elements.size();
        //WebElement w = null;
        //for (int i = 0; i < elements.size(); i++) {
        //    if(elements.get(i).getText() == "只抽抗菌药物" ){
        //        w = driver.findElement(By.cssSelector("#plist>li:first-child" + ">input"));
        //        w.click();
        //    }
        //    String s = elements.get(i).getText();
        //    System.out.println(s);
        //}

        //for (WebElement e:elements) {
        //    if(e.getText().toString() == "只抽抗菌药物"){
        //
        //        WebElement yuan = driver.findElement();
        //    }
        //}
    }

}
