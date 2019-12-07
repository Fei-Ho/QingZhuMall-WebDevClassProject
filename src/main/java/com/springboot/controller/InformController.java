package com.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.bean.Company;
import com.springboot.bean.Inform;
import com.springboot.service.InformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class InformController {
    @Autowired
    private InformService informService;

    @GetMapping("/informs")
    public ModelAndView getinfos(
            @RequestParam(required = false, defaultValue = "1" ,value = "pn")Integer pn, Model model){
        PageHelper.startPage(pn,9);
        List<Inform> informs = informService.selectAll();
        PageInfo<Company> pageInfo = new PageInfo(informs ,9);
        return new ModelAndView("/inform/informlist","informs",pageInfo);
    }

    //跳转会议室添加页面
    @GetMapping("/inform")
    public String toAddPage(Model model){
        return "inform/informadd";
    }

    @PostMapping("/inform")
    public String addInfo(Inform inform){
        informService.insert(inform);
        return "redirect:/informs";
    }

    //来到修改页面
    @GetMapping("/inform/{id}")
    public String toUpdatePage(@PathVariable("id") Integer id , Model model){
        Inform inform = informService.get(id);
        model.addAttribute("inform",inform);
        return "inform/informadd";
    }

    //修改会议室信息
    @PutMapping("/inform")
    public String updateInfo(Inform inform){
        informService.update(inform);
        return "redirect:/inform595s";
    }

    //会议室删除
    @DeleteMapping("/inform/{id}")
    public String deleteInfo(@PathVariable("id") Integer id){
        informService.delete(id);
        return "redirect:/informs";
    }


}
