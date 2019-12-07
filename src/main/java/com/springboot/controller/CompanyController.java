package com.springboot.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.bean.Company;
import com.springboot.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.ws.WebEndpoint;
import java.util.List;

@Controller
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("infos")
    public ModelAndView getinfos(
            @RequestParam(required = false, defaultValue = "1" ,value = "pn")Integer pn, Model model){
        PageHelper.startPage(pn,9);
        List<Company> companies = companyService.selectAll();
        PageInfo<Company> pageInfo = new PageInfo(companies ,9);
        return new ModelAndView("/company/list","infos",pageInfo);

    }

    //跳转添加页面
    @GetMapping("/info")
    public String toAddPage(Model model){
        return "company/add";
    }

    @PostMapping("/info")
    public String addInfo(Company company){

        companyService.insert(company);
        return "redirect:/infos";
    }

    //来到修改页面
    @GetMapping("/info/{id}")
    public String toUpdatePage(@PathVariable("id") Integer id , Model model){

        Company company = companyService.getone(id);
        model.addAttribute("info",company);
        return "company/add";
    }

    //修改企业信息
    @PutMapping("/info")
    public String updateInfo(Company company){
        companyService.update(company);
        return "redirect:/infos";
    }

    //企业信息删除
    @DeleteMapping("/info/{id}")
    public String deleteInfo(@PathVariable("id") Integer id){
        companyService.delete(id);
        return "redirect:/infos";
    }


}
