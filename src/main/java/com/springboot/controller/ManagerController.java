package com.springboot.controller;

import com.springboot.bean.Admin;
import com.springboot.bean.Msg;
import com.springboot.bean.User;
import com.springboot.service.AdminService;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ManagerController {

    @Autowired
    private AdminService adminService;

    //管理员登录
    @PostMapping("/admin/login")
    public String login(String adminName,String password, HttpServletResponse response) {
        Admin admin = adminService.login(adminName,password);
        if(admin!=null){
            response.addHeader("Set-Cookie","adminName:"+admin.getAdminName()+";id:"+admin.getId());
            return "/manager/index";
        }else{
            return "/manager/login";
        }
    }

    // 以下是实现后台管理系统页面的跳转
    @GetMapping("/admin")
    public String home(){
        return "/manager/index";
    }

    @GetMapping("/home")
    public String goHome(){
        return "/manager/home";
    }

    @GetMapping("/login")
    public String goLogin(){
        return "/manager/login";
    }

    @GetMapping("/Category_Manage")
    public String Category_Manage(){
        return "/manager/Category_Manage";
    }

    @GetMapping("/Add_Brand")
    public String Add_Brand(){
        return "/manager/Add_Brand";
    }

    @GetMapping("/picture-add")
    public String picture_add(){
        return "/manager/picture-add";
    }

    @GetMapping("/Add_Brand-add")
    public String Add_Brand_add(){
        return "/manager/Add_Brand-add";
    }

    @GetMapping("/transaction")
    public String transaction(){
        return "/manager/transaction";
    }

    @GetMapping("/order_detailed")
    public String order_detailed(){
        return "/manager/order_detailed";
    }

    @GetMapping("/Brand_Manage")
    public String Brand_Manage(){
        return "/manager/Brand_Manage";
    }

    @GetMapping("/Orderform")
    public String Orderform(){
        return "/manager/Orderform";
    }

    @GetMapping("/Refund")
    public String Refund(){
        return "/manager/Refund";
    }

    @GetMapping("/Order_handling")
    public String Order_handling(){
        return "/manager/Order_handling";
    }

    @GetMapping("/Products_List")
    public String goPro(){
        return "/manager/Products_List";
    }

    @GetMapping("/payment_method")
    public String payment_method(){
        return "/manager/payment_method";
    }

    @GetMapping("/product-category-add")
    public String product_category_add(){
        return "/manager/product-category-add";
    }

    @GetMapping("/user_list")
    public String user_list(){
        return "/manager/user_list";
    }

    @GetMapping("/Shop_list")
    public String Shop_list(){
        return "/manager/Shop_list";
    }

    @GetMapping("/member-Grading")
    public String member_Grading(){
        return "/manager/member-Grading";
    }

    @GetMapping("/System_Logs")
    public String System_Logs(){
        return "/manager/System_Logs";
    }

    @GetMapping("/Systems")
    public String Systems(){
        return "/manager/Systems";
    }

    @GetMapping("/admin_Competence")
    public String admin_Competence(){
        return "/manager/admin_Competence";
    }

    @GetMapping("/administrator")
    public String administrator(){
        return "/manager/administrator";
    }

    @GetMapping("/admin_info")
    public String admin_info(){
        return "/manager/admin_info";
    }
}