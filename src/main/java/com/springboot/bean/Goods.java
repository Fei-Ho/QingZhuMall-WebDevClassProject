package com.springboot.bean;

import java.util.Date;

public class Goods {
    private Integer id;
    private String goodsName;
    private Integer type;
    private Integer goodsPrice;
    private Integer goodsStock;
    private Integer goodsSold;
    private String detail;
    private Date createTime;
    private String str_createTime;
    private Integer priceOriginal;
    private String picURLone;
    private String picURLtwo;

    public Goods(){}

    public String getPicURLone() {
        return picURLone;
    }

    public void setPicURLone(String picURLone) {
        this.picURLone = picURLone;
    }

    public String getPicURLtwo() {
        return picURLtwo;
    }

    public void setPicURLtwo(String picURLtwo) {
        this.picURLtwo = picURLtwo;
    }

    public String getStr_createTime() {
        return str_createTime;
    }

    public void setStr_createTime(String str_createTime) {
        this.str_createTime = str_createTime;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Integer goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(Integer goodsStock) {
        this.goodsStock = goodsStock;
    }

    public Integer getGoodsSold() {
        return goodsSold;
    }

    public void setGoodsSold(Integer goodsSold) {
        this.goodsSold = goodsSold;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getPriceOriginal() {
        return priceOriginal;
    }

    public void setPriceOriginal(Integer priceOriginal) {
        this.priceOriginal = priceOriginal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
