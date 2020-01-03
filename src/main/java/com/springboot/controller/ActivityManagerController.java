package com.springboot.controller;


import com.springboot.bean.Activity;
import com.springboot.bean.Msg;
import com.springboot.bean.Order;
import com.springboot.dao.ActivityMapper;
import com.springboot.service.ActivityService;
import com.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class ActivityManagerController {

    @Autowired
    ActivityService activityService;

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
        if(activityService.insert(activity)!=0){
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
        if(activityService.updateByIdSelective(activity)!=0){
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

}