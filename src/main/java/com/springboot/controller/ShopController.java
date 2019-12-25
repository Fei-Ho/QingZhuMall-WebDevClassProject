package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopController {

    //商城前端页面跳转
    @GetMapping("/")
    public String homepage(){
        return "/shop/index";
    }

    @GetMapping("/index")
    public String index(){
        return "/shop/index";
    }

    @GetMapping("/allproducts")
    public String allproducts(){
        return "/shop/allproducts";
    }

    @GetMapping("/blog")
    public String blogs(){
        return "/shop/blog";
    }

    @GetMapping("/article")
    public String article(){
        return "/shop/article";
    }

    @GetMapping("/land")
    public String land(){
        return "/shop/land";
    }

    @GetMapping("/registe")
    public String registe(){
        return "/shop/registe";
    }

    @GetMapping("/cart")
    public String cart(){
        return "/shop/personal_cart";
    }

    @GetMapping("/order")
    public String order(){
        return "/shop/order";
    }

    @GetMapping("/ok")
    public String ok(){
        return "/shop/ok";
    }

}