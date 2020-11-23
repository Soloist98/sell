package com.wj.sell.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(10,"商品不存在"),

    PRODUCT_STOCK_ERROR(11,"库存不正确"),

    ORDER_NOT_EXIST(12,"订单不存在"),

    ORDERDETAIL_NOT_EXIST(13,"订单详情不存在"),

    ORDER_STATUS_ERROR(14,"订单状态不正确"),

    ORDER_UPDATE_FAIL(15,"订单更新失败"),

    ORDER_DETAIL_EMPTY(16,"订单详情为空"),

    PAY_STATUS_ERROR(17,"支付状态不正确"),

    PARAM_ERROR(18,"参数不正确"),

    CART_EMPTY(19,"购物车为空"),

    OPENID_CONSISTENCY_ERROR(20,"openid不一致"),

    ORDER_CANCEL_SUCCESS(22,"订单取消成功"),

    ORDER_FINISH_SUCCESS(23,"订单完结成功"),

    PRODUCT_STATUS_ERROR(24,"商品状态不正确"),

    LOGIN_FAIL(25,"登录失败"),
    LOGOUT_SUCCESS(26,"退出成功"),
    ;

    private Integer code;

    private String msg;
    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
