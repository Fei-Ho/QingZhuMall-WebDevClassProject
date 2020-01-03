package com.springboot.bean;

import java.util.Date;

public class Order {
    private Integer id;
    private String orderCode;
    private Integer userId;
    private Integer orderPrice;
    private String detail;
    private Date gmtCreate;
    private String str_gmtCreate;

    public Order(){};

    public Order(Integer id, String orderCode, Integer userId, Integer orderPrice, String detail, Date gmtCreate) {
        this.id = id;
        this.orderCode = orderCode;
        this.userId = userId;
        this.orderPrice = orderPrice;
        this.detail = detail;
        this.gmtCreate = gmtCreate;
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
