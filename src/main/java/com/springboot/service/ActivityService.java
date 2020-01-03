package com.springboot.service;

import com.springboot.bean.Activity;
import com.springboot.bean.Order;
import com.springboot.dao.ActivityMapper;
import com.springboot.dao.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    public Activity selectByActivityId(Integer id){
        return activityMapper.selectByActivityId(id);
    }

    public ArrayList<Activity> selectByActivityName(String activityName){
        return activityMapper.selectByActivityName(activityName);
    }

    public ArrayList<Activity> getAll(){
        return activityMapper.getAll();
    }

    public int insert(Activity activity){
        return activityMapper.insert(activity);
    }

    public int deleteById(Integer id){
        return activityMapper.deleteById(id);
    }

    public int updateById(Activity activity){
        return activityMapper.updateById(activity);
    }

    public int updateByIdSelective(Activity activity){
        return activityMapper.updateByIdSelective(activity);
    }

}
