package com.springboot.service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.springboot.bean.Company;
import com.springboot.bean.Usertable;
import com.springboot.dao.CompanyMapper;
import com.springboot.dao.UsertableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UsertableMapper usertableMapper;

    @Autowired
    private CompanyMapper companyMapper;

    public List<Company> selectAll(){ return companyMapper.selectAll(); }

    public Company getone(Integer id){ return companyMapper.selectByPrimaryKey(id); }

    public List<Usertable> getUsersbyName(String name){ return usertableMapper.listUsersByName(name); }

    public Usertable getUser(Integer id){ return usertableMapper.selectByPrimaryKey(id); }

    public Integer update(Usertable user){ return usertableMapper.updateByPrimaryKey(user); }

    public Integer delete(Integer id){ return usertableMapper.deleteByPrimaryKey(id); }

    public Integer insert(Usertable user){ return usertableMapper.insert(user); }

    public Integer getcount(String name){ return usertableMapper.onlineNum(name); }

}
