package com.springboot.controller;


import com.springboot.bean.Activity;
import com.springboot.bean.Goods;
import com.springboot.bean.Msg;
import com.springboot.bean.Order;
import com.springboot.dao.ActivityMapper;
import com.springboot.service.ActivityService;
import com.springboot.service.GoodsService;
import com.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class ActivityManagerController {

    @Autowired
    ActivityService activityService;

    @Autowired
    GoodsService goodsService;

    //获取所有活动
    @CrossOrigin(origins={"*"}, methods={RequestMethod.GET, RequestMethod.POST})
    @GetMapping("/admin/getallactivities")
    @ResponseBody
    public Msg getAllActivities() {
        List<Activity> activitiesList = activityService.getAll();
        DateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(int i=0;i<activitiesList.size();i++){
            activitiesList.get(i).setStr_startTime(sdf.format(activitiesList.get(i).getStartTime()));
            activitiesList.get(i).setStr_endTime((sdf.format(activitiesList.get(i).getEndTime())));
        }
        return Msg.success().add("activities", activitiesList);
    }

    //增加活动
    @CrossOrigin(origins={"*"}, methods={RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/admin/addactivity")
    @ResponseBody
    public Msg addActivity(@RequestBody Activity activity){
        DateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            activity.setStartTime(sdf.parse(activity.getStr_startTime()));
            activity.setEndTime(sdf.parse(activity.getStr_endTime()));
            if(activityService.insert(activity)!=0){
                return Msg.success();
            }else{
                return Msg.fail();
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return Msg.fail();
        }
    }

    //删除活动
    @CrossOrigin(origins={"*"}, methods={RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/admin/deleteactivity")
    @ResponseBody
    public Msg addActivity(@RequestParam("id") Integer activityId){
        if(activityService.deleteById(activityId)!=0){
            List<Activity> activitiesList = activityService.getAll();
            DateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for(int i=0;i<activitiesList.size();i++){
                activitiesList.get(i).setStr_startTime(sdf.format(activitiesList.get(i).getStartTime()));
                activitiesList.get(i).setStr_endTime((sdf.format(activitiesList.get(i).getEndTime())));
            }
            return Msg.success().add("activities", activitiesList);
        }else{
            return Msg.fail();
        }
    }

    //修改活动
    @CrossOrigin(origins={"*"}, methods={RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/admin/updateactivity")
    @ResponseBody
    public Msg updateActivity(@RequestBody Activity activity){
        DateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            activity.setStartTime(sdf.parse(activity.getStr_startTime()));
            activity.setEndTime(sdf.parse(activity.getStr_endTime()));
            if(activityService.updateByIdSelective(activity)!=0){
                return Msg.success();
            }else{
                return Msg.fail();
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return Msg.fail();
        }

    }

    //查找活动
    @CrossOrigin(origins={"*"}, methods={RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/admin/searchactivity")
    @ResponseBody
    public Msg searchActivity(@RequestParam("activityName") String activityName){
        List<Activity> activitiesList = activityService.selectByActivityName(activityName);
        DateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(int i=0;i<activitiesList.size();i++){
            activitiesList.get(i).setStr_startTime(sdf.format(activitiesList.get(i).getStartTime()));
            activitiesList.get(i).setStr_endTime((sdf.format(activitiesList.get(i).getEndTime())));
        }
        return Msg.success().add("activities",activitiesList);
    }

    //根据activityId获取所有商品
    @CrossOrigin(origins={"*"}, methods={RequestMethod.GET, RequestMethod.POST})
    @GetMapping("/admin/goodsofactivity")
    @ResponseBody
    public Msg goodsOfActivity(@RequestParam("activityId") Integer activityId){
        List<Goods> goodsList = goodsService.selectByActivityId(activityId);
        DateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Goods good: goodsList) {
            good.setStr_createTime(sdf.format(good.getCreateTime()));
        }
        return Msg.success().add("goods",goodsList);
    }

}