package com.wj.sell.service;

import com.wj.sell.dataobject.OrderMaster;
import com.wj.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {
    /**创建订单*/
    OrderDTO create(OrderDTO orderDTO);

    /**查询订单*/
    OrderDTO findOne(String orderId);

    /**查询订单列表*/
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /**
     * 查询不同状态的订单列表.
     */
    List<OrderDTO> findListStatus(String buyerOpenid, Integer orderStatus);

    /**卖家端：查询所有人订单列表*/
    Page<OrderDTO> findList(Pageable pageable);

    /**取消订单*/
    OrderDTO cancel(OrderDTO orderDTO);

    /**完结订单*/
    OrderDTO finish(OrderDTO orderDTO);

    /**支付订单*/
    OrderDTO paid(OrderDTO orderDTO);
}
