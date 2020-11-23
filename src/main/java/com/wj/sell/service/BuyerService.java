package com.wj.sell.service;

import com.wj.sell.VO.ResultVO;
import com.wj.sell.dto.OrderDTO;

import java.util.List;

/**
 * 买家
 */
public interface BuyerService {
    //查询一个订单详情
    OrderDTO findOneOrder(String openid, String orderId);

    //根据订单状态查询某个用户的所有订单
    List<OrderDTO> findOrderList(String openid, Integer status);
    //取消订单
    void cancel(String openid, String orderId);
}
