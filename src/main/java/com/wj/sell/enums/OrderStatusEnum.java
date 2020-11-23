package com.wj.sell.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * 订单状态
 */
@Getter
public enum OrderStatusEnum implements CodeEnum{
    NEW(0, "新订单未支付"),
    NEW_PAYED(1, "新订单已支付"),
    FINISHED(2, "完结"),
    CANCEL(3, "已取消");

    private Integer code;
    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
