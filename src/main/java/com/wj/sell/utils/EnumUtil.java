package com.wj.sell.utils;

import com.wj.sell.enums.CodeEnum;

public class EnumUtil {
    public static <T extends CodeEnum> T getbyCode(Integer code, Class<T> enumClass){
        for(T t : enumClass.getEnumConstants()){
            if(code.equals(t.getCode())){
                return  t;
            }
        }
        return null;
    }
}
