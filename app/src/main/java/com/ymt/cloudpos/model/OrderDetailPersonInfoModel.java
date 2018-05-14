package com.ymt.cloudpos.model;

/**
 * Created by zhangjifeng on 2018/5/14.
 * email : 414512194@qq.com
 * desc  :
 */

public class OrderDetailPersonInfoModel {
    private String name;
    private String value;

    public OrderDetailPersonInfoModel(String name, String value ) {
        this.value = value;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
