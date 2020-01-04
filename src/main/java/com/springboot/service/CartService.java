package com.springboot.service;

import com.springboot.bean.Activity;
import com.springboot.bean.ShopCart;
import com.springboot.dao.ActivityMapper;
import com.springboot.dao.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CartService {

    @Autowired
    private CartMapper cartMapper;

    //根据shopCartId选择
    public ShopCart selectByCartId(Integer cartId){
        return cartMapper.selectByCartId(cartId);
    }

    //根据userId获得该用户的购物车数据
    public ArrayList<ShopCart> selectByUserId(Integer userId){
        return cartMapper.selectByUserId(userId);
    }

    //获得所有购物车数据
    public ArrayList<ShopCart> getAll(){
        return cartMapper.getAll();
    }

    public int insert(ShopCart shopCart){
        return cartMapper.insert(shopCart);
    }

    public int deleteById(Integer cartId){
        return cartMapper.deleteById(cartId);
    }

    public int updateById(ShopCart shopCart){
        return cartMapper.updateById(shopCart);
    }

    public int updateByIdSelective(ShopCart shopCart){
        return cartMapper.updateByIdSelective(shopCart);
    }

}
