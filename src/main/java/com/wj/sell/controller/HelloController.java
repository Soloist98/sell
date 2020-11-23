package com.wj.sell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "redirect:/seller/order/list";
    }
//    @GetMapping("/")
//    public ModelAndView m(){
//        return new ModelAndView("common/loginView");
//    }
}
