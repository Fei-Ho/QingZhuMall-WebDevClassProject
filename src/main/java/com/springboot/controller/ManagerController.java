package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ManagerController {

    @GetMapping("/admin/login")
    public String login(){
        return "/manager/login";
    }

    @GetMapping("/admin")
    public String home(){
        return "/manager/index";
    }

}
