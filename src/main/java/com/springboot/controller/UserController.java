package com.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.bean.Company;
import com.springboot.bean.Usertable;
import com.springboot.service.CompanyService;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;

    @GetMapping("/users")
    public ModelAndView getinfos(
            @RequestParam(required = false, defaultValue = "1" ,value = "pn")Integer pn, Model model){
        PageHelper.startPage(pn,9);
        List<Company> companies = companyService.selectAll();
        Company company = companies.get(0);
        Integer num = userService.getcount(company.getCompanyname());
        model.addAttribute("num",num);
        PageInfo<Company> pageInfo = new PageInfo(companies ,9);
        return new ModelAndView("/users/companylist","companies",pageInfo);
    }

    @GetMapping("/users/{companyname}")
    public String getAllUsers(@PathVariable("companyname") String name, Model model){
                System.out.println(name);
                List<Usertable> users = userService.getUsersbyName(name);
                model.addAttribute("users",users);
                return "/users/listbyname";
    }

    //编辑页面
    @GetMapping("/user/{id}")
    public String toeditPage(@PathVariable("id")Integer id, Model model){
//        System.out.println(id);
        Usertable user = userService.getUser(id);
//        System.out.println(user);
        model.addAttribute("user",user);
        return "users/useredit";
    }

    //编辑实现
    @PutMapping("/users/{name}")
    public String update(@PathVariable("name")String name, Usertable usertable,Model model){
        userService.update(usertable);
        List<Usertable> users = userService.getUsersbyName(name);
        model.addAttribute("users",users);
        return "/users/listbyname";
    }

    //删除操作
    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable("id")Integer id, Model model){

//       System.out.println(id+"delete...");
         Usertable user = userService.getUser(id);
//       System.out.println(user.getCompanyname());
         userService.delete(id);
         List<Usertable> users = userService.getUsersbyName(user.getCompanyname());
//       System.out.println(users+"...");
         model.addAttribute("users",users);
         return "/users/listbyname";
    }

//    //管理员增加页面
//    @GetMapping("/user")
//    public String toaddPage(){
//        return "users/useradd";
//    }

//    //管理员增加操作
//    @PostMapping("/user/{name}")
//    public String insertUser(@PathVariable("name")String name, Model model, Usertable user){
//        userService.insert(user);
//        List<Usertable> users = userService.getUsersbyName(name);
//        model.addAttribute("users",users);
//        return "/users/listbyname";
//    }


}
