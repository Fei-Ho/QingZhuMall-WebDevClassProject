package com.springboot.bean;

import java.sql.Timestamp;
import java.util.Date;

public class User {

    private Integer id;
    private String userName;
    private String password;
    private Integer age;
    private String sex;
    private String mail;
    private String phone;
    private String address;
    private Date createtime;
    private String str_create_time;
    private String address2;
    private String address3;

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getStr_create_time() {
        return str_create_time;
    }

    public void setStr_create_time(String str_create_time) {
        this.str_create_time = str_create_time;
    }

    public User() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Integer getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
