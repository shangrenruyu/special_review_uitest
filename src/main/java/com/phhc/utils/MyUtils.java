package com.phhc.utils;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class MyUtils {

    //写一些静态的方法，通过类名可以直接进行调用。
    public static List<String> getData(String path) {
        try {
            CsvReader csvReader = new CsvReader(path);
            //将读取到的内容添加到容器集合中
            List<String> list = new ArrayList<>();
            while (csvReader.readRecord()) {
                //将每一行内容依次添加到集合中
                list.add(csvReader.getRawRecord());
            }
            csvReader.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //设置数据
    public static void setData(String path, List<String[]> list) {
        try {
            CsvWriter csvWriter = new CsvWriter(path);
            //将集合中的数据循环遍历
            for (String[] s : list) {
                csvWriter.writeRecord(s);
            }
            //关闭流
            csvWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //公共操作方法，继续追加函数
    public static boolean isEmpty(String s) {
        if (s == null || s.equals("") || s.trim().equals("")) {
            return true;
        }
        return false;
    }

    /**
     * 获取随机字符串，由数字、大小写字母组成
     * @param bytes：生成的字符串的位数
     * @return
     * @author
     */
    public static String getRandomStr(int bytes){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < bytes; i++) {
            //随机判断判断该字符是数字还是字母
            String choice = random.nextInt(2) % 2 == 0 ? "char" : "num";
            if ("char".equalsIgnoreCase(choice)) {
                //随机判断是大写字母还是小写字母
                int start = random.nextInt(2) % 2 == 0 ? 65 : 97;
                sb.append((char) (start + random.nextInt(26)));
            } else if ("num".equalsIgnoreCase(choice)) {
                sb.append(random.nextInt(10));
            }
        }
        return sb.toString();
    }

    //添加Cookie，跳过登录认证
    public static void addCookies(WebDriver webDriver){

        Cookie c1 = new Cookie("JSESSIONID", "a69183fe0f509c5e1aeda8b291f3");
        Cookie c2 = new Cookie("PHHC_THEME", "default");
        Cookie c3 = new Cookie("PHHC_TICKET_COOKIE_NAME050301", "3c70113839b0b17bd11edd6219f186cba5a7be88ce21c9fcdef30c5c8a5c8312e5684c2414b9ef6e");

        webDriver.manage().addCookie(c1);
        webDriver.manage().addCookie(c2);
        webDriver.manage().addCookie(c3);

        webDriver.navigate().refresh();

        System.out.println(webDriver.manage().getCookies());
    }
}
