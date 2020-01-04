package com.springboot.dao;


import com.springboot.bean.Activity;
import com.springboot.bean.ShopCart;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface CartMapper {

    //根据shopCartId选择
    ShopCart selectByCartId(Integer cartId);

    //根据userId获得该用户的购物车数据
    ArrayList<ShopCart> selectByUserId(Integer userId);

    //获得所有购物车数据
    ArrayList<ShopCart> getAll();

    int insert(ShopCart shopCart);

    int deleteById(Integer cartId);

    int updateById(ShopCart shopCart);

    int updateByIdSelective(ShopCart shopCart);
}