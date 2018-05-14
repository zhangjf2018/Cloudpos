package com.ymt.cloudpos.model;

/**
 * Created by zhangjifeng on 2018/5/14.
 * email : 414512194@qq.com
 * desc  :
 */

public class OrderDetailTypeModel {
    private String name;

    public OrderDetailTypeModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
