package com.springboot.service;

import com.alibaba.druid.sql.visitor.functions.If;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.springboot.bean.Inform;
import com.springboot.dao.InformMapper;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformService {
    @Autowired
    private InformMapper informMapper;

    public List<Inform> selectAll(){ return informMapper.selectAll(); }

    public int insert(Inform inform){ return informMapper.insert(inform); }

    public Inform get(Integer id){ return informMapper.selectByPrimaryKey(id); }

    public int update(Inform inform){ return informMapper.updateByPrimaryKey(inform); }

    public int delete(Integer id){ return informMapper.deleteByPrimaryKey(id);}

}
