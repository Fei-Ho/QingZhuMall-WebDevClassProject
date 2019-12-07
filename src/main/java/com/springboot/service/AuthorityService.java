package com.springboot.service;

import com.springboot.bean.Authority;
import com.springboot.dao.AuthorityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorityService {
    @Autowired
    private AuthorityMapper authorityMapper;

    public List<Authority> selectAll(){ return authorityMapper.selectAll(); }

    public Authority get(Integer id){ return authorityMapper.selectByPrimaryKey(id); }

    public Integer updatte(Authority authority){ return authorityMapper.updateByPrimaryKey(authority); }

    public Integer insert(Authority authority){ return authorityMapper.insert(authority); }

    public Integer delete(Integer id){ return authorityMapper.deleteByPrimaryKey(id); }


}
