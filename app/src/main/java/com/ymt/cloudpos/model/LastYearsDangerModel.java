package com.ymt.cloudpos.model;

import java.util.List;

/**
 * Created by zhangjifeng on 2018/4/24.
 * email : 414512194@qq.com
 * desc  :
 */

public class LastYearsDangerModel {
    private String name;
    private boolean isSwitchOn;
    private List<LastYearsDangerItemModel> dataList;

    public LastYearsDangerModel(String name, boolean isSwitchOn) {
        this.name = name;
        this.isSwitchOn = isSwitchOn;
    }

    public LastYearsDangerModel(String name, boolean isSwitchOn, List<LastYearsDangerItemModel> dataList) {
        this.name = name;
        this.isSwitchOn = isSwitchOn;
        this.dataList = dataList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSwitchOn() {
        return isSwitchOn;
    }

    public void setSwitchOn(boolean switchOn) {
        isSwitchOn = switchOn;
    }

    public List<LastYearsDangerItemModel> getDataList() {
        return dataList;
    }

    public void setDataList(List<LastYearsDangerItemModel> dataList) {
        this.dataList = dataList;
    }
}
