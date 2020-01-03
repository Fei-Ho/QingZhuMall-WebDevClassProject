package com.springboot.service;

import com.springboot.bean.Goods;
import com.springboot.bean.Order;
import com.springboot.dao.OrderMapper;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    public Order selectByOrderId(Integer id){
        return orderMapper.selectByOrderId(id);
    }

    public ArrayList<Order> selectByOrderCode(String orderCode){
        return orderMapper.selectByOrderCode(orderCode);
    }

    public ArrayList<Order> getAll(){
        return orderMapper.getAll();
    }

    public int insert(Order order){
        return orderMapper.insert(order);
    }

    public int deleteById(Integer id){
        return orderMapper.deleteById(id);
    }

    public int updateById(Order order){
        return orderMapper.updateById(order);
    }

    public int updateByIdSelective(Order order){
        return orderMapper.updateByIdSelective(order);
    }

}
