package com.ymt.cloudpos.model;

/**
 * Created by zhangjifeng on 2018/4/26.
 * email : 414512194@qq.com
 * desc  :
 */

public class InsuranceAgentModel {
    private String name;
    private int resImgId;
    private boolean isCheckOn;

    public InsuranceAgentModel(String name, int resImgId) {
        this.name = name;
        this.resImgId = resImgId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResImgId() {
        return resImgId;
    }

    public void setResImgId(int resImgId) {
        this.resImgId = resImgId;
    }

    public boolean isCheckOn() {
        return isCheckOn;
    }

    public void setCheckOn(boolean checkOn) {
        isCheckOn = checkOn;
    }

    @Override
    public String toString() {
        return "InsuranceAgentModel{" +
                "name='" + name + '\'' +
                ", resImgId=" + resImgId +
                ", isCheckOn=" + isCheckOn +
                '}';
    }
}
