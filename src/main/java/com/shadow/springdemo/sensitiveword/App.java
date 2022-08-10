package com.shadow.springdemo.sensitiveword;

import java.util.Map;

/**
 * @author Huajq
 * @Description
 * @since 2022-08-05 11:50
 */
public class App {
    public static void main(String[] args) {
        String[] sensitiveWords = new String[]{"test1","test2","dashd"};

        BanWordUtil banWordUtil = new BanWordUtil();
        banWordUtil.initKeyWord(sensitiveWords);

        boolean test1 = banWordUtil.isContaintSensitiveWord("test1", 1);
        System.out.println(test1);

    }
}
