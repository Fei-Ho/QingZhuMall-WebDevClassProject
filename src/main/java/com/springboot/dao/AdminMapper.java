package com.springboot.dao;

import com.springboot.bean.Admin;
import com.springboot.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdminMapper {

    //管理员登录
    Admin login(String adminName, String password);

}
