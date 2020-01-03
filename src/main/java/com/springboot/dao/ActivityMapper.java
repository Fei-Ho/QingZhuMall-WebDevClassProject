package com.springboot.dao;


import com.springboot.bean.Activity;
import com.springboot.bean.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface ActivityMapper {

    Activity selectByActivityId(Integer id);

    ArrayList<Activity> selectByActivityName(String activityName);

    ArrayList<Activity> getAll();

    int insert(Activity activity);

    int deleteById(Integer id);

    int updateById(Activity activity);

    int updateByIdSelective(Activity activity);
}