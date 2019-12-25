package com.springboot.controller;

import com.springboot.bean.Msg;
import com.springboot.bean.User;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("login")
    @ResponseBody
    public Msg login(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        User user = userService.selectByUserName(userName);
        if(user.getPassword().equals(password)){
            return Msg.success().add("user",user);
        }else {
            return Msg.fail();
        }
    }



    // for  test
    @GetMapping("test")
    public String test() {
        return "/test.html";
    }

    @PostMapping("getuser")
    @ResponseBody
    public User getUser(@RequestParam("id") Integer id) {
        User user = userService.selectByUserId(id);
        return user;
    }
    // above is for test

}
