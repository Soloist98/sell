package com.wj.sell.service.impl;

import com.wj.sell.dataobject.SellerInfo;
import com.wj.sell.enums.ResultEnum;
import com.wj.sell.exception.SellException;
import com.wj.sell.repository.SellerInfoRepository;
import com.wj.sell.service.SellerInfoService;
import com.wj.sell.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@Service
public class SellerInfoServiceImpl implements SellerInfoService {

    @Autowired
    private SellerInfoRepository repository;
    @Override
    public SellerInfo findSellerInfoByPhone(String phone) {
        return repository.findByPhone(phone);
    }

    @Override
    public SellerInfo findById(Integer id) {
        SellerInfo result = repository.findBySellerId(id);
        return result;
    }

    @Override
    public List<SellerInfo> findAll() {
        return repository.findAll();
    }

    @Override
    public void login(String phone, String password, HttpServletRequest request) {
        SellerInfo sellerInfo = repository.findByPhone(phone);
        if(sellerInfo != null && sellerInfo.getPassword().equals(password)){

            /**
             * 生成TOKEN
             * 目前业务场景不需要 只需要Cookie
             * 后续场景实现
             */
            String token = UUID.randomUUID().toString();
//            log.info("登录成功的token={}", token);
//            Integer expire = RedisConstant.EXPIRE;

            //Token设置到Cookie
            request.getSession().setAttribute("phone",phone);
//            CookieUtil.set(response, CookieUtil.name, token, CookieUtil.maxAge);
//            return "登陆成功";
        }else {
            throw new SellException(ResultEnum.LOGIN_FAIL);
        }
    }
}
