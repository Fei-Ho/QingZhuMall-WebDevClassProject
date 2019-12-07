package com.springboot.controller;

import com.springboot.bean.Authority;
import com.springboot.bean.Company;
import com.springboot.service.AuthorityService;
import com.springboot.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AuthorityController {
    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private CompanyService companyService;

    @GetMapping("/authorities")
    public String getlist(Model model){
        List<Authority> authorities = authorityService.selectAll();
        model.addAttribute("authorities",authorities);
        return "/authority/authoritylist";
    }

    //跳转增加页面
    @GetMapping("/authority")
    public String toAddPage(Model model){
        return "authority/authorityadd";
    }

    @PostMapping("/authority")
    public String addInfo(Authority authority){

        authorityService.insert(authority);
        return "redirect:/authorities";
    }

    //来到修改页面
    @GetMapping("/authority/{idauthority}")
    public String toUpdatePage(@PathVariable("idauthority") Integer id , Model model){

        Authority authority = authorityService.get(id);
        model.addAttribute("authority",authority);
        return "authority/authorityadd";
    }

    //修改权限信息
    @PutMapping("/authority")
    public String updateInfo(Authority authority){
        authorityService.updatte(authority);
        return "redirect:/authorities";
    }

    //权限信息删除
    @DeleteMapping("/authority/{idauthority}")
    public String deleteInfo(@PathVariable("idauthority") Integer id){
        authorityService.delete(id);
        return "redirect:/authorities";
    }

    @GetMapping("/showcompany/{idauthority}")
    public String toshowPage(@PathVariable("idauthority") Integer id , Model model){
        List<Company> companies = companyService.show(id);
        model.addAttribute("companies",companies);
        return "authority/show";
    }
}
