package com.wj.sell.utils;

import java.util.Random;

public class KeyUtil {
    /**
     * 生成唯一主键
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;//保证6位数
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
