package com.ymt.cloudpos.model;

/**
 * Created by zhangjifeng on 2018/5/14.
 * email : 414512194@qq.com
 * desc  :
 */

public class MineOrderStatusModel {
    private int resImgId;
    private String name;
    private Class cls ;

    public MineOrderStatusModel(int resImgId, String name) {
        this.resImgId = resImgId;
        this.name = name;
    }

    public MineOrderStatusModel(int resImgId, String name, Class cls) {
        this.resImgId = resImgId;
        this.cls = cls;
        this.name = name;
    }

    public int getResImgId() {
        return resImgId;
    }

    public void setResImgId(int resImgId) {
        this.resImgId = resImgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getCls() {
        return cls;
    }

    public void setCls(Class cls) {
        this.cls = cls;
    }
}
