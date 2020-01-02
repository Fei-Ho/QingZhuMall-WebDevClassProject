package com.springboot.dao;


import com.springboot.bean.Goods;
import com.springboot.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface GoodsMapper {

    Goods selectByGoodsId(Integer id);

    ArrayList<Goods> selectByGoodsName(String goods_Name);

    ArrayList<Goods> getAll();

    int insert(Goods good);

    int deleteById(Integer id);

    int updateById(Goods goods);

    int updateByIdSelective(Goods goods);
}
