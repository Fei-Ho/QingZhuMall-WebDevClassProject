package com.springboot.dao;

import com.springboot.bean.Activity;
import com.springboot.bean.Admin;
import com.springboot.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface AdminMapper {

    //管理员登录
    Admin login(String adminName, String password);

    Admin selectByAdminId(Integer id);

    ArrayList<Admin> selectByAdminName(String adminName);

    ArrayList<Admin> getAll();

    int insert(Admin admin);

    int deleteById(Integer id);

    int updateById(Admin admin);

    int updateByIdSelective(Admin admin);

}
