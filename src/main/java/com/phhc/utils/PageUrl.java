package com.phhc.utils;

public class PageUrl {
    //基础路径
    public static final String BASE_URL = "http://192.168.3.152:8056";
    //登录页面路径
    public static final String LOGIN_URL = BASE_URL + "/platform/login/index";
    //专项点评首页
    public static final String SPECIAL_REVIEW_HOME_URL = BASE_URL + "/hospital/specialReview/getSpecialMenu";
    //抽样方案页面
    public static final String SPECIAL_REVIEW_SAMPLING_PLAN_URL = BASE_URL + "/hospital/screen/review/zy/sampleScheme/zySampleList.html?menuid=1&menunm=围术期抗菌药物专项点评&_encode";
    //医嘱抽样页面
    public static final String SPECIAL_REVIEW_ZY_SAMPLING_URL = BASE_URL + "/hospital/screen/review/zy/sample/batchList.html?menuid=1&menunm=围术期抗菌药物专项点评&_encode";
    //医嘱分配页面
    public static final String SPECIAL_REVIEW_ZY_DISTRIBUTION_URL = BASE_URL + "/hospital/screen/review/zy/allot/zyAllot.html?menuid=1&menunm=围术期抗菌药物专项点评&_encode";
    //医嘱点评页面
    public static final String SPECIAL_REVIEW_ZY_COMMENTS_URL = BASE_URL + "/hospital/screen/review/zy/batchlist/batchMange.html?menuid=1&menunm=围术期抗菌药物专项点评&_encode";
    //反馈处理页面
    public static final String SPECIAL_REVIEW_ZY_FEEDBACK_URL = BASE_URL + "/hospital/screen/review/zy/feedback/feedbackbatchlistphar.html?menuid=1&menunm=围术期抗菌药物专项点评&_encode";
    //点评项查看页面
    public static final String SPECIAL_REVIEW_ZY_COMMENTS_ITEM_URL = BASE_URL + "/hospital/screen/review/zy/itemconfig/itemConfig.html?menuid=1&menunm=围术期抗菌药物专项点评&_encode";
    //点评管理页面
    public static final String SPECIAL_REVIEW_ZY_COMMENT_MANANGMENT_URL = BASE_URL + "/hospital/screen/review/zy/zyReviewManage/zyReviewManage.html?menuid=1&menunm=围术期抗菌药物专项点评&_encode";
    //统计类页面
    public static final String SPECIAL_REVIEW_ZY_STATISTICS_URL = BASE_URL + "/hospital/zyReviewStatistic/getMenu?menuid=1&menunm=围术期抗菌药物专项点评&_encode";
    //明细类页面
    public static final String SPECIAL_REVIEW_ZY_DETAILS_URL = BASE_URL + "/hospital/zyReviewDetailStatistic/getMenu?menuid=1&menunm=围术期抗菌药物专项点评&_encode";


}
