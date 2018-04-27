package com.ymt.cloudpos.model;

import android.databinding.BaseObservable;

/**
 * Created by zhangjifeng on 2018/4/27.
 * email : 414512194@qq.com
 * desc  :
 */

public class IdUploadModel extends BaseObservable {
    private String name;
    private String locPath;
    private boolean isMust;

    public IdUploadModel(String name, String locPath) {
        this.name = name;
        this.locPath = locPath;
    }

    public IdUploadModel(String name, String locPath, boolean isMust) {
        this.name = name;
        this.locPath = locPath;
        this.isMust = isMust;
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

    public boolean isMust() {
        return isMust;
    }

    public void setMust(boolean must) {
        isMust = must;
    }

}
