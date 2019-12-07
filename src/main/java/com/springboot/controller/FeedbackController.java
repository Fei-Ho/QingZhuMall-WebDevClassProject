package com.springboot.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.bean.Company;
import com.springboot.bean.Feedback;
import com.springboot.service.FeedbackService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/backs")
    public ModelAndView getinfos(
            @RequestParam(required = false, defaultValue = "1" ,value = "pn")Integer pn, Model model){
        PageHelper.startPage(pn,9);
        List<Feedback> feedbacks = feedbackService.selectAll();
        PageInfo<Feedback> pageInfo = new PageInfo(feedbacks ,9);
        return new ModelAndView("/feedback/backlist","backs",pageInfo);

    }


    @GetMapping("/back/{idfeedback}")
    public String toDetailPage(@PathVariable("idfeedback")Integer id, Model model){
             Feedback feedback = feedbackService.get(id);
             model.addAttribute("feedback",feedback);
             System.out.println(model);
                return "/feedback/detail";
    }

    @PutMapping("/back")
    public String read(Feedback feedback,
                       @RequestParam(required = false, defaultValue = "1" ,value = "pn")Integer pn, Model model){
        feedbackService.read(feedback);
        PageHelper.startPage(pn,3);
        List<Feedback> feedbacks = feedbackService.selectAll();
        PageInfo<Feedback> pageInfo = new PageInfo(feedbacks ,2);
        model.addAttribute("backs",pageInfo);
        return "/feedback/backlist";
    }

    @DeleteMapping("/back/{idfeedback}")
    public String delete(@PathVariable("idfeedback")Integer id ){
        feedbackService.delete(id);
        return "redirect:/backs";
    }
}
