package com.ymt.cloudpos.model;

import java.util.List;

/**
 * Created by zhangjifeng on 2018/4/24.
 * email : 414512194@qq.com
 * desc  :
 */

public class LastYearsDangerItemModel {
    private String name;
    private String locPath;

    public LastYearsDangerItemModel(String name, String locPath ) {
        this.name = name;
        this.locPath = locPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocPath() {
        return locPath;
    }

    public void setLocPath(String locPath) {
        this.locPath = locPath;
    }
}
