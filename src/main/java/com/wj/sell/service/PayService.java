package com.wj.sell.service;

import com.wj.sell.dto.OrderDTO;

/**
 * 支付
 */
public interface PayService {
    OrderDTO goPay(OrderDTO orderDTO);
}
