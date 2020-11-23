package com.wj.sell.repository;

import com.wj.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.rmi.runtime.NewThreadAction;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123457");
        orderMaster.setBuyerName("wj");
        orderMaster.setBuyerPhone("15650112708");
        orderMaster.setBuyerAddress("sdu");
        orderMaster.setBuyerOpenid("110");
        orderMaster.setOrderAmount(new BigDecimal("533.3"));

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotEquals(null, result);
    }

    @Test
    public void findByBuyerOpenid(){
        PageRequest pageRequest = PageRequest.of(0,2);
        Page<OrderMaster> result = repository.findByBuyerOpenid("110", pageRequest);
        System.out.println(result);
    }


}