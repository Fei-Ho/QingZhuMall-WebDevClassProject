package com.springboot.dao;

import com.springboot.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface UserMapper {

    //用户登录
    User login(String userName, String password);

    //根据userId查找
    User selectByUserId(Integer id);

    //根据userName查找用户
    ArrayList<User> selectByUserName(String userName);

    //获得所有用户
    ArrayList<User> getAll();

    //插入用户
    int insert(User user);

    //根据userId删除用户
    int deleteById(Integer id);

    //根据userId更新用户信息
    int updateById(User user);

    //根据userId，选择地更新用户信息
    int updateByIdSelective(User user);
}
