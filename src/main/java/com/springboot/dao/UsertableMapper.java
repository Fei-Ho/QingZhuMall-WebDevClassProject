package com.springboot.dao;

import com.springboot.bean.Company;
import com.springboot.bean.Usertable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UsertableMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Usertable record);

    Usertable selectByPrimaryKey(Integer id);

    List<Usertable> selectAll();

    int updateByPrimaryKey(Usertable record);

    List<Usertable> listUsersByName(@Param("cname") String name);

    Integer onlineNum(@Param("cpn") String name);



}