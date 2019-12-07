package com.springboot.service;

import com.springboot.bean.Feedback;
import com.springboot.dao.FeedbackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackMapper feedbackMapper;

    public List<Feedback> selectAll(){ return feedbackMapper.selectAll(); }

    public int update(Feedback feedback){ return feedbackMapper.updateByPrimaryKey(feedback); }

    public Feedback get(Integer id){ return feedbackMapper.selectByPrimaryKey(id); }

    public Integer read(Feedback feedback){ return feedbackMapper.read(feedback); }

    public Integer delete(Integer id){ return feedbackMapper.deleteByPrimaryKey(id); }
}
