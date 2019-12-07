package com.springboot.dao;

import com.springboot.bean.Inform;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface InformMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Inform record);

    Inform selectByPrimaryKey(Integer id);

    List<Inform> selectAll();

    int updateByPrimaryKey(Inform record);
}