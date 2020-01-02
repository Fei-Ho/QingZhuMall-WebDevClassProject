package com.springboot.service;

import com.springboot.bean.Admin;
import com.springboot.dao.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public Admin login(String adminName, String password){
        return adminMapper.login(adminName,password);
    }

}
