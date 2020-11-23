package com.wj.sell.service.impl;

import com.wj.sell.dto.OrderDTO;
import com.wj.sell.enums.ResultEnum;
import com.wj.sell.exception.SellException;
import com.wj.sell.service.BuyerService;
import com.wj.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOneOrder(String openid, String orderId) {
        String errorMsg = "【查询订单详情】";
        checkParamsIsEmpty(openid, orderId, errorMsg);
        return checkOpenidConsistencyAndReturnOrderDTO(openid, orderId, errorMsg);
    }

    @Override
    public List<OrderDTO> findOrderList(String openid, Integer status) {
        List<OrderDTO> list = new ArrayList<>();
        list.clear();

        List<OrderDTO> listStats = orderService.findListStatus(openid, status);
        listStats.forEach((orderDTO) -> {
            String orderId = orderDTO.getOrderId();
            OrderDTO one = orderService.findOne(orderId);
            list.add(one);
        });
        return list;
    }

    @Override
    public void cancel(String openid, String orderId) {
        String errorMsg = "【取消订单】";
        checkParamsIsEmpty(openid, orderId, errorMsg);
        OrderDTO orderDTO = checkOpenidConsistencyAndReturnOrderDTO(openid, orderId, errorMsg);

        orderService.cancel(orderDTO);
    }

    /**
     * 检查参数是否为空
     */
    private void checkParamsIsEmpty(String openid, String orderId, String errorMsg){
        if(StringUtils.isEmpty(openid) || StringUtils.isEmpty(orderId)){
            log.error(errorMsg+"参数为空，openid={},orderId={}", openid, orderId);
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
    }
    /**
     *判断openid是否一致并返回订单详情
     */
    private OrderDTO checkOpenidConsistencyAndReturnOrderDTO(String openid, String orderId, String errorMsg){
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)){
            log.error(errorMsg+"订单openId不一致，expect={}，actual={}",orderDTO.getOrderId(), orderId);
            throw new SellException(ResultEnum.OPENID_CONSISTENCY_ERROR);
        }
        return orderDTO;
    }
}
