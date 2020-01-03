package com.springboot.controller;


import com.springboot.bean.Activity;
import com.springboot.bean.Admin;
import com.springboot.bean.Msg;
import com.springboot.bean.User;
import com.springboot.service.ActivityService;
import com.springboot.service.AdminService;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class AdminManagerController {

    @Autowired
    private AdminService adminService;

    //获取所有管理员
    @CrossOrigin(origins={"*"}, methods={RequestMethod.GET, RequestMethod.POST})
    @GetMapping("/admin/getalladmins")
    @ResponseBody
    public Msg getAllAdmins() {
        List<Admin> adminsList = adminService.getAll();
        return Msg.success().add("admins",adminsList);
    }

    //添加管理员
    @CrossOrigin(origins={"*"}, methods={RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/admin/addadmin")
    @ResponseBody
    public Msg addAdmin(@RequestBody Admin admin){
        if(adminService.insert(admin)!=0){
            List<Admin> adminsList = adminService.getAll();
            return Msg.success().add("admins",adminsList);
        }else{
            return Msg.fail();
        }
    }

    //删除管理员
    @CrossOrigin(origins={"*"}, methods={RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/admin/deleteadmin")
    @ResponseBody
    public Msg deleteAdmin(@RequestBody Admin admin){
        if(adminService.deleteById(admin.getId())!=0){
            List<Admin> adminsList = adminService.getAll();
            return Msg.success().add("admins",adminsList);
        }else{
            return Msg.fail();
        }
    }

    //修改管理员
    @CrossOrigin(origins={"*"}, methods={RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/admin/updateadmin")
    @ResponseBody
    public Msg updateAdmin(@RequestBody Admin admin){
        if(adminService.updateByIdSelective(admin)!=0){
            List<Admin> adminsList = adminService.getAll();
            return Msg.success().add("admins",adminsList);
        }else{
            return Msg.fail();
        }
    }

    //查找管理员
    @CrossOrigin(origins={"*"}, methods={RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/admin/searchadmin")
    @ResponseBody
    public Msg searchAdmin(@RequestParam("adminName") String adminName){
        List<Admin> adminsList = adminService.selectByAdminName(adminName);
        return Msg.success().add("admins",adminsList);
    }


}