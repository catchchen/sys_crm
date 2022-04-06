package com.company.utils;

import java.util.Date;

/**
 * @author chenk
 * @date 2021/10/26 10:28
 * @description
 */
public class IdGenerator {

    public static String getId(){
        // 时间戳
        Date date = new Date();
        // String timeId = date.getTime();
//        Random random =  new Random();
//        int r = random.nextInt(999);
        // 返回时间戳
        int r = (int)(Math.random()*(999-100+1))+100;// 防止同时访问id相同 加上一个随机的数
        // 时间戳 加 三位随机的数生成唯一id
        return date.getTime() + ""+ r;
    }
    public static void main(String[] args) {
        System.out.println(getId());
    }
}

