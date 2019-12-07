package com.springboot.controller;

import com.springboot.bean.Admin;
import com.springboot.service.AdminService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;

    @PostMapping(value = "/user/login")  //对应login.html 中的 action的
    public String login(@RequestParam ("username") String adminname,
                        @RequestParam ("password") String password,
                        Map<String ,Object> map ,
                        HttpSession session , Admin admin) {
//        System.out.println(adminname+"---"+password);
        admin.setUsername(adminname);
        admin.setPassword(password);
        admin = this.adminService.dologin(admin);

        System.out.println(admin);
        if(admin != null){
            session.setAttribute("loginUser",adminname);  //session中存入 username 拦截器可以识别出来
            //登录成功 直接  return  "dashboard";
            //为了防止表单重复提交
            //  main.html 在MyMvcConfig 中视图映射到 dashboard
            return  "redirect:/homepage.html";
        }
        else {
            map.put("msg","账户密码错误");
            return "login";
        }

    }
}
