package com.springboot.service;

import com.springboot.bean.Admin;
import com.springboot.dao.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public Admin login(String adminName, String password){
        return adminMapper.login(adminName,password);
    }

    public Admin selectByAdminId(Integer id){
        return adminMapper.selectByAdminId(id);
    }

    public ArrayList<Admin> selectByAdminName(String adminName){
        return adminMapper.selectByAdminName(adminName);
    }

    public ArrayList<Admin> getAll(){
        return adminMapper.getAll();
    }

    public int insert(Admin admin){
        return adminMapper.insert(admin);
    }

    public int deleteById(Integer id){
        return adminMapper.deleteById(id);
    }

    public int updateById(Admin admin){
        return adminMapper.updateById(admin);
    }

    public int updateByIdSelective(Admin admin){
        return adminMapper.updateByIdSelective(admin);
    }

}
