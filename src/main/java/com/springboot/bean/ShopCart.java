package com.springboot.bean;

import java.util.Date;

public class ShopCart {
    private Integer id;
    private Integer userId;
    private Integer goodsId;
    private Integer goodsNum;
    private Double totalPrice;
    private Date gmtCreate;
    private Date gmtModified;
    private String str_gmtCreate;

    //联表查询得到购物车记录对应的商品详细信息
    private Goods good;

    public Goods getGood() {
        return good;
    }

    public void setGood(Goods good) {
        this.good = good;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getStr_gmtCreate() {
        return str_gmtCreate;
    }

    public void setStr_gmtCreate(String str_gmtCreate) {
        this.str_gmtCreate = str_gmtCreate;
    }
}
