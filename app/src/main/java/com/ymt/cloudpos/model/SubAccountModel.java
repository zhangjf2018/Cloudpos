package com.ymt.cloudpos.model;

import java.io.Serializable;

/**
 * Created by zhangjifeng on 2018/5/16.
 * email : 414512194@qq.com
 * desc  :
 */

public class SubAccountModel implements Serializable {
    private String name;

    public SubAccountModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
