package com.wj.sell.controller;

import com.wj.sell.dataobject.SellerInfo;
import com.wj.sell.enums.ResultEnum;
import com.wj.sell.exception.SellException;
import com.wj.sell.service.SellerInfoService;
import com.wj.sell.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/admin")
public class SellerInfoController {

    @Autowired
    SellerInfoService sellerInfoService;

    @GetMapping("/loginAdmin")
    public void loginAdmin(@RequestParam("phone") String phone,
                           @RequestParam("password") String password,
                           HttpServletRequest request) {
        sellerInfoService.login(phone,password,request);

    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                               HttpServletResponse response,
                               Map<String, Object> map) {
//        //1. 从cookie里查询
//        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
//        if (cookie != null) {
//            //2. 清除cookie
//            CookieUtil.set(response, CookieConstant.TOKEN, null, 0);
//        }
        String phone = (String)request.getSession().getAttribute("phone");
        if(phone != null){
            request.getSession().removeAttribute("phone");
        }

        map.put("msg", ResultEnum.LOGOUT_SUCCESS.getMsg());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success", map);
    }

    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map) {
        List<SellerInfo> sellerInfoList = sellerInfoService.findAll();
        map.put("sellerInfoList", sellerInfoList);
        return new ModelAndView("seller/list", map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "sellerId", required = false) Integer sellerId,
                              Map<String, Object> map) {
        SellerInfo sellerInfo = sellerInfoService.findById(sellerId);
        map.put("sellerInfo", sellerInfo);
        return new ModelAndView("seller/index", map);
    }
}
