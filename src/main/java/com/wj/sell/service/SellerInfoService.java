package com.wj.sell.service;

import com.wj.sell.dataobject.SellerInfo;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 卖家账户
 */
public interface SellerInfoService {

    SellerInfo findSellerInfoByPhone(String phone);

    SellerInfo findById(Integer id);

    List<SellerInfo> findAll();

    void login(String phone, String password, HttpServletRequest request);
}
