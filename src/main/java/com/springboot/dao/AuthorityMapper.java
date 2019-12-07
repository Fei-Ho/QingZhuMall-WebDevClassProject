package com.springboot.dao;


import com.springboot.bean.Authority;
import com.springboot.bean.Company;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface AuthorityMapper {
    int deleteByPrimaryKey(Integer idauthority);

    int insert(Authority record);

    Authority selectByPrimaryKey(Integer idauthority);

    List<Authority> selectAll();

    int updateByPrimaryKey(Authority record);


}