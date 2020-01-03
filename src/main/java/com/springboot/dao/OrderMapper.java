package com.springboot.dao;


import com.springboot.bean.Goods;
import com.springboot.bean.Order;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface OrderMapper {

    Order selectByOrderId(Integer id);

    ArrayList<Order> selectByOrderCode(String orderCode);

    ArrayList<Order> getAll();

    int insert(Order order);

    int deleteById(Integer id);

    int updateById(Order order);

    int updateByIdSelective(Order order);
}