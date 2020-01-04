package com.springboot.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Integer id;
    private String orderCode;
    private Integer userId;
    private Integer orderPrice;
    private String detail;  //detail包含所有的购物车id
    private String address; //订单收获地址
    private Date gmtCreate;
    private String str_gmtCreate;

    //private List<ShopCart> cartList = new ArrayList<>;//订单对应的购物车数据
    //private List<Goods>

    public Order(){};

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStr_gmtCreate() {
        return str_gmtCreate;
    }

    public void setStr_gmtCreate(String str_gmtCreate) {
        this.str_gmtCreate = str_gmtCreate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Integer orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}
