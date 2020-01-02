package com.springboot.controller;

import com.springboot.bean.Msg;
import com.springboot.bean.User;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShopController {

    @Autowired
    private UserService userService;

    //用户登录
    @PostMapping("/login")
    @ResponseBody
    public Msg login(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        User user  = userService.login(userName,password);
        if(user!=null){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

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