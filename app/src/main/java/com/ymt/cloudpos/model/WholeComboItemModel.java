package com.ymt.cloudpos.model;

/**
 * Created by zhangjifeng on 2018/4/24.
 * email : 414512194@qq.com
 * desc  :
 */

public class WholeComboItemModel {
    private String name;
    private String subName;
    private String price;
    private boolean isSwitchOn;
    private boolean isCheckOn;

    public WholeComboItemModel(String name, String subName, String price, boolean isCheckOn, boolean isSwitchOn) {
        this.subName = subName;
        this.price = price;
        this.name = name;
        this.isCheckOn = isCheckOn;
        this.isSwitchOn = isSwitchOn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public boolean isSwitchOn() {
        return isSwitchOn;
    }

    public void setSwitchOn(boolean switchOn) {
        isSwitchOn = switchOn;
    }

    public boolean isCheckOn() {
        return isCheckOn;
    }

    public void setCheckOn(boolean checkOn) {
        isCheckOn = checkOn;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }
}
