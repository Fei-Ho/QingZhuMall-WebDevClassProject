package com.springboot.service;

import com.springboot.bean.User;
import com.springboot.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    //用户登录
    public User login(String userName,String password) {
        return userMapper.login(userName, password);
    }

    //根据用户名查询用户
    public User selectByUserName(String userName) {
        return userMapper.selectByUserName(userName);
    }

    //根据userId查找
    public User selectByUserId(Integer id) {
        return userMapper.selectByUserId(id);
    }

    //获得所有用户
    public ArrayList<User> getAll(){
        return userMapper.getAll();
    }

    //插入用户
    public int insert(User user) {
        return userMapper.insert(user);
    }

    //根据userId删除用户
    public int deleteById(Integer id) {
        return userMapper.deleteById(id);
    }

    //根据userId更新用户
    public int updateById(User user) {
        return userMapper.updateById(user);
    }

    //根据userId选择地更新
    public int updateByIdSelective(User user) {
        return userMapper.updateByIdSelective(user);
    }

}
