package com.springboot.controller;


import com.springboot.bean.Admin;
import com.springboot.bean.Msg;
import com.springboot.bean.User;
import com.springboot.service.UserService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MemberManagerController {

    @Autowired
    private UserService userService;

    //获取所有用户
    @CrossOrigin(origins={"*"}, methods={RequestMethod.GET, RequestMethod.POST})
    @GetMapping("/admin/getallusers")
    @ResponseBody
    public Msg getAllUsers() {
        List<User> userList = userService.getAll();
        DateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(int i=0;i<userList.size();i++){
            userList.get(i).setStr_create_time(sdf.format(userList.get(i).getCreatetime()));
        }
        return Msg.success().add("users",userList);
    }

    //添加用户
    @CrossOrigin(origins={"*"}, methods={RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/admin/adduser")
    @ResponseBody
    public Msg addUser(@RequestBody User user){
        if(userService.insert(user)!=0){
            List<User> userList = userService.getAll();
            return Msg.success().add("users",userList);
        }else{
            return Msg.fail();
        }
    }

    //删除用户
    @CrossOrigin(origins={"*"}, methods={RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/admin/deleteuser")
    @ResponseBody
    public Msg deleteUser(@RequestBody User user){
        if(userService.deleteById(user.getId())!=0){
            List<User> userList = userService.getAll();
            return Msg.success().add("users",userList);
        }else{
            return Msg.fail();
        }
    }

    //修改用户
    @CrossOrigin(origins={"*"}, methods={RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/admin/updateuser")
    @ResponseBody
    public Msg updateUser(User user){
        System.out.println(user.getId());
        System.out.println(user.getAddress2());
        if(userService.updateByIdSelective(user)!=0){
            List<User> userList = userService.getAll();
            return Msg.success().add("users",userList);
        }else{
            return Msg.fail();
        }
    }

    //查找用户
    @CrossOrigin(origins={"*"}, methods={RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/admin/searchuser")
    @ResponseBody
    public Msg searchUser(@RequestParam("username") String username){
        List<User> userList = userService.selectByUserName(username);
        DateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (User user:userList) {
            user.setStr_create_time(sdf.format(user.getCreatetime()));
        }
        return Msg.success().add("users",userList);
    }

    //查找用户ById
    @CrossOrigin(origins={"*"}, methods={RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/admin/getuserbyid")
    @ResponseBody
    public Msg searchUserById(@RequestParam("userId") Integer userId){
        User user = userService.selectByUserId(userId);
        DateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setStr_create_time(sdf.format(user.getCreatetime()));
        return Msg.success().add("user",user);
    }
}
