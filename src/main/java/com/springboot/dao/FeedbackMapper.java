package com.springboot.dao;


import com.springboot.bean.Feedback;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FeedbackMapper {
    int deleteByPrimaryKey(Integer idfeedback);

    int insert(Feedback record);

    Feedback selectByPrimaryKey(Integer idfeedback);

    List<Feedback> selectAll();

    int updateByPrimaryKey(Feedback record);

    int read(Feedback feedback);
}