package com.phhc.mcase.special_review;

import com.phhc.mcase.BaseCase;
import com.phhc.pageObject.platform.LoginPage;
import com.phhc.pageObject.special_review.SpecialReviewZySamplingPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

/**
 * @author lvwd
 * @data 2022/3/21
 * @apiNote
 */

@Feature("新增批次测试用例")
public class SpecialReviewZySamplingCase extends BaseCase {

    @Story("点击新增按钮，弹出新增窗口")
    @Test
    public void testNewButton(){

        try {
            LoginPage loginPage = new LoginPage(webDriver);
            loginPage.login("Lyaoshi01","123123");
            SpecialReviewZySamplingPage specialReviewZySamplingPage = new SpecialReviewZySamplingPage(webDriver);
            specialReviewZySamplingPage.newBatch();
            Thread.sleep(2000);
            specialReviewZySamplingPage.toIframe();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
