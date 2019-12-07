package com.springboot.bean;

public class Authority {
    private Integer idauthority;

    private String function;

    private String extend;

    public Integer getIdauthority() {
        return idauthority;
    }

    public void setIdauthority(Integer idauthority) {
        this.idauthority = idauthority;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function == null ? null : function.trim();
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend == null ? null : extend.trim();
    }
}