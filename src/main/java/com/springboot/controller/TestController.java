package com.springboot.controller;


import com.springboot.bean.Goods;
import com.springboot.bean.Msg;
import com.springboot.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

@Controller
public class TestController {

    @GetMapping("/test.html")
    public String admin_info(){
        return "test";
    }

}
