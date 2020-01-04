package com.springboot.service;

import com.springboot.bean.Goods;
import com.springboot.bean.User;
import com.springboot.dao.GoodsMapper;
import com.springboot.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    public Goods selectByGoodsId(Integer id){
        return goodsMapper.selectByGoodsId(id);
    }

    public ArrayList<Goods> selectByGoodsName(String goods_Name){
        return goodsMapper.selectByGoodsName(goods_Name);
    }

    public ArrayList<Goods> getAll(){
        return goodsMapper.getAll();
    }

    public int insert(Goods good){
        return goodsMapper.insert(good);
    }

    public int deleteById(Integer id){
        return goodsMapper.deleteById(id);
    }

    public int updateById(Goods goods){
        return goodsMapper.updateById(goods);
    }

    public int updateByIdSelective(Goods goods){
        return goodsMapper.updateByIdSelective(goods);
    }

    //根据活动id查询所有属于这个互动的商品
    public ArrayList<Goods> selectByActivityId(Integer activityId){
        return goodsMapper.selectByActivityId(activityId);
    }

    public int addGood2Activity(Integer goodsId,Integer activityId){
        return goodsMapper.addGood2Activity(goodsId,activityId);
    }
}
