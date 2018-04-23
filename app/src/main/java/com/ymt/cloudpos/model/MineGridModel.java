package com.ymt.cloudpos.model;

/**
 * Created by zhangjifeng on 2018/4/12.
 * email : 414512194@qq.com
 * desc  :
 */

public class MineGridModel {
    private int resImgId;
    private String title;
    private Class  targetCls;

    public Class getTargetCls() {
        return targetCls;
    }

    public void setTargetCls(Class targetCls) {
        this.targetCls = targetCls;
    }

    public MineGridModel() {
    }

    public MineGridModel(int resImgId, String title) {
        this.resImgId = resImgId;
        this.title = title;
    }
    public MineGridModel(int resImgId, String title, Class cls) {
        this.resImgId = resImgId;
        this.title = title;
        this.targetCls = cls;
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
}
