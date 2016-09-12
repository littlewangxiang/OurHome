package com.wx.pro.common.entity;

/**
 * 缴费项目类
 * @author Administrator
 */
public class Specification extends BaseEntity{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}