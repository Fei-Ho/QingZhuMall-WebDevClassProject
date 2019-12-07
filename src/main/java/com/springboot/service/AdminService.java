package com.springboot.service;

import com.springboot.bean.Admin;
import com.springboot.dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminDao adminDao;

    public Admin dologin(Admin admin){
        admin=this.adminDao.login(admin.getUsername() , admin.getPassword());
        return admin;
    }


}
