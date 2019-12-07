package com.springboot.service;

import com.springboot.bean.Company;
import com.springboot.dao.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyMapper companyMapper;

    public int delete(Integer id){ return companyMapper.deleteByPrimaryKey(id); }

    public int insert(Company company){ return companyMapper.insert(company); }

    public Company getone(Integer id){ return companyMapper.selectByPrimaryKey(id); }

    public List<Company> selectAll(){ return companyMapper.selectAll(); }

    public int update(Company company){ return companyMapper.updateByPrimaryKey(company); }

    public List<Company> show(Integer id){ return companyMapper.selectCompanies(id); }
}
