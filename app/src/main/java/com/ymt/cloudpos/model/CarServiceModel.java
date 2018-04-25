package com.ymt.cloudpos.model;

/**
 * Created by zhangjifeng on 2018/4/12.
 * email : 414512194@qq.com
 * desc  :
 */

public class CarServiceModel {
    private int resImgId;
    private String title;
    private Class className;

    public CarServiceModel() {
    }

    public CarServiceModel(int resImgId, String title, Class className) {
        this.resImgId = resImgId;
        this.title = title;
        this.className = className;
    }

    public CarServiceModel(int resImgId, String title) {
        this.resImgId = resImgId;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getResImgId() {
        return resImgId;
    }

    public void setResImgId(int resImgId) {
        this.resImgId = resImgId;
    }

    public Class getClassName() {
        return className;
    }

    public void setClassName(Class className) {
        this.className = className;
    }
}
