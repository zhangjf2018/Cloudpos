package com.ymt.cloudpos.model;

import java.io.Serializable;

/**
 * Created by zhangjifeng on 2018/4/28.
 * email : 414512194@qq.com
 * desc  :
 */

public class RenewalInsuranceTypeModel implements Serializable {
    private String name;
    private Class clsName;

    public RenewalInsuranceTypeModel( String name, Class clsName) {
        this.clsName = clsName;
        this.name = name;
    }

    public Class getClsName() {
        return clsName;
    }

    public void setClsName(Class clsName) {
        this.clsName = clsName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}