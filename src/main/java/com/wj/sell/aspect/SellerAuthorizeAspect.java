package com.wj.sell.aspect;


import com.wj.sell.exception.SellerAuthorizeException;
import com.wj.sell.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {

// && !execution(public * com.wj.sell.controller.SellerInfoController.*(..))
    @Pointcut("execution(public * com.wj.sell.controller.Sell*.*(..))" +
            "&& !execution(public * com.wj.sell.controller.SellerInfoController.*(..))")
    public void verify() {
    }

    @Before("verify()")
    public void doVerify() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String phone = (String)request.getSession().getAttribute("phone");
        //查询cookie
//        Cookie cookie = CookieUtil.get(request, CookieUtil.name);
        if (StringUtils.isEmpty(phone)) {
            log.warn("【登录校验】找不到session");
            throw new SellerAuthorizeException();
        }

//        //查询cookie
//        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
//        if (cookie == null) {
//            log.warn("【登录校验】Cookie中查不到token");
//            throw new SellerAuthorizeException();
//        }
//
//        //去redis里查询
//        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
//        if (StringUtils.isEmpty(tokenValue)) {
//            log.warn("【登录校验】Redis中查不到token");
//            throw new SellerAuthorizeException();
//        }
    }
}
